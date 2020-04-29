package com.example.demo.resource

import SWAGGER_TAG_ALL_API
import SWAGGER_TAG_JOIN_WITHDRAW_API
import SWAGGER_TAG_SNS_EPIC_API
import com.example.demo.resource.request.JoinRequest
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.validation.annotation.Validated
import reactor.kotlin.core.publisher.toMono
import javax.validation.Valid

import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.MediaType
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@Validated
@Api(tags = [SWAGGER_TAG_JOIN_WITHDRAW_API, SWAGGER_TAG_ALL_API], description = "JOIN, WITHDRAW APIs")
class JoinResource {
    @PostMapping("/api/join", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ApiOperation(tags = [SWAGGER_TAG_SNS_EPIC_API], value = "회원가입한다.")
    @ResponseStatus(CREATED)
    fun join(
            @Valid @RequestBody request: JoinRequest,
            serverHttpRequest: ServerHttpRequest
    ) = Unit.toMono()
}
