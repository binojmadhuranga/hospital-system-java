package com.example.acpt.demo.dto;

public class DoctorDto {

    private int id;
    private String name;
    private int age;
    private String email;
    private String specialization;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


    public DoctorDto() {

    }

    public DoctorDto(int id, String name,int age, String email, String specialization) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.specialization = specialization;
    }


    public DoctorDto( String name,int age, String email, String specialization) {
        this.name = name;
        this.age = age; // Default age if isn't provided
        this.email = email;
        this.specialization = specialization;
    }
}
