package com.project.hms.records;

import java.time.LocalDateTime;

public class Record {
    private int patientId;
    private LocalDateTime recordDate;
    private String notes;
    private String diagnosis;
    
    public Record(int patientId, LocalDateTime recordDate, String notes, String diagnosis) {
        this.patientId = patientId;
        this.recordDate = recordDate;
        this.notes = notes;
        this.diagnosis = diagnosis;
    }

    public int getPatientId() {
        return patientId;
    }
    
    public LocalDateTime getRecordDate() {
        return recordDate;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public String getDiagnosis() {
        return diagnosis;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}