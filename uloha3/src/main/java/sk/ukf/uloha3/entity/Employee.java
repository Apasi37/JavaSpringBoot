package sk.ukf.uloha3.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate date;

    @Column(name = "email")
    private String email;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "full_time")
    private Boolean full_time;

    public Employee() {
    }

    public Employee(String firstName, String lastName, LocalDate date, String email, String phone, String jobTitle, BigDecimal salary, Boolean full_time) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.email = email;
        this.phone = phone;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.full_time = full_time;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Boolean getFull_time() {
        return full_time;
    }

    public void setFull_time(Boolean full_time) {
        this.full_time = full_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
