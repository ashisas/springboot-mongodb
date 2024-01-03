package com.example.mongodb.repository;

import com.example.mongodb.entity.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends MongoRepository<EmployeeEntity,Long> {

    List<EmployeeEntity> findByFirstName(String name);
    @Query("{'lastName' : ?0}")
    List<EmployeeEntity> findByLastName(String lastName);

    List<EmployeeEntity> findAllByOrderByFirstNameDesc();

    List<EmployeeEntity> findAllByOrderByCreatedOnDesc();
    Page<EmployeeEntity> findAll(Pageable pageable);
    @Query("{$and:[ {age:{$gte:?0}} , {age: {$lte:?1}}]}")
    List<EmployeeEntity> findAllAgeBetween(int startAge,int endAge);

    @Query("{firstName:{'$regex':?0,'$options':'i'}}") // XYZ - > xyz
    List<EmployeeEntity> searchByFirstName(String firstName);
}
