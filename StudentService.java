package com.example.Student.service;

import com.example.Student.Exception.StudentNotFoundException;
import com.example.Student.Repository.StudentRepository;
import com.example.Student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService
{
    @Autowired
    StudentRepository studentRepo;
//----------------------------------------------------------------------
    //GetMappping................
    public List<Student> getAllStudent()
    {
        return studentRepo.findAll();
    }
//---------------------------------------------------------------------
    //PostMapping........
    public void addStudents(Student student)
    {
        studentRepo.save(student);
    }
//------------------------------------------------------------------------
    //find by particular..id
    public Student getStudentByRno(int rno)
    {                                  //orElseThrow();-->is built in exception -->we use
                                     //orElseThrow(()->);-->we use->custom Exception/..

        return studentRepo.findById(rno).//orElseThrow(); // orElse(null);-->this is normal
                                         // - without exception.
                 orElseThrow(()-> new StudentNotFoundException
                                                 ("student not found with rno :"
                                                 +rno));
    }
//---------------------------------------------------------------------------
   //update..
    public void UpdateStudent(Student student)
    {
        studentRepo.save(student);
    }
//--------------------------------------------------------------------
    //delete by id.........
    public void deleteStudentByRno(int rollno)
    {
     studentRepo.deleteById(rollno);
    }
//--------------------------------------------------------------------
    //delete all...........
    public void clearStudent()
    {
        studentRepo.deleteAll();
    }
//----------------------------------------------------------------
    //student,find  by technology............
    public List<Student> getStudentsByTechnology(String technology)
    {
        return studentRepo.findByTechnology(technology);
    }
//-------------------------------------------------------------------
    //more than 1.method...so use native query by own..
    public List<Student> getStudentByGenderAndTechnology(String gender, String technology)
    {
        return studentRepo.findByGenderAndTechnology(gender,technology);
    }
}
