package com.example.mongodb.controller;

import com.example.mongodb.entity.EmployeeEntity;
import com.example.mongodb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/v1/create")
    public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeEntity employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.OK);

    }
    @PostMapping("/v1/createAll")
    public ResponseEntity<List<EmployeeEntity>> createEmployeeList(@RequestBody List<EmployeeEntity> employee) {
        return new ResponseEntity<>(employeeService.saveListOfEmployee(employee), HttpStatus.OK);
    }
    @GetMapping("/v1/findByFirstName/{firstName}")
    public ResponseEntity<List<EmployeeEntity>> findByFirstName(@PathVariable("firstName") String firstName) {
        return new ResponseEntity<>(employeeService.findAllEmployeeByFirstName(firstName), HttpStatus.OK);
    }
    @GetMapping("/v1/findByLastName/{lastName}")
    public ResponseEntity<List<EmployeeEntity>> findByLastName(@PathVariable("lastName") String firstName) {
        return new ResponseEntity<>(employeeService.findAllEmployeeByLastName(firstName), HttpStatus.OK);
    }
    @GetMapping("/v1/allEmployee")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployee() {
        List<EmployeeEntity> employeeEntityList = employeeService.getAllEmployee();
        return new ResponseEntity<>(employeeEntityList, HttpStatus.OK);
    }
    @GetMapping("/v1/allEmployee/{page}/{size}")
    public ResponseEntity<Map<String, Object>> getAllEmployeePagination(@PathVariable("page") int page, @PathVariable("size") int size) {
        Map<String, Object> employeeEntityList = employeeService.getAllEmployeePagination(page,size);
        return new ResponseEntity<>(employeeEntityList, HttpStatus.OK);
    }
    @GetMapping("/v1/allEmployeeByAge/{startAge}/{endAge}")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployeeWithAge(@PathVariable("startAge") int startAge, @PathVariable("endAge") int endAge) {
        List<EmployeeEntity> employeeEntityList = employeeService.getAllEmployeeAgeBetween(startAge,endAge);
        return new ResponseEntity<>(employeeEntityList, HttpStatus.OK);
    }

    @GetMapping("/v1/searchEmployee/{firstName}")
    public ResponseEntity<List<EmployeeEntity>> searchEmployee(@PathVariable("firstName") String firstName) {
        List<EmployeeEntity> employeeEntityList = employeeService.searchEmployee(firstName);
        return new ResponseEntity<>(employeeEntityList, HttpStatus.OK);
    }
}
