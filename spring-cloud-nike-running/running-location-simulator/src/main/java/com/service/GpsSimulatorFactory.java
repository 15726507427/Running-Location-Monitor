package com.service;

import com.model.GpsSimulatorRequest;
import com.model.Point;
import com.task.LocationSimulator;

import java.util.List;

public interface GpsSimulatorFactory {

    LocationSimulator prepareGpsSimulator(GpsSimulatorRequest gpsSimulatorRequest);

    LocationSimulator prepareGpsSimulator(LocationSimulator locationSimulator, List<Point> points);
}
