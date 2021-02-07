package xyz._190405.openwpm

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OpenwpmApplication

fun main(args: Array<String>) {
	runApplication<OpenwpmApplication>(*args)
}
