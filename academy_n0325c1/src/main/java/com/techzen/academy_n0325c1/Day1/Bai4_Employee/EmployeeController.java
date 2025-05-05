//package com.techzen.academy_n0325c1.Ngay1.Bai4_Employee;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/employees")
//public class EmployeeController {
//    private final List<Employee> employees = new ArrayList<>(
//            Arrays.asList(
//                    new Employee(UUID.randomUUID(), "Hoàng Văn Thụ", LocalDate.of(1990, 1, 15), Employee.Gender.FEMALE, 15000000.00, "0975123542"),
//                    new Employee(UUID.randomUUID(), "Trần Thị Xinh", LocalDate.of(1985, 5, 20), Employee.Gender.MALE, 14500000.00, "0967896968"),
//                    new Employee(UUID.randomUUID(), "Lê Văn Bảo", LocalDate.of(1992, 3, 18), Employee.Gender.FEMALE, 15500000.00, "0988881110"),
//                    new Employee(UUID.randomUUID(), "Phạm Duy Đinh", LocalDate.of(1988, 7, 5), Employee.Gender.MALE, 14800000.00, "0965553333"),
//                    new Employee(UUID.randomUUID(), "Hoàng Văn Quý", LocalDate.of(1995, 9, 25), Employee.Gender.FEMALE, 15200000.00, "0973388668")
//            )
//    );
//    @GetMapping
//    public ResponseEntity<List<Employee>> getAll() {
//        return ResponseEntity.ok(employees);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Employee> getById(@PathVariable("id") UUID id) {
//        return employees.stream()
//                .filter(employee -> employee.getId().equals(id))
//                .findFirst()
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<Employee> create(@RequestBody Employee employee){
//        employee.setId(UUID.randomUUID());
//        employees.add(employee);
//        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Employee> update(@PathVariable("id") UUID id, @RequestBody Employee employee) {
//        return employees.stream()
//                .filter(e -> e.getId().equals(id))
//                .findFirst()
//                .map(e -> {
//                    e.setName(employee.getName());
//                    e.setDob(employee.getDob());
//                    e.setGender(employee.getGender());
//                    e.setSalary(employee.getSalary());
//                    e.setPhone(employee.getPhone());
//                    return ResponseEntity.ok(e);
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete(@PathVariable("id") UUID id) {
//        return employees.stream()
//                .filter(e -> e.getId().equals(id))
//                .findFirst()
//                .map(e -> {
//                    employees.remove(e);
//                    return ResponseEntity.ok().build();
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//}
//
//
