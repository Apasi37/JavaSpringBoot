package sk.ukf.uloha3.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.ukf.uloha3.entity.Employee;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> Employees = query.getResultList();
        return Employees;
    }

    @Override
    public Employee findById(int id) {
        Employee Employee = entityManager.find(Employee.class, id);
        return Employee;
    }

    @Override
    public Employee save(Employee Employee) {
        Employee Employee_db = entityManager.merge(Employee);
        return Employee_db;
    }

    @Override
    public void deleteById(int id) {
        Employee Employee = entityManager.find(Employee.class, id);
        entityManager.remove(Employee);
    }
}
