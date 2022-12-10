package com.example.demostudent.formatter;

import com.example.demostudent.entity.Student;
import com.example.demostudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class StudentFormatter implements Formatter<Student> {
    private StudentService service;
    @Autowired
    public StudentFormatter(StudentService service) {
        this.service = service;
    }
    @Override
    public Student parse(String text, Locale locale) throws ParseException {
        return service.findById(text);
    }

    @Override
    public String print(Student object, Locale locale) {
        return object.toString();
    }
}
