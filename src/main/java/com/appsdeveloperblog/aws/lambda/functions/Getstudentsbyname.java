package com.appsdeveloperblog.aws.lambda.functions;

import com.appsdeveloperblog.aws.lambda.model.Student;
import com.appsdeveloperblog.aws.lambda.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class Getstudentsbyname implements Function<String, List<Student>> {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> apply(String input) {
        return studentRepo.getAllStudents().stream()
                .filter(st -> st.getName().equals(input))
                .collect(Collectors.toList());
    }
}