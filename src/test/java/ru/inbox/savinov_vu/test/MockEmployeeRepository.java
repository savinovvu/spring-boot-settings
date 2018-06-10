package ru.inbox.savinov_vu.test;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;



@Repository
@Profile("test")
public class MockEmployeeRepository implements EmployeeRepository {

    @Override
    public List<Employee> findAll() {
        return Arrays.asList(
                new Employee(1, "A", 50000),
                new Employee(2, "B", 75000),
                new Employee(3, "C", 43000));
    }


/*    @Override
    public List<Employee> findAll() {
        return null;
    }*/


    @Override
    public List<Employee> findAll(Sort sort) {
        return null;
    }


    @Override
    public List<Employee> findAllById(Iterable<Integer> integers) {
        return null;
    }


    @Override
    public <S extends Employee> List<S> saveAll(Iterable<S> entities) {
        return null;
    }


    @Override
    public void flush() {

    }


    @Override
    public <S extends Employee> S saveAndFlush(S entity) {
        return null;
    }


    @Override
    public void deleteInBatch(Iterable<Employee> entities) {

    }


    @Override
    public void deleteAllInBatch() {

    }


    @Override
    public Employee getOne(Integer integer) {
        return null;
    }


    @Override
    public <S extends Employee> List<S> findAll(Example<S> example) {
        return null;
    }


    @Override
    public <S extends Employee> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }


    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return null;
    }


    @Override
    public <S extends Employee> S save(S entity) {
        return null;
    }


    @Override
    public Optional<Employee> findById(Integer integer) {
        return Optional.empty();
    }


    @Override
    public boolean existsById(Integer integer) {
        return false;
    }


    @Override
    public long count() {
        return 0;
    }


    @Override
    public void deleteById(Integer integer) {

    }


    @Override
    public void delete(Employee entity) {

    }


    @Override
    public void deleteAll(Iterable<? extends Employee> entities) {

    }


    @Override
    public void deleteAll() {

    }


    @Override
    public <S extends Employee> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }


    @Override
    public <S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }


    @Override
    public <S extends Employee> long count(Example<S> example) {
        return 0;
    }


    @Override
    public <S extends Employee> boolean exists(Example<S> example) {
        return false;
    }
}

