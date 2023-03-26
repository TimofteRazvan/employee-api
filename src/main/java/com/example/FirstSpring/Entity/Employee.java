package com.example.FirstSpring.Entity;

import jakarta.persistence.*;

import java.util.*;

@Entity(name = "Employee")
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int id;
    private String name;
    private String city;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="fk_spouse")
    private Spouse spouse;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Address> addresses;
    private int age=0;

    /*
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

     */

    /*
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "employee_project",
            joinColumns = @JoinColumn(name = "fk_employee"),
            inverseJoinColumns = @JoinColumn(name = "fk_project"))
    private Set<Project> projects = new HashSet<>();
    */

    /*
    @OneToMany(mappedBy = "employee")
    private List<EmployeeProject> projects = new ArrayList<>();
    */

    public Employee() {
    }

    public Employee(int id, String name, String city, int age) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public Employee(int id, String name, String city, Spouse spouse, int age) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.spouse = spouse;
        this.age = age;
    }

    public Employee(String name, String city, int age) {
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

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

/*
    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public void removeProject(Project project) {
        this.projects.remove(project);
        project.getEmployees().remove(project);
    }

    public void addProject(Project project) {
        this.projects.add(project);
        project.getEmployees().add(this);
    }

    public void addAddress(Address address) {
        this.addresses = new ArrayList<>();
        this.addresses.add(address);
        address.setEmployee(this);
    }

    public void removeAddress(Address address) {
        this.addresses.remove(address);
        address.setEmployee(null);
    }
    */

    /*
    public List<EmployeeProject> getProjects() {
        return projects;
    }

    public void setProjects(List<EmployeeProject> projects) {
        this.projects = projects;
    }
     */

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*
    public void addProject(Project project, String role, String efficiency) {
        EmployeeProject employeeProject = new EmployeeProject(this, project, role, efficiency);
        projects.add(employeeProject);
        project.getEmployees().add(employeeProject);
    }

    public void removeProject(Project project) {
        for(Iterator<EmployeeProject> iterator = projects.iterator(); iterator.hasNext();) {
            EmployeeProject employeeProject = iterator.next();

            if(employeeProject.getEmployee().equals(this) && employeeProject.getProject().equals(project)) {
                iterator.remove();
                employeeProject.getProject().getEmployees().remove(employeeProject);
                employeeProject.setEmployee(null);
                employeeProject.setProject(null);
            }
        }
    }
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
