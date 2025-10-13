package sk.ukf.uloha3.service;

import sk.ukf.uloha3.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee Employee);
    void deleteById(int id);
}
