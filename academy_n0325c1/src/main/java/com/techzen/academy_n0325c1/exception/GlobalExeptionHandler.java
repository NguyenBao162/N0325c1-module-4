package com.techzen.academy_n0325c1.exception;

import com.techzen.academy_n0325c1.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // nơi lắng nge lỗi trả về
    public class GlobalExeptionHandler {
        @ExceptionHandler(AppExepciton.class)
        ResponseEntity<?> handLingAppException(AppExepciton exepciton){
            Errorcode errorcode = exepciton.getErrorCode();

            return ResponseEntity.status(errorcode.getStatusCode()).body(
                    ApiResponse.builder()
                            .code(errorcode.getCode())
                            .message(errorcode.getMessage())
                            .build()
            );
        }
    }

