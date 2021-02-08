package xyz._190405.openwpm.domain.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CredentialTest {
	@Test
	fun `Create credential`() {
		val credential = Credential(1, 2, 3, "123", "321", "pas", "e")

		assertEquals(1, credential.id)
		assertEquals(2, credential.virtualId)
		assertEquals(3, credential.accountId)
		assertEquals("123", credential.url)
		assertEquals("321", credential.username)
		assertEquals("pas", credential.password)
		assertEquals("e", credential.extra)
	}
}
