package ru.inbox.savinov_vu.test;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Profile("default")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//    List<Employee> findAll();
}
