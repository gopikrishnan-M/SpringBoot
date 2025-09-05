package com.example.JPAproject.Repository;

import com.example.JPAproject.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> findByTechnology(String technology);

    List<Student> findByGender(String gender);
    //even space in between the "=:technology" like   "=: technology" will cause error
    @Query(nativeQuery = true,value = "SELECT * FROM student WHERE gender =:gender AND technology =:technology")
    List<Student> findByGenderAndTechnology(
            @Param("gender")String gender,
            @Param("technology")String technology);

    //THIS ALSO WORKS
    /*@Query(nativeQuery = true,value = "SELECT * FROM student WHERE gender =:gender AND technology =:technology")
    List<Student> findByGenderAndTechnology(
            String gender,
            String technology);*/



    //BELOW ONE IS GIVEN BY PERPLEXITY TAT TOO WORKS
//    @Query(value = "SELECT * FROM student WHERE gender = ?1 AND technology = ?2", nativeQuery = true)
//    List<Student> filterByGenderAndTechnology(String gender, String technology);


}
