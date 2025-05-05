package com.techzen.academy_n0325c1.repository;

import com.techzen.academy_n0325c1.modal.Student;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentRepository implements IStudentRepository {

    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1,"Bảo", 4.4),
                    new Student(2,"khang", 8.7),
                    new Student(3,"khôi", 6.8)
            )
    );
    public List<Student> findAll(){
        return students;
    }
    public Student save(Student student){
        student.setId((int)(Math.random()*1000000)); // sau này id đã tự động tăng
        students.add(student);
        return student;
    }
    public Student findById(int id){
        for (Student student : students){
            if (student.getId() == id){
                return student;
            }
        }
        return null;
    }
}
