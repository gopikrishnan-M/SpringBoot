package com.example.JPAproject.Service;

import com.example.JPAproject.Model.Student;
import com.example.JPAproject.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public String addStudent(Student student) {
        studentRepository.save(student);
        return "table updated successfully...";
    }

    public Optional<Student> getStdByRoll(int roll) {
        return studentRepository.findById(roll);
    }

    public void updateByroll(Student student) {
        studentRepository.save(student);//save will check for pre-existing id if
        //present it updates it else add it as new row tats why we use it for both add and update
    }

    public void deleteByRoll(int roll) {
        studentRepository.deleteById(roll);
    }

    public List<Student> getStudentsByTech(String technology) {
        return studentRepository.findByTechnology(technology);
    }

    public List<Student> getStudentsByGender(String gender) {
        return studentRepository.findByGender(gender);
    }

    public List<Student> getStudentByGenderAndTechnology(String gender, String technology) {
        return studentRepository.findByGenderAndTechnology(gender,technology);
    }

    public Student getStdByRollResponse(int roll) {
        return studentRepository.findById(roll).orElse(null);
    }

    public void addStudent(int rno, String name, String gender, String technology) {
        studentRepository.save(new Student(gender,name,rno,technology));
    }
}
