package info.novatec.decoding.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class ExampleApplication

fun main(args: Array<String>) {
    runApplication<ExampleApplication>(*args)
}

@RestController
class Controller {

    @PostMapping("/hello")
    fun post(@RequestBody request: RequestPayload) =
        ResponseEntity.ok().body("Hello ${request.foo} - ${request.bar}")

}

data class RequestPayload(
    val foo: String,
    val bar: String?
)
