package com.apiwebapp.repository

import com.apiwebapp.model.Account
import com.apiwebapp.model.Employee
import com.apiwebapp.model.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : JpaRepository<Role, Long> {
    fun findByName(name: String) : Role
}