package com.example.demo.resource.request

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiParam
import javax.validation.constraints.NotBlank

@ApiModel("SNS등록요청")
class RegisterSNSAccountRequest(
        @field:NotBlank(message = "SNS타입(type)은 필수입니다.")
        @field:ApiParam(
                example = "FACEBOOK",
                required = true,
                allowEmptyValue = false,
                allowableValues = "FACEBOOK, KAKAO, NAVER, APPLE"
        )
        var type: String = "",

        @field:NotBlank(message = "SNS토큰(sns_token)은 필수입니다.")
        @field:ApiParam(
                example = "aktlv-akltldkv-ad334dfkal-222",
                required = true
        )
        var sns_token: String = "",

        @get:ApiParam(hidden = true)
        val is_active: Boolean = true
)
