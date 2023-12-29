package com.carpentery.springboot.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootApplication(scanBasePackages = {"com.carpentery.springboot.controller","com.carpentery.springboot.service","com.carpentery.springboot.model"},exclude = { JacksonAutoConfiguration.class })
public class CarpenterCloudApplication {
	@Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        builder.featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        builder.serializationInclusion(JsonInclude.Include.NON_NULL);
        builder.modules(new JavaTimeModule());
        builder.featuresToDisable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);

        // Ignorar referencias circulares
        builder.featuresToDisable(SerializationFeature.FAIL_ON_SELF_REFERENCES);
        builder.featuresToDisable(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS);

        return builder;
    }
	public static void main(String[] args) {
		SpringApplication.run(CarpenterCloudApplication.class, args);
	}
	
	 @Bean
	    public ModelMapper modelMapper() {
	        return new ModelMapper();
	    }

}
 