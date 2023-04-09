package com.apiwebapp.model

import javax.persistence.*
import java.io.Serializable

@Entity
data class Employee(@Id
                    @GeneratedValue
                    var id: Int,
                    var firstName: String? = null,
                    var lastName: String? = null,
                    var email: String? = null) : Serializable