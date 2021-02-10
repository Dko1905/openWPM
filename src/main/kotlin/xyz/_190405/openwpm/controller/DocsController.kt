package xyz._190405.openwpm.controller

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.util.MimeTypeUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller()
@RequestMapping("/docs")
class DocsController {
	@GetMapping("/", produces = ["text/plain"])
	fun getRoot(): ResponseEntity<String> {
		val headers = HttpHeaders()
		headers.add("Location", "./index.html")
		return ResponseEntity("Redirected to ./index.html", headers, HttpStatus.PERMANENT_REDIRECT)
	}
}