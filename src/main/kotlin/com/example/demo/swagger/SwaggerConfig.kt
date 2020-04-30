package com.example.demo.swagger

import org.springframework.boot.info.BuildProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.http.ResponseEntity
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebSession
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors.regex
import springfox.documentation.builders.RequestHandlerSelectors.basePackage
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType.SWAGGER_2
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux
import java.util.*

@Configuration
@EnableSwagger2WebFlux
@Import(BeanValidatorPluginsConfiguration::class)
class SwaggerConfig(
        private val buildProperties: BuildProperties
) {
    @Bean
    fun docket() = Docket(SWAGGER_2)
            .enable(true)
            .apiInfo(ApiInfoBuilder()
                    .description("Sample APIs")
                    .title(buildProperties.name)
                    .version(buildProperties.version)
                    .license("Apache License Version 2.0")
                    .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0\n")
                    .contact(Contact("Soo", "coding8282", "coding8282@gmail.com"))
                    .termsOfServiceUrl("asdfasdf")
                    .build())
            .useDefaultResponseMessages(false)
            .ignoredParameterTypes(
                    WebSession::class.java,
                    ServerHttpRequest::class.java,
                    ServerHttpResponse::class.java,
                    ServerWebExchange::class.java)
            .genericModelSubstitutes(
                    Optional::class.java,
                    Mono::class.java,
                    Flux::class.java,
                    ResponseEntity::class.java)
            .select()
            .apis(basePackage("com.example.demo"))
            .paths(regex("/api/.*"))
            .build()
}
