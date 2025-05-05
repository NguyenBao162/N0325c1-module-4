package com.techzen.academy_n0325c1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
@RequestMapping("/dictionary")
public class DictionaryController {
    // tạo từ điển với tiếng anh và tiếng việt
    private final Map<String , String> dictionaryMap = Map.ofEntries(
            Map.entry("hello ", "xin chào"),
            Map.entry("apple ", "quả táo"),
            Map.entry("banana ", "quả chuối"),
            Map.entry("orange ", "quả cam"),
            Map.entry("lemon", "quả chanh"),
            Map.entry("melon ", "quả dưa"),
            Map.entry("watermelon ", "quả dưa hấu"),
            Map.entry("blueberry ", "quả việt quất")
    );
    // api get để tra từ điển
    @GetMapping
    public  ResponseEntity<String> dictionary(@RequestParam(defaultValue = "") String word){
        // xử lý nhập vào: loại bỏ khoảng trắng và chuyển chừ hoa -> thường
        String translation = dictionaryMap.get(word.trim().toLowerCase());

        // nếu tìm thấy trong từ điển, thì trả về với entity = 200 ok
        if (translation != null){
            return ResponseEntity.ok(translation);
        }
        // ngược lại trả về 404 not found
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("không tìm thấy từ cần tra ");
    }

}
