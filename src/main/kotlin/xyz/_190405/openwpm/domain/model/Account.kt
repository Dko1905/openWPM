package xyz._190405.openwpm.domain.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

enum class AccountRole(val value: Int) {
	USER(0),
	READONLY(1),
	ADMIN(2);

	companion object {
		fun fromInt(value: Int) = values().first { it.value == value }
	}
}

@Entity
data class Account(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	val id: Int,

	@Column(nullable = false, unique = true)
	@JsonProperty("username")
	val username: String,

	@Column(nullable = false)
	@JsonProperty("password")
	val password: String,

	@Column(nullable = false)
	@JsonProperty("accountRole")
	val role: AccountRole
)
