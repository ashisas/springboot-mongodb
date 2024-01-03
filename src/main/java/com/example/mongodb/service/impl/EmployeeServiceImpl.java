package com.example.mongodb.service.impl;

import com.example.mongodb.entity.EmployeeEntity;
import com.example.mongodb.repository.EmployeeRepo;
import com.example.mongodb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<EmployeeEntity> saveListOfEmployee(List<EmployeeEntity> employee) {
        return employeeRepo.saveAll(employee);
    }

    @Override
    public List<EmployeeEntity> findAllEmployeeByFirstName(String firstName) {
        return employeeRepo.findByFirstName(firstName);
    }

    @Override
    public List<EmployeeEntity> findAllEmployeeByLastName(String lastName) {
        return employeeRepo.findByLastName(lastName);
    }

    @Override
    public List<EmployeeEntity> getAllEmployee() {
        //return employeeRepo.findAllByOrderByFirstNameDesc();
        return employeeRepo.findAllByOrderByCreatedOnDesc();
    }

    @Override
    public Map<String, Object> getAllEmployeePagination(int page,int size) {
        Map<String, Object> map = new LinkedHashMap<>();
        Pageable pageable = PageRequest.of(page -1,size);
        Page<EmployeeEntity> employeeEntities =  employeeRepo.findAll(pageable);
        map.put("currentPage", page);
        map.put("totalItems", employeeEntities.getTotalElements());
        map.put("totalPages", employeeEntities.getTotalPages());
        map.put("employees", employeeEntities.getContent());
        return map;
    }

    @Override
    public List<EmployeeEntity> searchEmployee(String firstName) {
        return employeeRepo.searchByFirstName(firstName);
    }

    @Override
    public List<EmployeeEntity> getAllEmployeeAgeBetween(int startAge, int endAge) {
        return employeeRepo.findAllAgeBetween(startAge,endAge);
    }


}
