package com.apiwebapp.service.impl

import com.apiwebapp.repository.AccountRepository
import com.apiwebapp.service.AccountService
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.*
import java.util.stream.Collectors

@Service
class UserDetailsServiceImpl(private val accountService: AccountService) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        val account = accountService.findByUsername(username)

        val authorities = account.roles?.stream()
            ?.map { role -> SimpleGrantedAuthority(role.name) }
            ?.collect(Collectors.toList())
        return User(account.username, account.password, account.enabled,
            !account.expired, !account.credentialsExpired,
            !account.locked, authorities)
    }
}