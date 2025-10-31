package ru.alexeyrand.whoistobuytelegram.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.alexeyrand.whoistobuybase.exceptions.UserNotFoundException;
import ru.alexeyrand.whoistobuytelegram.entities.TelegramUser;
import ru.alexeyrand.whoistobuytelegram.telegram.SendMessageBuilder;
import ru.alexeyrand.whoistobuytelegram.telegram.TelegramBot;
import ru.alexeyrand.whoistobuytelegram.utils.TelegramUtils;

@Service
@RequiredArgsConstructor
public class TelegramNotificationService {
    private TelegramUserService telegramUserService;
    private TelegramBot telegramBot;

    public void sendNotification(String username) {
        if (!telegramUserService.isRegisteredOnTelegram(username)) {
            throw new UserNotFoundException(username);
        }
        TelegramUser telegramUser = telegramUserService.findTelegramUserByUsername(username);
        Long chatId = telegramUser.getChatId();

        SendMessage sendMessage = SendMessageBuilder.builder().text("hello").chatId(chatId).build();
        telegramBot.send(sendMessage);
    }

}
