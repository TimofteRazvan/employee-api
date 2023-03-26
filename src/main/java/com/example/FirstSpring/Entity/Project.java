package com.example.FirstSpring.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Project")
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int id;
    private String name;
    private String clientName;
    private String language;
    private LocalDate deadline;

    // JSONIGNORE required to avoid endless looping when doing GET with POSTMAN
    /*
    @JsonIgnore
    @ManyToMany(mappedBy = "projects", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();
     */

    /*
    @OneToMany(mappedBy = "project")
    private List<EmployeeProject> employees = new ArrayList<>();
    */

    public Project() {

    }

    public Project(String name, String clientName) {
        this.name = name;
        this.clientName = clientName;
    }

    public Project(String name, String clientName, String language, LocalDate deadline) {
        this.name = name;
        this.clientName = clientName;
        this.language = language;
        this.deadline = deadline;
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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    /*
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
     */

    /*
    public List<EmployeeProject> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeProject> employees) {
        this.employees = employees;
    }
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id == project.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
