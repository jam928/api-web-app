package com.apiwebapp.service.impl

import com.apiwebapp.model.Employee
import com.apiwebapp.repository.JpaEmployeeRepository
import com.apiwebapp.service.EmployeeService
import org.springframework.stereotype.Service

@Service
class JpaEmployeeServiceImpl(private val jpaEmployeeRepository: JpaEmployeeRepository) : EmployeeService {
    override fun addEmployee(employee: Employee): Employee {
        return jpaEmployeeRepository.save(employee)
    }

    override fun getAllEmployees(): List<Employee> {
        return jpaEmployeeRepository.findAll()
    }

    override fun findById(id: Int): Employee {
        return jpaEmployeeRepository.findById(id).get()
    }

    override fun updateEmployee(employee: Employee) {
        jpaEmployeeRepository.save(employee)
    }

    override fun deleteEmployee(id: Int): Boolean {
        jpaEmployeeRepository.deleteById(id)
        return true
    }

}