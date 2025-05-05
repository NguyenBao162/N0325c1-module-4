package com.techzen.academy_n0325c1.service;

import com.techzen.academy_n0325c1.modal.Student;

import java.util.List;

public interface IStudentService  {
    public List<Student> findAll();
    public Student save(Student student);
    public Student findById(int id);
}
