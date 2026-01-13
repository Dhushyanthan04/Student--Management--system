package com.example.Student.Repository;

import com.example.Student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>
{
//-------------------------------------------------------------------------
   //declare method ==>single method..
   //find by technolgy.......
   List<Student> findByTechnology (String technology);
//---------------------------------------------------------------------
   //more than 1 method...native query
   // findByGenderAndTechnology.........
   @Query(nativeQuery = true,
   value = "select * from student where gender =:gender and technology =:" +
           "technology")
   List<Student> findByGenderAndTechnology(@Param("gender")String gender,
                                          @Param("technology") String technology );
}
