package com.divvya.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Employee {
    
    @Id
    private Integer id;  // Changed from eId to id for better convention
    
    private String name;
    
    @Transient
    private String city;
    private Integer age;

    public Employee() {
        System.out.println("Zero Param Constructor for Hibernate");
    }

    // Standard getters and setters (without 'e' prefix)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", city=" + city + ", age=" + age + "]";
    }
}