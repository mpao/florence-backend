package io.github.mpao.florencebackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.client.RestTemplate
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import java.util.*
import org.springframework.http.converter.HttpMessageConverter
import java.util.ArrayList

@SpringBootApplication
class App{

    @Bean
    fun restTemplate(): RestTemplate {

        // Gli opendata hanno header generici e la coppia kotlin-jackson
        // va in crisi per la deserializzazione
        // soluzione: https://stackoverflow.com/a/44219832/1588252
        val messageConverters = ArrayList<HttpMessageConverter<*>>()
        val converter = MappingJackson2HttpMessageConverter()
        val restTemplate = RestTemplate()
        converter.supportedMediaTypes = Arrays.asList(MediaType.ALL)
        messageConverters.add(converter)
        restTemplate.messageConverters = messageConverters
        return restTemplate

    }

}