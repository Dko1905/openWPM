package xyz._190405.openwpm.domain.model

enum class AccountRole(val value: Int) {
	USER(0),
	READONLY(1),
	ADMIN(2);

	companion object {
		fun fromInt(value: Int) = values().first { it.value == value }
	}
}

