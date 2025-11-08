package sk.ukf.restapi.dao;

import sk.ukf.restapi.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee Employee);
    void deleteById(int id);
}
