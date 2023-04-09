package com.apiwebapp.init

import com.apiwebapp.model.Role
import com.apiwebapp.repository.RoleRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class ApplicationStartRunner(private val roleRepository: RoleRepository): CommandLineRunner {

    override fun run(vararg args: String?) {
        val roleUser = Role(1L, "123", "ROLE_USER")
        val roleAdmin = Role(2L, "456", "ROLE_ADMIN")
        roleRepository.saveAll(arrayListOf( roleUser, roleAdmin))
    }
}