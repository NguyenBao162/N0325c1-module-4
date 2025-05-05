//package com.techzen.academy_n0325c1.service;
//
//import com.techzen.academy_n0325c1.modal.Student;
//import com.techzen.academy_n0325c1.repository.IStudentRepository;
//import com.techzen.academy_n0325c1.repository.StudentRepository;
//import lombok.AccessLevel;
//import lombok.experimental.FieldDefaults;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//public class StudentService implements IStudentService {
//    IStudentRepository studentRepository = new StudentRepository();
//
//    public List<Student> findAll(){
//        return studentRepository.findAll();
//    }
//    public Student save(Student student){
//        return studentRepository.save(student);
//    }
//    public Student findById(int id){
//                return studentRepository.findById(id);
//            }
//}
