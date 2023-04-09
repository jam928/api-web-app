package com.apiwebapp.security

import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfiguration(private val accountAuthenticationProvider: AccountAuthenticationProvider) {

    @Bean
    fun securityFilterChain(http: HttpSecurity) : SecurityFilterChain {

        val authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder::class.java)
        authenticationManagerBuilder.authenticationProvider(accountAuthenticationProvider)

        // disable cookies
        http.csrf().disable().authorizeRequests()
            .antMatchers(HttpMethod.POST, "/api/accounts/**")
            .permitAll()
            .antMatchers("/**")
            .authenticated()
            .anyRequest()
            .hasAnyRole("USER", "ADMIN")
            .and()
            .httpBasic(Customizer.withDefaults())
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        return http.build()
    }
}