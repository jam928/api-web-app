package com.apiwebapp.repository

import com.apiwebapp.model.Employee
import org.springframework.stereotype.Repository

@Repository
class InMemoryEmployeeRepository {
    final val DATABASE: MutableList<Employee> = ArrayList<Employee>()

    init {
        DATABASE.add(Employee(1, "John", "Smith", "johnsmith@gmail.com"))
        DATABASE.add(Employee(2, "Jane", "Doe", "janedoe@gmail.com"))
        DATABASE.add(Employee(3, "Joe", "Moe", "joemoe@gmail.com"))
    }

    fun save(employee: Employee) : Employee {
        DATABASE.add(employee)
        return employee
    }

    fun getAllEmployees(): List<Employee> {
        return DATABASE.toCollection(mutableListOf())
    }

    fun getEmployee(id: Int): Employee {
        return DATABASE.single { employee -> id == employee.id }
    }

    fun updateEmployee(employee: Employee) {
        for(i in 0 until DATABASE.size) {
            if(DATABASE[i].id != employee.id) continue
            DATABASE[i] = employee
            break
        }
    }

    fun deleteEmployee(id: Int) : Boolean {
        return DATABASE.remove(getEmployee(id))
    }
}