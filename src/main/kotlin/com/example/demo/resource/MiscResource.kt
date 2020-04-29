package com.example.demo.resource

import SWAGGER_TAG_ALL_API
import SWAGGER_TAG_MISC_API
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.MediaType.*
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@RestController
@Validated
@Api(tags = [SWAGGER_TAG_MISC_API, SWAGGER_TAG_ALL_API])
class MiscResource {
    @GetMapping("/api/ping", produces = [TEXT_PLAIN_VALUE])
    @ApiOperation("Ping test.")
    fun ping() = Mono.just("pong")

    @GetMapping("/api/info", produces = [APPLICATION_JSON_VALUE])
    @ApiOperation("API info.")
    fun info() = Mono.just(mapOf(
            "developer" to "coding8282@gmail.com",
            "since" to LocalDateTime.now().toString()
    ))
}
