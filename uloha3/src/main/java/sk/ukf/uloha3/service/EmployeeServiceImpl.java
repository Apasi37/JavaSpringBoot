package sk.ukf.uloha3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.ukf.uloha3.dao.EmployeeRepository;
import sk.ukf.uloha3.entity.Employee;

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
        return EmployeeRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Employee save(Employee Employee) {
        return EmployeeRepository.save(Employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        EmployeeRepository.deleteById(id);
    }
}
