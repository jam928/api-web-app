package com.apiwebapp.model

import javax.persistence.*
import java.io.Serializable

@Entity
data class Role(@Id
                @GeneratedValue
                   var id: Long,
                   var code: String,
                   var name: String) : Serializable