package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppDAO {
    void save(Instructor instructor);
    Instructor findIntructorById(int theId);
    void deleteInstructorById(int theId);
}
