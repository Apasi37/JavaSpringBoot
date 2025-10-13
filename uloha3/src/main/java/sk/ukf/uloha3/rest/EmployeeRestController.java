package sk.ukf.uloha3.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.ukf.uloha3.entity.Employee;
import sk.ukf.uloha3.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService EmployeeService;

    @Autowired
    public EmployeeRestController(EmployeeService EmployeeService) {
        this.EmployeeService = EmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return EmployeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {

        Employee Employee = EmployeeService.findById(id);

        if (Employee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        return Employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee Employee) {
        Employee.setId(0);
        Employee Employee_db = EmployeeService.save(Employee);
        return Employee_db;
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee Employee) {
        Employee existingEmployee = EmployeeService.findById(id);
        if (existingEmployee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }
        Employee.setId(id);
        Employee updatedEmployee = EmployeeService.save(Employee);
        return updatedEmployee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {

        Employee Employee = EmployeeService.findById(id);

        if (Employee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        EmployeeService.deleteById(id);

        return "Deleted Employee id - " + id;
    }
}
