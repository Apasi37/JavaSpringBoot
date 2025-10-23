package sk.ukf.restapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Meno je povinné")
    @Size(min = 2, max = 50, message = "Meno musí mať 2-50 znakov")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Priezvisko je povinné")
    @Size(min = 2, max = 50, message = "Priezvisko musí mať 2-50 znakov")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message="Dátum narodeniny je povinný")
    @Column(name = "birth_date")
    private LocalDate date;

    @NotBlank(message = "Email je povinný")
    @Size(max = 254, message = "Email musí byť kratší ako 254 znakov")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$" , message = "Neplatný email")
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank(message = "Telefónne čislo je povinné")
    @Size(min = 13, max = 15, message = "Priezvisko musí mať 13-15 znakov")
    @Pattern(regexp = "^\\+421\\d{9}$" , message = "Telefónne číslo musí začínať +421 a obsahovať presne 9 číslic za ním.")
    @Column(name = "phone")
    private String phone;

    @NotBlank(message = "Názov práce je povinný")
    @Size(min = 2, max = 50, message = "Priezvisko musí mať 2-50 znakov")
    @Column(name = "job_title")
    private String jobTitle;

    @NotNull(message="Plat je povinný")
    @Column(name = "salary")
    private BigDecimal salary;

    @NotNull(message="Full time je povinný")
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
