package ru.alexeyrand.whoistobuytelegram.services;

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
        boolean existsByUsername = telegramUserRepository.existsByUsername(username);
        return true;
    }





    @Override
    public BaseRepository<TelegramUser> getRepository() {
        return telegramUserRepository;
    }
}
