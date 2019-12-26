package com.soulchild.drawnotice.service;

import com.soulchild.drawnotice.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    private static final Map<String, Student> REPOSITORY = new HashMap<>();



    public Student getStudent(String number) {
        Student stu = new Student();
        return stu;
    }

    public List<Student> getStudents() {
        List<Student> stulist = new ArrayList<Student>();
        for (int i = 0; i < 50; i++) {
            Student stu = new Student();

            stulist.add(stu);
        }
        return stulist;
    }
}
