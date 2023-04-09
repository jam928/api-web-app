package com.apiwebapp.service.impl

import com.apiwebapp.model.Account
import com.apiwebapp.model.Role
import com.apiwebapp.repository.AccountRepository
import com.apiwebapp.repository.RoleRepository
import com.apiwebapp.service.AccountService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(
    private val accountRepository: AccountRepository,
    private val roleRepository: RoleRepository,
    private val encoder: PasswordEncoder) : AccountService {

    override fun createAccount(account: Account): Account {
        account.password = encoder.encode(account.password)
        val role = roleRepository.findByName("ROLE_USER")
        val roles = HashSet<Role>()
        roles.add(role)
        account.roles = roles
        return accountRepository.save(account)
    }

    override fun findByUsername(username: String?): Account {
        return accountRepository.findByUsername(username)
    }

    override fun getAccounts(): List<Account> {
        return accountRepository.findAll()
    }
}