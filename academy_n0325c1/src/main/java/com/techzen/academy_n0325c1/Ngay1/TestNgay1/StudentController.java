package com.techzen.academy_n0325c1.Ngay1.TestNgay1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {
    private List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1,"Bảo", 4.4),
                    new Student(2,"khang", 8.7),
                    new Student(3,"khôi", 6.8)
            )
    );
    // lấy all trong list
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(students);
    }
    // lấy theo id
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudents(@PathVariable("id") int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return ResponseEntity.ok(student);
            }
        }
        return ResponseEntity.notFound().build();
    }
    //
    @PostMapping
    public ResponseEntity<Student> save (@RequestBody Student student) { // ResponseEntity custom kiểu dữ liệu trả về
       student.setId((int) (Math.random()* 10000));
       students.add(student); // thêm vào ds
        return ResponseEntity.status(HttpStatus.CREATED).body(student); // HttpStatus.CREATED ctrl vào để xem kiểu dữ liệu muốn tra về
    }

}
