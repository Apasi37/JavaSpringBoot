package sk.ukf.restapi.rest;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.ukf.restapi.dto.ApiResponse;
import sk.ukf.restapi.entity.Employee;
import sk.ukf.restapi.service.EmployeeService;

import java.time.LocalDateTime;
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
    public ResponseEntity<ApiResponse<List<Employee>>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(EmployeeService.findAll(), "Employee úspešne pridaný", LocalDateTime.now()));
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<ApiResponse<Employee>> getEmployee(@PathVariable int id) {

        Employee Employee = EmployeeService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(Employee, "Employee sa našiel", LocalDateTime.now()));
    }

    @PostMapping("/employees")
    public ResponseEntity<ApiResponse<Employee>> addEmployee(@Valid @RequestBody Employee Employee) {
        Employee.setId(0);
        Employee Employee_db = EmployeeService.save(Employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(Employee_db, "Employee úspešne pridaný", LocalDateTime.now()));
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<ApiResponse<Employee>> updateEmployee(@PathVariable int id, @Valid @RequestBody Employee Employee) {

        EmployeeService.findById(id);

        Employee.setId(id);
        Employee updatedEmployee = EmployeeService.save(Employee);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(updatedEmployee, "Employee úspešne aktualizovaný", LocalDateTime.now()));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<ApiResponse<Employee>> deleteEmployee(@PathVariable int id) {

        Employee Employee = EmployeeService.findById(id);

        EmployeeService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("Employee úspešne odstránený", LocalDateTime.now()));
    }
}
