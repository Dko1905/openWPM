package xyz._190405.openwpm.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.util.MimeTypeUtils
import org.springframework.web.bind.annotation.*
import xyz._190405.openwpm.domain.model.Book
import xyz._190405.openwpm.repository.BookRepository

@RestController
@RequestMapping("/book", produces = ["application/json"])
@CrossOrigin(origins = ["*"], maxAge = 60)
class BookController(
	@Autowired
	private val bookRepository: BookRepository
) {
	@GetMapping("/")
	fun getAll(): List<Book> = bookRepository.findAll().toList()

	@GetMapping("/{title}")
	fun getByTittle(@PathVariable title: String): List<Book> = bookRepository.findByTitle(title)
}