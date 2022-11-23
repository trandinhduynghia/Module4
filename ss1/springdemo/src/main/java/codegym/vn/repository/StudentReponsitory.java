package codegym.vn.repository;

import codegym.vn.bean.Student;

import java.util.List;

public interface StudentReponsitory {
    void createOrUpdate(Student s);

    Student findById(String id);

    List<Student> findAll();

    void deleteById(String id);
}
