package ru.alexeyrand.whoistobuytelegram.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.alexeyrand.whoistobuybase.rest.WitbHttpClient;

@Configuration
public class HttpClientConfig {

    @Bean
    public WitbHttpClient witbHttpClient() {
        return new WitbHttpClient();
    }
}
