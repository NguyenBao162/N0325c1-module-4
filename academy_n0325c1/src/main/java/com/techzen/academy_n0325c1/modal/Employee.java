package com.techzen.academy_n0325c1.modal;

import com.techzen.academy_n0325c1.enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    // (Universally Unique Identifier) là một kiểu dữ liệu dùng để biểu diễn một giá trị định danh duy nhất
    UUID id;
    String name;
    // DOB = Date of Birth
    LocalDate dob;
    Gender gender;
    double salary;
    String phone;
    Integer departmentId;
}


