package com.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicalInfo {

    private String bandMake;
    private String medCode;
    private String medicalInfoId;
    private String medicalInfoClassification;
    private String description;
    private String aidInstruction;
    private String fmi;
    private String bfr;
}
