package sk.ukf.uloha3.dao;

import sk.ukf.uloha3.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee Employee);
    void deleteById(int id);
}
