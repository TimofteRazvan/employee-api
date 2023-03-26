package com.example.FirstSpring.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CollectionIdJavaType;

import java.util.Objects;

@Entity(name = "EmployeeProject")
@Table(name = "employees_projects")
public class EmployeeProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employees_projects_id")
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "project_id")
    private Project project;
    private String role;
    private String efficiency;

    public EmployeeProject() {
    }

    public EmployeeProject(Employee employee, Project project, String role, String efficiency) {
        this.employee = employee;
        this.project = project;
        this.role = role;
        this.efficiency = efficiency;
    }

    public EmployeeProject(Employee employee, Project project) {
        this.employee = employee;
        this.project = project;
        this.role = "N/A";
        this.efficiency = "N/A";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeProject that = (EmployeeProject) o;
        return Objects.equals(employee, that.employee) && Objects.equals(project, that.project) && Objects.equals(role, that.role) && Objects.equals(efficiency, that.efficiency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, project, role, efficiency);
    }
}
