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
		log.info("Adding " + bookRepository.save(Book(0, "The C Programming Lanuage", Instant.now(), "David")))
		log.info("Adding " + bookRepository.save(Book(0, "The Rust Programming Lanuage", Instant.now(), "Someone Else")))
		log.info("Adding " + bookRepository.save(Book(0, "Anonymity", Instant.now(), null)))
	}
}