package com.techzen.academy_n0325c1.Ngay2.controller;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    // (Universally Unique Identifier) là một kiểu dữ liệu dùng để biểu diễn một giá trị định danh duy nhất
    UUID id;
    String name;
    // DOB = Date of Birth
    LocalDate DOB;
    Gender gender;
    double salary;
    String phone;
    Integer departmentId;

    public Employee() {
    }

    public Employee(UUID id, String name, LocalDate DOB, Gender gender, double salary, String phone, Integer departmentId) {
        this.id = id;
        this.name = name;
        this.DOB = DOB;
        this.gender = gender;
        this.salary = salary;
        this.phone = phone;
        this.departmentId = departmentId;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public Gender getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}


