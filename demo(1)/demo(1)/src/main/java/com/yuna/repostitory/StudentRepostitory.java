package com.yuna.repostitory;


import com.yuna.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentRepostitory extends JpaRepository<Student, Integer> {
    @Query(value = "select * from t_student where department_id=?1", nativeQuery = true)
    List<Student> getStudentsByDepartmentId(Integer id);

}