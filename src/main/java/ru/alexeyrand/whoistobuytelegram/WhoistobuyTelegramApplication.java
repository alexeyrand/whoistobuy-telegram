package ru.alexeyrand.whoistobuytelegram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("ru.alexeyrand.*")
public class WhoistobuyTelegramApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhoistobuyTelegramApplication.class, args);
	}

}
