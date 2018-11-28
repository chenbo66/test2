package com.yuna.demo;

import com.yuna.entity.Department;
import com.yuna.entity.Student;
import com.yuna.repostitory.DepartmentRepository;
import com.yuna.repostitory.StudentRepostitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private StudentRepostitory studentRepostitory;

    @Autowired
    private DepartmentRepository departmentRepository;

    /**
     * 增加
     */
    @PostMapping("/insert")
    public void insertDepartment(Department department) {

        departmentRepository.save(department);
    }

    /**
     * 更改
     */
    @PutMapping("/update")
    public void updateDepartment(Department department) {

        departmentRepository.save(department);
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Map<String, Object> deleteDepartment(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();

        List<Student> studentsByDepartmentId = studentRepostitory.getStudentsByDepartmentId(id);
        if (studentsByDepartmentId.size() == 0) {
            departmentRepository.deleteById(id);
            map.put("status", true);
        } else {
            map.put("status", false);
        }
        return map;
    }

    /**
     * 查询所有
     */
    @GetMapping("/all")
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    /**
     * 查单个
     */
    @GetMapping("/get/{id}")
    public Department getDepartmentById(@PathVariable Integer id) {

        return departmentRepository.findById(id).get();
    }
}
