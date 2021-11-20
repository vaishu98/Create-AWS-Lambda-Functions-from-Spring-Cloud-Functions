package com.appsdeveloperblog.aws.lambda.functions;

import com.appsdeveloperblog.aws.lambda.model.Student;
import com.appsdeveloperblog.aws.lambda.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class Getstudents implements Function<String, List<Student>> {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> apply(String s) {
        return studentRepo.getAllStudents();
    }
}