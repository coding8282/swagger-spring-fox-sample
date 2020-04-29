package com.example.demo.resource.request

import com.fasterxml.jackson.annotation.JsonIgnore
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.*

@ApiModel("가입요청")
class JoinRequest(
        @field:NotBlank(message = "폰번호(phone)는 필수입니다.")
        @field:Size(min = 7, max = 20, message = "폰번호(phone)는 7~20자이어야 합니다.")
        @field:ApiModelProperty(
                position = 1,
                example = "01012345678",
                required = true,
                allowEmptyValue = false,
                value = "항상 필수이다."
        )
        var phone: String = "",

        @field:NotNull(message = "인증번호(code)는 필수입니다.")
        @field:Min(value = 1000, message = "인증번호(code)가 잘못되었습니다.")
        @field:Max(value = 9999, message = "인증번호(code)가 잘못되었습니다.")
        @field:ApiModelProperty(
                position = 2,
                example = "123456",
                required = true,
                allowEmptyValue = false,
                value = "TTL 정책을 적용 받는다."
        )
        var code: Int = -1,

        @field:NotBlank(message = "폰번호(phone)는 필수입니다.")
        @field:Email
        @field:ApiModelProperty(
                position = 3,
                example = "coding8282@gmail.com",
                required = true
        )
        var email: String = "",

        @field:NotBlank(message = "비밀번호(password)는 필수입니다.")
        @field:ApiModelProperty(
                position = 4,
                example = "password_1234!",
                required = true,
                value = "8~16자 영문, 숫자, 특문을 1개 이상 모두 포함해야 한다."
        )
        var password: String = "",

        @field:ApiModelProperty(
                position = 5,
                example = "79067822fa5348eaaa79e",
                required = false,
                value = "User device id"
        )
        var udid: String? = null,

        @field:ApiModelProperty(
                position = 6,
                example = "4.0.1",
                required = false,
                value = "앱 버전"
        )
        var version: String? = null
) {
    @field:JsonIgnore
    lateinit var ipAddr: String
}
