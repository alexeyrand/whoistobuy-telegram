package ru.alexeyrand.whoistobuytelegram.repositories;

import org.springframework.stereotype.Repository;
import ru.alexeyrand.whoistobuybase.repositories.BaseRepository;
import ru.alexeyrand.whoistobuytelegram.entities.TelegramUser;

import java.util.Optional;

@Repository
public interface TelegramUserRepository extends BaseRepository<TelegramUser> {
    boolean existsByUsername(String username);
    boolean existsByChatId(Long username);
    Optional<TelegramUser> findByUsername(String username);
    Optional<TelegramUser> findByChatId(Long chatId);
}
