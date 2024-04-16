package org.maats.videogamestore.configuration;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RestClientConfiguration {

    @Bean
    public OkHttpClient configureOkHttpClient() {
        return new OkHttpClient();
    }
}
