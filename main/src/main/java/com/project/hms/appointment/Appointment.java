package com.project.hms.appointment;

import java.time.LocalDateTime;

public class Appointment {
    private static int autoIncrementId = 1;

    private int id;
    private int patientId;
    private LocalDateTime appointmentDateTime;
    private String doctor;
    
    public Appointment(int patientId, LocalDateTime appointmentDateTime, String doctor) {
        this.id = autoIncrementId++;
        this.patientId = patientId;
        this.appointmentDateTime = appointmentDateTime;
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }
    
    public int getPatientId() {
        return patientId;
    }
    
    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }
    
    public String getDoctor() {
        return doctor;
    }
    
    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }
    
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}