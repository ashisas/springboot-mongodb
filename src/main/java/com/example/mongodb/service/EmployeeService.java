package com.example.mongodb.service;

import com.example.mongodb.entity.EmployeeEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public EmployeeEntity saveEmployee(EmployeeEntity employee);
    public List<EmployeeEntity> saveListOfEmployee(List<EmployeeEntity> employee);

    public List<EmployeeEntity> findAllEmployeeByFirstName(String firstName);

    public List<EmployeeEntity> findAllEmployeeByLastName(String lastName);

    List<EmployeeEntity> getAllEmployee();
    Map<String, Object> getAllEmployeePagination(int page, int size);
    List<EmployeeEntity> searchEmployee(String firstName);
    List<EmployeeEntity> getAllEmployeeAgeBetween(int startAge,int endAge);
}
