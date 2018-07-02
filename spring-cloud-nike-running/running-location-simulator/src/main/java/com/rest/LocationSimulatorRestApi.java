package com.rest;

import com.model.GpsSimulatorRequest;
import com.model.SimulatorInitLocations;
import com.service.GpsSimulatorFactory;
import com.service.PathService;
import com.task.LocationSimulator;
import com.task.LocationSimulatorInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/api")
public class LocationSimulatorRestApi {

    @Autowired
    // @TODO: Here we need to add path service
    private PathService pathService;

    @Autowired
    private GpsSimulatorFactory gpsSimulatorFactory;

    @Autowired
    private AsyncTaskExecutor taskExecutor;

    private Map<Long, LocationSimulatorInstance> taskFutures = new HashMap<>();

    // 1. LoadSimulatorInitLocation
    // 2. Transform domain model simulator request to a class that can be executed by task executor
    // 3. taskExecutor.submit(simulator)
    // 4. simulator starts

    @RequestMapping("/simulation")
    public List<LocationSimulatorInstance> simulation() {
        final SimulatorInitLocations fixture = this.pathService.loadSimulatorInitLocations();

        final List<LocationSimulatorInstance> instances = new ArrayList<>();

        for (GpsSimulatorRequest gpsSimulatorRequest : fixture.getGpsSimulatorRequests()) {
            final LocationSimulator locationSimulator = gpsSimulatorFactory.prepareGpsSimulator(gpsSimulatorRequest);

            final Future<?> future = taskExecutor.submit(locationSimulator);
            final LocationSimulatorInstance instance = new LocationSimulatorInstance(locationSimulator.getId(), locationSimulator, future);
            taskFutures.put(locationSimulator.getId(), instance);
            instances.add(instance);
        }

        return instances;
    }

    @RequestMapping("/cancel")
    public int cancel() {
        int numberOfCancelledTasks = 0;

        for (Map.Entry<Long, LocationSimulatorInstance> entry : taskFutures.entrySet()) {
            LocationSimulatorInstance instance = entry.getValue();
            instance.getLocationSimulator().cancel();
            boolean wasCancelled = instance.getLocationSimulatorTask().cancel(true);
            if (wasCancelled) {
                numberOfCancelledTasks++;
            }
        }
        taskFutures.clear();
        return numberOfCancelledTasks;
    }
}
