package com.example.FirstSpring.Entity;

import jakarta.persistence.Entity;

public class SpouseDTO implements Comparable<SpouseDTO> {
    int id;
    private String name;
    private String phone;
    private int age;
    private boolean working;

    public SpouseDTO() {
    }

    public SpouseDTO(int id, String name, String phone, int age, boolean working) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.working = working;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    @Override
    public int compareTo(SpouseDTO o) {
        return Integer.compare(this.getAge(), o.getAge());
    }
}
