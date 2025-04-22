package com.techzen.academy_n0325c1.Ngay2.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

    @Getter
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
// @FieldDefaults(level = AccessLevel.PRIVATE):
// Đặt mức độ truy cập (access level) của tất cả các trường trong lớp là PRIVATE
// makeFinal = true: Tất cả các trường trong lớp sẽ được đánh dấu là final,
// tức là chúng không thể thay đổi sau khi được khởi tạo.
    public enum Errorcode {
        EMPLOYEE_NOT_EXIST(40401,"Employee is not exist", HttpStatus.NOT_FOUND);


        int code;
        String message;
        HttpStatus statusCode;

        public String getMessage() {
            return null;
        }
    }
}
