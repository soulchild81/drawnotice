package com.soulchild.drawnotice.controller;

import com.soulchild.drawnotice.model.Student;
import com.soulchild.drawnotice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    public StudentService studentService;

//    @GetMapping("/students/{number}")
//    public Mono<Student> getStudent(@PathVariable("number") String number) {
//        return Mono.just(studentService.getStudent(number));
//    }
//
//    @GetMapping("/students")
//    public Flux<Student> getStudents() {
//        return Flux.fromIterable(studentService.getStudents());
//    }
}
