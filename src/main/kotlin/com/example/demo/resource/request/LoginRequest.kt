package com.bunjang.ums.rest.dto.request

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.NotBlank

@ApiModel("로그인요청")
class LoginRequest(
        @field:NotBlank(message = "로그인방식(loginType)은 필수입니다.")
        @field:ApiModelProperty(
                position = 1,
                example = "PHONE_ONLY",
                required = true,
                allowEmptyValue = false,
                allowableValues = "PHONE_ONLY, FACEBOOK, KAKAO, NAVER"
        )
        var loginType: String? = null,

        @field:ApiModelProperty(
                position = 2,
                example = "01036504181",
                value = "로그인방식(loginType)이 폰인 경우 필수이다."
        )
        var phone: String? = null,

        @field:ApiModelProperty(
                position = 3,
                example = "Bunjang82!",
                required = true,
                value = "로그인방식(loginType)이 폰인 경우 필수이다."
        )
        var password: String,

        @field:ApiModelProperty(
                position = 4,
                example = "aktlv-akltldkv-ad334dfkal-222",
                value = "로그인방식(loginType)이 SNS인 경우 필수이다."
        )
        var oAuthToken: String? = null,

        @JsonProperty("deviceType")
        @field:ApiModelProperty(
                position = 5,
                example = "w",
                required = false,
                allowableValues = "android, iphone, web",
                value = "생략할 경우 w(WEB)으로 간주한다."
        )
        var deviceType: String = "web",

        @field:ApiModelProperty(
                position = 6,
                example = "aaatttt3",
                required = false,
                value = "알림 센터 푸쉬 등에 사용한다."
        )
        var pushToken: String? = null,

        @field:ApiModelProperty(
                position = 7,
                example = "iPhoneXS-MAX",
                required = false,
                value = "기기 모델명"
        )
        var deviceModel: String? = null,

        @field:ApiModelProperty(
                position = 8,
                example = "79067822fa5348eaaa79e",
                required = false,
                value = "User device id"
        )
        var udid: String? = null
)
