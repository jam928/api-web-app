package com.apiwebapp.service

import com.apiwebapp.model.Employee


interface EmployeeService {
    fun addEmployee(employee: Employee) : Employee

    fun getAllEmployees(): List<Employee>

    fun findById(id: Int) : Employee

    fun updateEmployee(employee: Employee)

    fun deleteEmployee(id: Int) : Boolean
}