package com.project.hms.patient;

public class Patient {
    private static int autoIncrementId = 1;
    
    private int id;
    private String name;
    private int age;
    private String contact;
    private String symptoms;
    
    public Patient(String name, int age, String contact, String symptoms) {
        this.id = autoIncrementId++;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.symptoms = symptoms;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getContact() {
        return contact;
    }
    
    public String getSymptoms() {
        return symptoms;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }
    
    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
}