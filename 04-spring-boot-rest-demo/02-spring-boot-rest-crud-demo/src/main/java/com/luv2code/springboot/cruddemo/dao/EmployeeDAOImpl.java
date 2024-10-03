package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> theQuery = entityManager.createQuery(
                "from Employee",Employee.class);
        List<Employee> employees = theQuery.getResultList();
        return employees;

    }

    @Override
    public Employee findById(int id) {
        Employee emp = entityManager.find(Employee.class,id);
        return emp;
    }

    @Override
    public Employee save(Employee emp) {

        Employee dbEmp = entityManager.merge(emp);

        return dbEmp;
    }

    @Override
    public void deleteById(int id) {

        Employee emp = entityManager.find(Employee.class,id);
        entityManager.remove(emp);
    }
}
