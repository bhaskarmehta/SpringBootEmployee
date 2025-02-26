package com.spring22.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeJPAInterface extends JpaRepository<Employee,Integer> {
    List<Employee> findByName(String name);

    // @Query(value = "select * from employees where branch = :br",nativeQuery=true)
    // Employee  findBySpecificBranchName(@Param("br") String br);

}
