package com.example.demo.resource

import DOC_LOGIN
import SWAGGER_TAG_ALL_API
import SWAGGER_TAG_LOGIN_LOGOUT_API
import com.bunjang.ums.rest.dto.request.LoginRequest
import com.bunjang.ums.rest.dto.response.LoginResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import io.swagger.annotations.ResponseHeader
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.WebSession
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import springfox.documentation.annotations.ApiIgnore
import javax.validation.Valid

@RestController
@Validated
@Api(tags = [SWAGGER_TAG_LOGIN_LOGOUT_API, SWAGGER_TAG_ALL_API], description = "로그인 & 로그아웃 API")
class LoginLogoutResource {
    @PostMapping("/api/login", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
    @ApiOperation(
            value = "로그인한다.",
            notes = DOC_LOGIN
    )
    @ApiResponses(
            ApiResponse(
                    code = 200,
                    message = "OK",
                    responseHeaders = [
                        ResponseHeader(
                                name = "Set-Cookie",
                                description = "SYSTEM_SESSION=ddf3fdfs-7fc9-4f59-921e-3b0c339748e1; Path=/; Domain=localhost; HttpOnly; SameSite=None",
                                response = String::class
                        )
                    ]
            )
    )
    fun login(
            @RequestParam(name = "platform", required = false)
            @ApiParam(
                    name = "platform",
                    required = false,
                    allowEmptyValue = true,
                    allowableValues = "w, a, i",
                    value = "디바이스를 선택한다.\n\n" +
                            "a: Android.\n" +
                            "i: IPhone.\n" +
                            "w: Web."
            )
            loginDeviceTypeStr: String? = null,
            @Valid @RequestBody request: LoginRequest,
            serverHttpRequest: ServerHttpRequest,
            serverHttpResponse: ServerHttpResponse,
            webSession: WebSession
    ) = Mono.just(LoginResponse(
            uid = 7424502,
            isBlocked = true,
            accessToken = "asdfasdf",
            accessTokenExpireAt = "2020-01-15 23:07:08"
    ))

    @PostMapping("/api/logout", produces = [APPLICATION_JSON_VALUE])
    @ApiOperation(value = "로그아웃한다.")
    fun logout(
            @RequestParam(
                    name = "device",
                    required = false
            )
            @ApiParam(
                    name = "device",
                    example = "w",
                    required = false,
                    allowEmptyValue = true,
                    allowableValues = "web, android, iphone",
                    value = "디바이스를 선택한다. null 또는 생략할 경우 w로 간주한다."
            )
            deviceType: String? = null,
            serverHttpResponse: ServerHttpResponse,
            webSession: WebSession,
            @ApiIgnore @CookieValue(value = "bunny_cookie") bunnyCookie: String?
    ) = Unit.toMono()
}
