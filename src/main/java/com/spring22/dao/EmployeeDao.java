package com.spring22.dao;

import java.util.ArrayList;


import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
    

    Employee e1  = new Employee(1,"Bhaskar","CSE");
    Employee e2  = new Employee(2,"Raj","Mech");
    Employee e3  = new Employee(1,"Mehta","Agri");

    ArrayList<Employee> e = new ArrayList<Employee>();

    public ArrayList<Employee> getAllEmployeeDetails(){
        e.add(e1);
        e.add(e2);
        e.add(e3);
        return e;
    }

    
}
