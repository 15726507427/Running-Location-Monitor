package com.model;

import lombok.Data;

@Data
public class GpsSimulatorRequest {

    private String runningId;
    private double speed;
    private boolean move = true;

    private boolean exportPositionsToMessaging = true;
    private Integer reportInterval = 500;

    private RunnerStatus runnerStatus = RunnerStatus.NONE;

    private String polyLine;

    private MedicalInfo medicalInfo;
}
