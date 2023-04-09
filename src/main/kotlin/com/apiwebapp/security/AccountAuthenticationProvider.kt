package com.apiwebapp.security

import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class AccountAuthenticationProvider(private val userDetailsService: UserDetailsService,
                                    private val encoder: PasswordEncoder) : AbstractUserDetailsAuthenticationProvider() {

    override fun additionalAuthenticationChecks(
        userDetails: UserDetails?,
        authToken: UsernamePasswordAuthenticationToken?
    ) {
        if(authToken?.credentials == null || userDetails?.password == null) {
            throw BadCredentialsException("Credentials may not be null")
        }

        if(!encoder.matches(authToken.credentials.toString(), userDetails.password)) {
            throw BadCredentialsException("Invalid Credentials")
        }
    }

    override fun retrieveUser(username: String?, authentication: UsernamePasswordAuthenticationToken?): UserDetails {
        return userDetailsService.loadUserByUsername(username)
    }
}