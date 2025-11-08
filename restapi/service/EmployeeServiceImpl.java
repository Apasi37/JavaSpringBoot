package sk.ukf.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.ukf.restapi.dao.EmployeeRepository;
import sk.ukf.restapi.entity.Employee;
import sk.ukf.restapi.exception.EmailAlreadyExistsException;
import sk.ukf.restapi.exception.ObjectNotFoundException;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository EmployeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository EmployeeRepository) {
        this.EmployeeRepository = EmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return EmployeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return EmployeeRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("employee", id));
    }

    @Transactional
    @Override
    public Employee save(Employee Employee) {
        if (Employee.getId() == 0) {
            if (EmployeeRepository.existsByEmail(Employee.getEmail())) {
                throw new EmailAlreadyExistsException(Employee.getEmail());
            }
        } else {
            Employee existingWithEmail = EmployeeRepository.findByEmail(Employee.getEmail()).orElse(null);
            if (existingWithEmail != null && existingWithEmail.getId() != Employee.getId()) {
                throw new EmailAlreadyExistsException(Employee.getEmail());
            }
        }

        return EmployeeRepository.save(Employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        if (!EmployeeRepository.existsById(id)) {
            throw new ObjectNotFoundException("employee", id);
        }
        EmployeeRepository.deleteById(id);
    }
}
