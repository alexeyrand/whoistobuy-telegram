package ru.alexeyrand.whoistobuytelegram.services;

import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alexeyrand.whoistobuybase.repositories.BaseRepository;
import ru.alexeyrand.whoistobuybase.services.BaseService;
import ru.alexeyrand.whoistobuybase.services.UserService;
import ru.alexeyrand.whoistobuytelegram.entities.TelegramUser;
import ru.alexeyrand.whoistobuytelegram.repositories.TelegramUserRepository;

@Service
@RequiredArgsConstructor
public class TelegramUserService extends BaseService<TelegramUser> {

    private final TelegramUserRepository telegramUserRepository;

    public boolean isRegisteredOnTelegram(String username) {
        return telegramUserRepository.existsByUsername(username);
    }

    public TelegramUser findTelegramUserByUsername(String username) {
        return telegramUserRepository.findByUsername(username).orElseThrow(NotFoundException::new);
    }




    @Override
    public BaseRepository<TelegramUser> getRepository() {
        return telegramUserRepository;
    }
}
