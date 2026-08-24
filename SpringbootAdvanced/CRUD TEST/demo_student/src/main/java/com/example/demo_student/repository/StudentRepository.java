package com.example.demo_student.repository;

import com.example.demo_student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE student SET id = :newId WHERE id = :oldId", nativeQuery = true)
    int updatePrimaryKey(
            @Param("oldId") Long oldId,
            @Param("newId") Long newId
    );
}