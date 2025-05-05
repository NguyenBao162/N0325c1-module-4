package com.techzen.academy_n0325c1.Day2.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AppExepciton extends RuntimeException {
    public AppExepciton(Errorcode errorcode) {
        super(errorcode.getMessage());
        this.errorCode = errorcode;
    }
     Errorcode errorCode;
}

