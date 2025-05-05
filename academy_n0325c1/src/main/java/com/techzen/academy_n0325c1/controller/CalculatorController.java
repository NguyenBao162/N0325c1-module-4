package com.techzen.academy_n0325c1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    @GetMapping
    public ResponseEntity<String> calculator(@RequestParam(value = "firsttNumber", defaultValue = " ") String firsttNumberStr, @RequestParam(value = "secondNumber", defaultValue = " ") String secondNumberStr, @RequestParam(value = "operator", defaultValue = " ") String operator) {

        // kiem tra dau vao
        if (firsttNumberStr.isEmpty()) {
            return ResponseEntity.badRequest().body("firstNumber khong duoc rong");
        } else if (secondNumberStr.isEmpty()) {
            return ResponseEntity.badRequest().body("secondNumber khong duoc rong");
        } else if (!isDouble(firsttNumberStr)) {
            return ResponseEntity.badRequest().body("firstNumber phai la so");
        } else if (!isDouble(secondNumberStr)) {
            return ResponseEntity.badRequest().body("secondNumber phai la so");
        }

        // chuyen string thanh double
        double firsttNumber = Double.parseDouble(firsttNumberStr);
        double secondNumber = Double.parseDouble(secondNumberStr);
        double result;

        // tinh
        switch (operator) {
            case " + " -> result = firsttNumber + secondNumber;
            case " - " -> result = firsttNumber - secondNumber;
            case " * " -> result = firsttNumber * secondNumber;
            case " / " -> {
                if (secondNumber == 0) {
                    return ResponseEntity.badRequest().body("mau khong the = 0");
                }
                result = firsttNumber / secondNumber;
            }
            default -> {
                return ResponseEntity.badRequest().body(" khong the tinh");
            }
        }
        // tra ve ket qua
        return ResponseEntity.ok("ketqua: " + result);
    }

    // kiem tra so thuc
    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
