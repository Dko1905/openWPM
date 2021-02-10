package xyz._190405.openwpm.domain.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import xyz._190405.openwpm.domain.model.Book
import xyz._190405.openwpm.repository.BookRepository
import java.time.Instant
import javax.annotation.PostConstruct

@Component
class BookDbInit {
	private val log: Logger = LoggerFactory.getLogger(BookDbInit::class.java)
	@Autowired
	private lateinit var bookRepository: BookRepository

	@PostConstruct
	fun init() {
		fun addBook(title: String) {
			val book = Book(0, title, Instant.now())
			if (bookRepository.findByTitle(title).toList().isEmpty()) {
				log.info("Saved book ${bookRepository.save(book)}")
			} else {
				log.info("Did not add book $book")
			}
		}

		addBook("Hello world!")
		addBook("Hello world2!")
	}
}