//package com.techzen.academy_n0325c1.Ngay1.Bai4_Employee;
//
//import java.time.LocalDate;
//import java.util.UUID;
//
//public class Employee {
//    private UUID id;
//    private String name;
//    private LocalDate dob;
//    private Gender gender;
//    private Double salary;
//    private String phone;
//
//    public enum Gender {
//        MALE, FEMALE, OTHER;
//    }
//
//    public Employee() {
//    }
//
//    public Employee(UUID id, String name, LocalDate dob, Gender gender, Double salary, String phone) {
//        this.id = id;
//        this.name = name;
//        this.dob = dob;
//        this.gender = gender;
//        this.salary = salary;
//        this.phone = phone;
//    }
//
//    public UUID getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public LocalDate getDob() {
//        return dob;
//    }
//
//    public Gender getGender() {
//        return gender;
//    }
//
//    public Double getSalary() {
//        return salary;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setDob(LocalDate dob) {
//        this.dob = dob;
//    }
//
//    public void setGender(Gender gender) {
//        this.gender = gender;
//    }
//
//    public void setSalary(Double salary) {
//        this.salary = salary;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//}