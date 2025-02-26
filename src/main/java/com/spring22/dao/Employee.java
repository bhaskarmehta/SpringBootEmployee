package com.spring22.dao;

import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Component
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    int id;
    String name;
    String branch;

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setBranch(String branch){
        this.branch = branch;
    }

    public String getBranch(){
        return branch;
    }

    public Employee(int id, String name, String branch){
        this.id = id;
        this.name = name;
        this.branch = branch;
    }
    public Employee()
    {

    }


    @Override
    public String toString(){

        return "Employee{" +
               "id = "+ id +
               "name = "+ name +
               "branch = "+ branch +
               "}";

    }

}
