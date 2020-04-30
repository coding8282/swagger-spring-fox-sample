package com.example.demo.resource

import DOC_WITHDRAW
import SWAGGER_TAG_ALL_API
import SWAGGER_TAG_JOIN_WITHDRAW_API
import com.example.demo.resource.request.WithdrawRequest
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.MediaType.*
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import reactor.kotlin.core.publisher.toMono
import springfox.documentation.annotations.ApiIgnore
import javax.validation.Valid

@RestController
@Validated
@Api(tags = [SWAGGER_TAG_JOIN_WITHDRAW_API, SWAGGER_TAG_ALL_API], description = "JOIN, WITHDRAW APIs")
class WithdrawResource {
    @GetMapping("/api/withdraw", produces = [APPLICATION_JSON_VALUE])
    @ApiOperation("회원탈퇴한다.", notes = DOC_WITHDRAW)
    fun withdraw1(@Valid request: WithdrawRequest) = withdrawInternal(request)

    @PostMapping("/api/withdraw", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
    @ApiOperation("회원탈퇴한다.", notes = DOC_WITHDRAW)
    fun withdraw2(@Valid @RequestBody request: WithdrawRequest) = withdrawInternal(request)

    @PostMapping("/api/withdraw", consumes = [MULTIPART_FORM_DATA_VALUE], produces = [APPLICATION_JSON_VALUE])
    fun withdraw3(@Valid request: WithdrawRequest) = withdrawInternal(request)

    @PostMapping("/api/withdraw", consumes = [APPLICATION_FORM_URLENCODED_VALUE], produces = [APPLICATION_JSON_VALUE])
    fun withdraw4(@Valid request: WithdrawRequest) = withdrawInternal(request)

    @PostMapping("/api/withdraw", consumes = [APPLICATION_ATOM_XML_VALUE], produces = [APPLICATION_JSON_VALUE])
    fun withdraw5(@Valid request: WithdrawRequest) = withdrawInternal(request)

    // ------------------------------------------------------------------------------------
    private fun withdrawInternal(request: WithdrawRequest) = Unit.toMono()
}
