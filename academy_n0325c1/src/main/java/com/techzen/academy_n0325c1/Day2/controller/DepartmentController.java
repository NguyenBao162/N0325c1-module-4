package com.techzen.academy_n0325c1.Day2.controller;

import ch.qos.logback.core.spi.ErrorCodes;
import com.techzen.academy_n0325c1.Day2.dto.JsonResponse;
import com.techzen.academy_n0325c1.Day2.exception.AppExepciton;
import com.techzen.academy_n0325c1.Day2.exception.Errorcode;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RequestMapping("/departments")
@RestController
public class DepartmentController {

    private final List<Department> departments = new ArrayList<>(
            Arrays.asList(
                    new Department(1,"Quản Lý"),
                    new Department(2,"Kế Toán"),
                    new Department(3,"Sale - Marketing"),
                    new Department(4,"Sản Xuất")

            )
    );

    @GetMapping
    public ResponseEntity<?> getAll() {return JsonResponse.ok(departments);}

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id)  {
        return departments.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .map(JsonResponse::ok)
                .orElseThrow(() -> new AppExepciton(Errorcode.DEPARTMENT_NOT_EXISTED));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Department department) {
        department.setId((int) (Math.random()*100000000));
        departments.add(department);
        return JsonResponse.created(department);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Department department)  {
        return departments.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .map(d -> {
                    d.setName(department.getName());
                    return JsonResponse.ok(d);
                })
                .orElseThrow(() -> new AppExepciton(Errorcode.DEPARTMENT_NOT_EXISTED));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        return departments.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .map(d ->{
                    departments.remove(d);
                    return JsonResponse.noContent();
                })
                .orElseThrow(() -> new AppExepciton(Errorcode.DEPARTMENT_NOT_EXISTED));
    }
}
