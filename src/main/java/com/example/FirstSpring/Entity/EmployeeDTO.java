package com.example.FirstSpring.Entity;

public class EmployeeDTO implements Comparable<EmployeeDTO> {
    int id;
    private String name;
    private String city;
    private int age;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int id, String name, String city, int age) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(EmployeeDTO o) {
        return Integer.compare(this.age, o.getAge());
    }
}
