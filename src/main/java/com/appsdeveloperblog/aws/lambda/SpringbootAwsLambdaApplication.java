package com.appsdeveloperblog.aws.lambda;

import com.appsdeveloperblog.aws.lambda.model.Student;
import com.appsdeveloperblog.aws.lambda.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringbootAwsLambdaApplication {

    @Autowired
    private StudentRepo studentRepo;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAwsLambdaApplication.class, args);
    }

    @Bean
    public Function<String, List<Student>> findstudents() {
        return (input) -> studentRepo.getAllStudents();
    }

    @Bean
    public Function<String, List<Student>> findStudentByName() {
        return (input) -> studentRepo.getAllStudents().stream()
                .filter(st -> st.getName().equals(input))
                .collect(Collectors.toList());
    }
}