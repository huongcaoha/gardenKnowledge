package com.ra.session01.repository;

import com.ra.session01.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface StudentRepository extends JpaRepository<Student, Long> {
    Student getStudentByUsername(String username);

    @Query("select count(s.id) from Student s where s.username = :_username ")
    long checkUsernameExisted(@Param("_username") String username);

}
