package com.apiwebapp.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
data class Account(@Id
                    @GeneratedValue
                    var id: Long,
                   @Column(unique = true)
                   @NotNull
                    var username: String,
                   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
                    var password: String,
                    var enabled: Boolean = true,
                   var expired: Boolean = false,
                    var credentialsExpired: Boolean = false,
                    var locked: Boolean = false,
                   @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
                   @JoinTable(
                       name = "AccountRole",
                       joinColumns = [JoinColumn(name="accountId", referencedColumnName = "id")],
                       inverseJoinColumns = [JoinColumn(name="roleId", referencedColumnName = "id")]
                   )
                   var roles: Set<Role>? = null) : Serializable