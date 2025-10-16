package ru.alexeyrand.whoistobuytelegram.repositories;

import org.springframework.stereotype.Repository;
import ru.alexeyrand.whoistobuybase.repositories.BaseRepository;
import ru.alexeyrand.whoistobuytelegram.entities.TelegramUser;

@Repository
public interface TelegramUserRepository extends BaseRepository<TelegramUser> {
    boolean existsByUsername(String username);
}
