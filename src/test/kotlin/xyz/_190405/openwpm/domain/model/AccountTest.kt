package xyz._190405.openwpm.domain.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AccountTest {
	@Test
	fun `Create account with null`() {
		val account = Account(6, "123", "321", AccountRole.READONLY)

		assertEquals(6, account.id)
		assertEquals("123", account.username)
		assertEquals("321", account.password)
		assertEquals(AccountRole.READONLY, account.role)
	}
}
