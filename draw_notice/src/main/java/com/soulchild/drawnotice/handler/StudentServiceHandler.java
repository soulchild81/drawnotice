package com.soulchild.drawnotice.handler;

import com.soulchild.drawnotice.model.Student;
import com.soulchild.drawnotice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentServiceHandler {
    @Autowired
    public StudentService studentService;

    public Mono<ServerResponse> getStudent(ServerRequest request) {
        Student student = studentService.getStudent(request.pathVariable("number"));

        return ServerResponse.ok().body(Mono.just(student), Student.class);
    }

    public Mono<ServerResponse> getStudents(ServerRequest request) {
        List<Student> studentList = studentService.getStudents();

        return ServerResponse.ok().body(Flux.fromIterable(studentList), Student.class);
    }
}
