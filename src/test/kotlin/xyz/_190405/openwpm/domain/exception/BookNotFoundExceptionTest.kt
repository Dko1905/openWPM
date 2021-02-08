package xyz._190405.openwpm.domain.exception

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BookNotFoundExceptionTest {
	@Test
	fun `Create exception and check properties`() {
		val message = "Not found!"

		val ex1 = BookNotFoundException(message)
		val ex2 = BookNotFoundException(null)

		Assertions.assertEquals(message, ex1.message)
		Assertions.assertNull(ex2.message)
	}
	@Test
	fun `Throw exception`() {
		val exception = Assertions.assertThrows(BookNotFoundException::class.java) {
			throw BookNotFoundException("123")
		}

		Assertions.assertEquals("123", exception.message)
	}
}