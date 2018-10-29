package io.github.mpao.florencebackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.client.RestTemplate
import org.springframework.context.annotation.Bean

@SpringBootApplication
class App{

    @Bean
    fun restTemplate(): RestTemplate = RestTemplate()

}