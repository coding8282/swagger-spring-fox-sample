package com.example.demo.resource.request

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.NotBlank

@ApiModel("회원탈퇴요청")
class WithdrawRequest(
        @field:NotBlank(message = "탈퇴사유(reason)는 필수입니다.")
        @field:ApiModelProperty(
                position = 1,
                example = "다시가입할려고 ㅠㅠ",
                required = true,
                value = "탈퇴 사유"
        )
        val reason: String = "",

        @field:ApiModelProperty(
                position = 2,
                example = "군대가요~ 갓다와서 다시하게요~",
                value = "탈퇴 사유 상세"
        )
        var reason_detail: String?
)
