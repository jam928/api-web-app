package com.apiwebapp.controller

import com.apiwebapp.model.Employee
import com.apiwebapp.service.EmployeeService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest
import java.net.URI

@RestController
@RequestMapping(path= ["/api/employees"])
class EmployeeController(@Qualifier("jpaEmployeeServiceImpl") val employeeService: EmployeeService) {

    @GetMapping("/")
    fun getEmployees() : ResponseEntity<List<Employee>> {
        return ResponseEntity.ok(employeeService.getAllEmployees())
    }

    @GetMapping("/{id}")
    fun getEmployee(@PathVariable id: Int) : ResponseEntity<Employee> {
        return ResponseEntity.ok(employeeService.findById(id))
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    fun saveEmployee(@RequestBody employee: Employee) : ResponseEntity<Employee> {
        return ResponseEntity.created(getLocation(employee.id)).body(employeeService.addEmployee(employee))
    }

    @PutMapping("/")
    fun updateEmployee(@RequestBody employee: Employee) : ResponseEntity<HttpStatus> {
        employeeService.updateEmployee(employee)
        return ResponseEntity.ok(HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: Int) : ResponseEntity<Boolean> {
        return ResponseEntity.ok(employeeService.deleteEmployee(id))
    }



    companion object {
        fun getLocation(id: Int): URI {
            return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri()
        }
    }

}