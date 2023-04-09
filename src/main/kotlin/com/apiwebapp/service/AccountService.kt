package com.apiwebapp.service

import com.apiwebapp.model.Account

interface AccountService {

    fun createAccount(account: Account) : Account

    fun findByUsername(username: String?): Account

    fun getAccounts() : List<Account>
}