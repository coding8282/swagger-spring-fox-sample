package com.bunjang.ums.rest.dto.response

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel("로그인응답")
class LoginResponse(
        @field:ApiModelProperty(
                position = 1,
                example = "7424502",
                required = true,
                allowEmptyValue = false,
                value = "회원 uid."
        )
        val uid: Int,

        @field:ApiModelProperty(
                position = 2,
                example = "false",
                required = true,
                allowEmptyValue = false,
                value = "차단됐는지 여부."
        )
        val isBlocked: Boolean,

        @field:ApiModelProperty(
                position = 3,
                example = "7424502",
                required = true,
                allowEmptyValue = false,
                value = "access token."
        )
        val accessToken: String,

        @field:ApiModelProperty(
                position = 4,
                example = "2020-01-15 23:07:08",
                required = true,
                allowEmptyValue = false,
                value = "토큰 만료 시각. format: YYYY-MM-DD HH:MM:SS"
        )
        val accessTokenExpireAt: String
)
