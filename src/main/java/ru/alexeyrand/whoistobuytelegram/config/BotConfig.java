package ru.alexeyrand.whoistobuytelegram.config;

import lombok.Data;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Data
public class BotConfig {
    @Value("${bot.name}")
    String name;
    @Value("${bot.token}")
    String token;

}
