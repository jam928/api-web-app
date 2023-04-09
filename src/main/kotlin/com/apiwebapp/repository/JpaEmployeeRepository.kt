package com.apiwebapp.repository

import com.apiwebapp.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaEmployeeRepository : JpaRepository<Employee, Int> {
}