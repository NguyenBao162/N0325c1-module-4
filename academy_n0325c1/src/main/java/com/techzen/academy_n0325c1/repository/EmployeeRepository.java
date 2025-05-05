package com.techzen.academy_n0325c1.repository;

import com.techzen.academy_n0325c1.dto.employee.EmployeeSearchRequest;
import com.techzen.academy_n0325c1.enums.Gender;
import com.techzen.academy_n0325c1.modal.Employee;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
@FieldDefaults (level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeRepository implements IEmployeeRepository{
    List<Employee> employees = new ArrayList<>(
            Arrays.asList(
                    new Employee(UUID.randomUUID(), "Hoàng Văn Hải", LocalDate.of( 1990,  1, 15), Gender.MALE,  15000000.00, "0975123542",1),
                    new Employee(UUID.randomUUID(), "Trần Thị Hoài", LocalDate.of( 1985,  5, 20), Gender.FEMALE,  14500000.00, "096786968",2),
                    new Employee(UUID.randomUUID(), "Lê Văn Sỹ", LocalDate.of( 1992,  3, 10), Gender.MALE,  15500000.00, "0988881110",3),
                    new Employee(UUID.randomUUID(), "Phạm Duy Khánh", LocalDate.of( 1988,  7, 5), Gender.OTHER,  14800000.00, "0986555333",4),
                    new Employee(UUID.randomUUID(), "Hoàng Văn Hải", LocalDate.of( 1995,  9, 25), Gender.MALE,  15200000.00, "0973388668",4)
            )
    );
    @Override
    public List<Employee> findByAttributes(EmployeeSearchRequest employeeSearchRequest){
        return employees.stream()
                .filter(e->(employeeSearchRequest.getName() == null || e.getName().toLowerCase().contains(employeeSearchRequest.getName().toLowerCase())))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Employee> findById(UUID id){
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    @Override
    public Employee save(Employee employee){
        return findById(employee.getId())
                .map(e -> {
                    e.setName(employee.getName());
                    e.setDob(employee.getDob());
                    e.setGender(employee.getGender());
                    e.setSalary(employee.getSalary());
                    e.setPhone(employee.getPhone());
                    e.setDepartmentId(employee.getDepartmentId());

                    return e;
                })
                .orElseGet(() ->{
                    employee.setId(UUID.randomUUID());
                    employees.add(employee);
                    return employee;
                });
    }

    @Override
    public void delete(UUID id) {findById(id).ifPresent(employees::remove);}


}
