package com.apiwebapp.controller

import com.apiwebapp.model.Account
import com.apiwebapp.model.Employee
import com.apiwebapp.service.AccountService
import com.apiwebapp.service.EmployeeService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path= ["/api/accounts"])
class AccountController(private val accountService: AccountService) {

    @GetMapping("/")
    fun getAccounts() : ResponseEntity<List<Account>> {
        return ResponseEntity.ok(accountService.getAccounts())
    }

    @PostMapping("/")
    fun createAccount(@RequestBody account: Account) : ResponseEntity<Account> {
        return ResponseEntity.created(EmployeeController.getLocation(account.id.toInt())).body(accountService.createAccount(account))
    }
}