package xyz._190405.openwpm.repository

import org.springframework.data.repository.CrudRepository
import xyz._190405.openwpm.domain.model.Book

interface BookRepository : CrudRepository<Book, Long> {
	fun findByTitle(title: String): List<Book>
}
