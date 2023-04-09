package com.apiwebapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiWebAppApplication

fun main(args: Array<String>) {
	runApplication<ApiWebAppApplication>(*args)
}
