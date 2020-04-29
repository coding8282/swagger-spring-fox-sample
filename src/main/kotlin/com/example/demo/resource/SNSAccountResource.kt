package com.example.demo.resource

import SWAGGER_TAG_ALL_API
import DOC_REGISTER_SNS_ACCOUNT
import SWAGGER_TAG_SNS_API
import SWAGGER_TAG_SNS_EPIC_API
import com.example.demo.resource.request.RegisterSNSAccountRequest
import com.example.demo.resource.request.UpdateSNSAccountRequest
import io.swagger.annotations.*
import org.springframework.http.MediaType.*
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import reactor.kotlin.core.publisher.toMono
import javax.validation.Valid

@RestController
@Validated
@Api(tags = [SWAGGER_TAG_SNS_API, SWAGGER_TAG_ALL_API])
class SNSAccountResource {
    @GetMapping("/api/phones/{phone}/sns-account-exists", produces = [APPLICATION_FORM_URLENCODED_VALUE])
    @ApiOperation(tags = [SWAGGER_TAG_SNS_EPIC_API], value = "해당 폰번호로 가입한 SNS계정이 존재하는지 확인한다.")
    fun checkSNSExistsByPhone(
            @PathVariable
            @ApiParam(
                    example = "01012345678",
                    required = true,
                    allowEmptyValue = false,
                    value = "폰번호"
            )
            phone: String
    ) = Unit.toMono()

    @PostMapping("/api/sns-accounts", consumes = [APPLICATION_FORM_URLENCODED_VALUE], produces = [APPLICATION_JSON_VALUE])
    @ApiOperation(tags = [SWAGGER_TAG_SNS_EPIC_API], value = "SNS계정을 연동한다.", notes = DOC_REGISTER_SNS_ACCOUNT)
    fun registerSNSAccount(@Valid request: RegisterSNSAccountRequest) = Unit.toMono()

    @PutMapping("/api/sns-accounts", consumes = [APPLICATION_FORM_URLENCODED_VALUE], produces = [APPLICATION_JSON_VALUE])
    @ApiOperation(tags = [SWAGGER_TAG_SNS_EPIC_API], value = "SNS계정을 수정햔다.", notes = DOC_REGISTER_SNS_ACCOUNT)
    @ApiImplicitParams(
            value = [
                ApiImplicitParam(
                        name = "type",
                        example = "FACEBOOK",
                        paramType = "form",
                        required = true,
                        allowEmptyValue = false,
                        allowableValues = "FACEBOOK, KAKAO, NAVER, APPLE",
                        allowMultiple = true
                ),
                ApiImplicitParam(
                        name = "sns_token",
                        example = "ktldvk3-afkasltkdvlk",
                        paramType = "form",
                        required = true,
                        allowEmptyValue = false
                )
            ]
    )
    fun updateSNSAccount(@Valid request: UpdateSNSAccountRequest) = Unit.toMono()

    @DeleteMapping("/api/sns-accounts/{sns-account-id}", consumes = [APPLICATION_FORM_URLENCODED_VALUE], produces = [APPLICATION_JSON_VALUE])
    @ApiOperation(tags = [SWAGGER_TAG_SNS_EPIC_API], value = "SNS계정을 끊어낸다.", notes = DOC_REGISTER_SNS_ACCOUNT)
    fun deleteSNSAccount(@PathVariable
                         @ApiParam(
                                 example = "01012345678",
                                 required = true,
                                 allowEmptyValue = false
                         )
                         snsAccountId: String
    ) = Unit.toMono()
}
