package com.learning.mysqlproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.mysqlproj.tablecre.EmployeeDetails;

@Repository
public interface RepositoryInter extends JpaRepository<EmployeeDetails, Integer>{

}
