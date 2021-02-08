package xyz._190405.openwpm.domain.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Account(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	val id: Int,

	@Column(nullable = false, unique = true)
	val username: String,

	@Column(nullable = false)
	val password: String,

	@Column(nullable = false)
	val role: AccountRole
)
