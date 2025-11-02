package ru.alexeyrand.whoistobuytelegram.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alexeyrand.whoistobuybase.exceptions.UserNotFoundException;
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

    public boolean isRegisteredOnTelegram(Long chatId) {
        return telegramUserRepository.existsByChatId(chatId);
    }

    public TelegramUser findTelegramUserByUsername(String username) {
        return telegramUserRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
    }

    public TelegramUser findTelegramUserByChatId(Long chatId) {
        return telegramUserRepository.findByChatId(chatId).orElseThrow(() -> new UserNotFoundException(chatId));
    }



    @Override
    public BaseRepository<TelegramUser> getRepository() {
        return telegramUserRepository;
    }
}
