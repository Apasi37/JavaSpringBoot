package sk.ukf.uloha3.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.ukf.uloha3.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //nie je potrebné písať žiaden kód
}
