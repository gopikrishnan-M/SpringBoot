package com.example.FirstSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(FirstSpringBootApplication.class, args);
		Student student=context.getBean(Student.class);
		student.writeExam();


//		Student student1=context.getBean(Student.class);
//		student.show();
//		student1.show();
//		student.age=21;
//		System.out.println(student.age + " : " + student1.age);
	}

}
