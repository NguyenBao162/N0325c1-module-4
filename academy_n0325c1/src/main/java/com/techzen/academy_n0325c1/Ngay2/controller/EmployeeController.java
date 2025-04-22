package com.techzen.academy_n0325c1.Ngay2.controller;

import com.techzen.academy_n0325c1.Ngay2.dto.JsonResponse;
import com.techzen.academy_n0325c1.Ngay2.exception.AppExepciton;
import com.techzen.academy_n0325c1.Ngay2.exception.Errorcode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final List<Employee> employees = new ArrayList<>(
            Arrays.asList(
                    new Employee(UUID.randomUUID(), "Hoàng Văn Hải", LocalDate.of( 1990,  1, 15),Gender.MALE,  15000000.00, "0975123542",1),
                    new Employee(UUID.randomUUID(), "Trần Thị Hoài", LocalDate.of( 1985,  5, 20), Gender.FEMALE,  14500000.00, "096786968",2),
                    new Employee(UUID.randomUUID(), "Lê Văn Sỹ", LocalDate.of( 1992,  3, 10), Gender.MALE,  15500000.00, "0988881110",3),
                    new Employee(UUID.randomUUID(), "Phạm Duy Khánh", LocalDate.of( 1988,  7, 5), Gender.FEMALE,  14800000.00, "0986555333",4),
                    new Employee(UUID.randomUUID(), "Hoàng Văn Hải", LocalDate.of( 1995,  9, 25), Gender.MALE,  15200000.00, "0973388668",4)
            )
    );

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") UUID id) throws AppExepciton {
        return employees.stream() // Filtering: Lọc các phần tử thỏa mãn điều kiện.
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .map(JsonResponse::ok)
                .orElseThrow(() -> new AppExepciton(Errorcode.EMPLOYEE_NOT_EXIST));
//        orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Employee employee) {
        employee.setId(UUID.randomUUID());
        employees.add(employee);
        return JsonResponse.created(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id, @RequestBody Employee employee) throws AppExepciton {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .map(e -> {
                    e.setName(employee.getName());
                    e.setDOB(employee.getDOB());
                    e.setGender(employee.getGender());
                    e.setSalary(employee.getSalary());
                    e.setPhone(employee.getPhone());

                    return JsonResponse.ok(e);
                })
                .orElseThrow(() -> new AppExepciton(Errorcode.EMPLOYEE_NOT_EXIST));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .map(s ->{
                    employees.remove(s);
                    return JsonResponse.noContent();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}


