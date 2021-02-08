package xyz._190405.openwpm.domain.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.Instant
import javax.persistence.*

@Entity
data class Book(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	val id: Int,

	@Column(nullable = false, unique = true)
	val title: String,

	@Column(nullable = false)
	val releaseDate: Instant,

	@Column(nullable = true)
	val author: String? = null
)
