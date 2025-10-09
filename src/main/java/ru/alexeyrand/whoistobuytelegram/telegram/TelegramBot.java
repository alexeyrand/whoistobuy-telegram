package ru.alexeyrand.whoistobuytelegram.telegram;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.alexeyrand.whoistobuybase.services.UserService;
import ru.alexeyrand.whoistobuytelegram.config.BotConfig;
import ru.alexeyrand.whoistobuytelegram.utils.TelegramUtils;

@Service
@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    private final BotConfig botConfig;
    private final UserService userService;
    private final TelegramUtils telegramUtils;

    @Override
    public String getBotUsername() {
        return botConfig.getName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    /**
     * Метод по обработке событий Telegram
     */
    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            String telephone = message.getText();
            Long chatId = message.getChatId();

            // Если такого пользователя еще нет в базе данных - предложить зарегистрироваться
            if (!userService.existsByChatId(chatId)) {
                SendMessage sendMessage = telegramUtils.sendMessage("Для работы с телеграм ботом вам необходимо зарегистрироваться", chatId);
                this.execute(sendMessage);
            } else {
                SendMessage sendMessage = telegramUtils.sendMessage("Привет!", chatId);
                this.execute(sendMessage);
            }
        }
    }

}
