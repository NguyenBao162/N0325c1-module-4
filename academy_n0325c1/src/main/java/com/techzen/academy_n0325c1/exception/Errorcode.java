package com.techzen.academy_n0325c1.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
// @FieldDefaults(level = AccessLevel.PRIVATE):
// Đặt mức độ truy cập (access level) của tất cả các trường trong lớp là PRIVATE
// makeFinal = true: Tất cả các trường trong lớp sẽ được đánh dấu là final,
// tức là chúng không thể thay đổi sau khi được khởi tạo.
public enum Errorcode {
    STUDENT_NOT_EXIST(40401,"Student is not exist!", HttpStatus.NOT_FOUND),
    EMPLOYEE_NOT_EXIST(40401,"Employee is not exist!",HttpStatus.NOT_FOUND),
    DEPARTMENT_NOT_EXISTED(40401, "Department is not exitst!", HttpStatus.NOT_FOUND);

    int code;
    String message;
    HttpStatus statusCode;


}