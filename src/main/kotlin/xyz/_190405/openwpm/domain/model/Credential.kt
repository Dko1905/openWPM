package xyz._190405.openwpm.domain.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
data class Credential(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	val id: Int,

	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	val virtualId: Int,

	@Column(nullable = false, unique = true)
	@JsonIgnore
	val accountId: Int,

	@Column(nullable = false)
	val url: String,

	@Column(nullable = false)
	val username: String,

	@Column(nullable = false)
	val password: String,

	@Column(nullable = false)
	val extra: String,
)
