package com.apiwebapp.service.impl

import com.apiwebapp.model.Employee
import com.apiwebapp.repository.InMemoryEmployeeRepository
import com.apiwebapp.service.EmployeeService
import org.springframework.stereotype.Service

@Service
class InMemoryEmployeeServiceImpl(val inMemoryEmployeeRepository: InMemoryEmployeeRepository) : EmployeeService {
    override fun addEmployee(employee: Employee) : Employee {
        return inMemoryEmployeeRepository.save(employee)
    }

    override fun getAllEmployees(): List<Employee> {
        return inMemoryEmployeeRepository.getAllEmployees()
    }

    override fun findById(id: Int): Employee {
        return inMemoryEmployeeRepository.getEmployee(id)
    }

    override fun updateEmployee(employee: Employee) {
        inMemoryEmployeeRepository.updateEmployee(employee)
    }

    override fun deleteEmployee(id: Int): Boolean {
        return inMemoryEmployeeRepository.deleteEmployee(id)
    }
}