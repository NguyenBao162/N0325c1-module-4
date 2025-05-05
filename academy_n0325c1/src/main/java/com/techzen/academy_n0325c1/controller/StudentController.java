package com.techzen.academy_n0325c1.controller;

import com.techzen.academy_n0325c1.dto.ApiResponse;
import com.techzen.academy_n0325c1.exception.AppExepciton;
import com.techzen.academy_n0325c1.exception.Errorcode;
import com.techzen.academy_n0325c1.modal.Student;
import com.techzen.academy_n0325c1.service.IStudentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/students")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController {

    // BEAN LÀ 1 ĐỐI TƯỢNG ĐƯỢC QUẢN LÝ BỞI SPRING
    // CÁCH 1: TIÊM THÔNG QUA THUỘC TÍNH
//    @Autowired
//    IStudentService studentService;

//        CÁCH 2: TIÊM THÔNG QUA CONTRUCTOR
   private final IStudentService studentService;
    IStudentService studentService2; // TIM THÔNG QUA ALLCONTRUCTOR

    // CÁCH 3:TIÊM THÔNG QUA SETTER
//    IStudentService studentService;
//    public void setStudentService(IStudentService studentService) {
//        this.studentService = studentService;
//    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getStudents() {
        return ResponseEntity.ok(ApiResponse.<List<Student>>builder()
                .data(studentService.findAll())
                .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudent(@PathVariable("id") int id) {
        Student student = studentService.findById(id);

        if (student == null){
            throw new AppExepciton(Errorcode.STUDENT_NOT_EXIST);
        }
        return ResponseEntity.ok(ApiResponse.<Student>builder()
                .data(student)
                .build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> save(@RequestBody Student student) {
        student.setId((int)(Math.random()*1000000)); // sau này id đã tự động tăng
        studentService.findAll().add(student); // thêm vào danh sachs
        return ResponseEntity.ok(ApiResponse.<Student>builder()
                .data(student)
                .build()
        );// trả về đối tường vừa tạo
    }

}