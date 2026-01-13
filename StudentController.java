package com.example.Student.controller;

import com.example.Student.Exception.StudentNotFoundException;
import com.example.Student.model.Student;
import com.example.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class StudentController
{
    @Autowired
    StudentService studentServ;
//-------------------------------------------------------------
    @GetMapping("/students")
    public List<Student> getAllStudent()
    {
        return studentServ.getAllStudent();
    }
//---------------------------------------------------------------
   @PostMapping("/students")
   public ResponseEntity<String> addStudents(@RequestBody Student student)
   {
       studentServ.addStudents(student);
       return new ResponseEntity<>("added",HttpStatus.CREATED);
   }
//---------------------------------------------------------------------
 //Get student by particular rno....
    //-->this below only response entity & httpsStatus..without Exeception..
   @GetMapping("/students/{rno}")
/*   public ResponseEntity<Student> getStudentByRno(@PathVariable ("rno") int rno)
   {
      Student student=studentServ.getStudentByRno(rno);
      if(student==null)
      {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      else
      {
          return new ResponseEntity<>(student,HttpStatus.OK);
      }
   }                                  */
 //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
  //now wee see using--> Try-Catch Exception -->built in & custom...ok
//   public ResponseEntity<?>getStudentByRno(@PathVariable ("rno")int rno)
//   {
//       try
//       {
//           Student student = studentServ.getStudentByRno(rno);
//           return new ResponseEntity<>(student,HttpStatus.OK);
//       }  //built-in..                     //custom by me..
//       catch (/*NoSuchElementException*/StudentNotFoundException ex)
//       {
//           return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
//       }
//       catch (Exception ex)
//       {
//           return new ResponseEntity<>
//                   ("Something Went Wrong..!!",HttpStatus.INTERNAL_SERVER_ERROR);
//       }
//   }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
   // now we see--> globalExceptinHandler -->Built-in& custom.ok
   public ResponseEntity<?>getStudentByRno(@PathVariable ("rno")int rno)
   {
       Student student  = studentServ.getStudentByRno(rno);
       return new ResponseEntity<>(student,HttpStatus.OK);
   }

//--------------------------------------------------------------------------
 //update student.......
   @PutMapping("/students")
   public ResponseEntity<String> UpdateStudent(@RequestBody Student student)
   {
       studentServ.UpdateStudent(student);
       return new ResponseEntity<>("Updated..!!",HttpStatus.ACCEPTED);
   }
 //----------------------------------------------------------------------
 //delete....
    @DeleteMapping("/students/{rno}")
    public String deleteStudentByRno(@PathVariable ("rno")int rollno)
    {
        studentServ.deleteStudentByRno(rollno);
        return "deleted....by id..!! succesfull";
    }
 //------------------------------------------------------------------------
   //delete whole record...
   @DeleteMapping("/students/clear")
   public String clearStudent()
   {
       studentServ.clearStudent();
       return "cleared Successfully..!!!";
   }
//---------------------->declaring own method.............search by technologyl...
   @GetMapping("students/technology/{tech}")
    public List<Student> getStudentByTechnology(@PathVariable ("tech")String technology)
   {
      return studentServ.getStudentsByTechnology(technology);
   }
//---------------------------------------------------------------------
//-------->now we see -|>native Query   =====> bcoz more than 1 method so...we use...
 //--------->we do manually without help of hibernate....
   @PostMapping("/students/filter")
   public List<Student> getStudentByGenderAndTechnology(@RequestParam ("gender")String gender,
                                                        @RequestParam ("technology")String technology)
   {
       return studentServ.getStudentByGenderAndTechnology(gender,technology);
   }
}
