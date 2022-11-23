package codegym.vn.service;

import codegym.vn.bean.Student;
import codegym.vn.repository.StudentReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentReponsitory studentReponsitory;

    @Override
    public void createOrUpdate(Student s) {
        studentReponsitory.createOrUpdate(s);
    }

    @Override
    public Student findById(String id) {
        return studentReponsitory.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentReponsitory.findAll();
    }

    @Override
    public void deleteById(String id) {
        studentReponsitory.deleteById(id);

    }
}
