package ru.alexeyrand.whoistobuytelegram.entities;

import lombok.Data;
import ru.alexeyrand.whoistobuybase.entities.BaseEntity;

@Data
public class TelegramUser extends BaseEntity {
    private String username;
    private long chatId;
}
