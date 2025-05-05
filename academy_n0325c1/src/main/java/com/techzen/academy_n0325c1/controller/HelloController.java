package com.techzen.academy_n0325c1.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // đánh dấu controller
public class HelloController {
    @RequestMapping("/hello")   // đường dẫn / api
    public String greeting(@RequestParam (defaultValue = "") String name, // RequestParam truyền tham số vào, nếu kh có thì ẩn đi thay vì null
                           @RequestParam(defaultValue = "") String address,
                           @RequestParam(defaultValue = "") String age,
                           @RequestParam(defaultValue = "") String cccd){
        return "hello " + name + " " + address + " " + age + " " + cccd + " ";
    }
}

