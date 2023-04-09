package com.apiwebapp.repository

import com.apiwebapp.model.Account
import com.apiwebapp.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : JpaRepository<Account, Long> {
    fun findByUsername(username: String?) : Account
}