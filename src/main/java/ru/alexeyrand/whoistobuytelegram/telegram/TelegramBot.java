package ru.alexeyrand.whoistobuytelegram.telegram;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.MaybeInaccessibleMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.alexeyrand.whoistobuybase.services.UserService;
import ru.alexeyrand.whoistobuytelegram.config.BotConfig;
import ru.alexeyrand.whoistobuytelegram.entities.TelegramUser;
import ru.alexeyrand.whoistobuytelegram.enums.InlineKeyboardType;
import ru.alexeyrand.whoistobuytelegram.services.TelegramUserService;
import ru.alexeyrand.whoistobuytelegram.telegram.Inline.RegisterInlineKeyboard;
import ru.alexeyrand.whoistobuytelegram.telegram.callback.BaseCallBackQueryHandler;
import ru.alexeyrand.whoistobuytelegram.telegram.callback.RegisterCallBackQueryHandler;
import ru.alexeyrand.whoistobuytelegram.utils.TelegramUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    private final BotConfig botConfig;
    private final UserService userService;
    private final TelegramUtils telegramUtils;
    private final TelegramUserService telegramUserService;
    private final BaseCallBackQueryHandler callBackQueryHandler;


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
            Long chatId = message.getChatId();
            if (!telegramUserService.isRegisteredOnTelegram(chatId)) {
                SendMessage sendMessage = InlineKeyboardType.REGISTRATION.createMessage(chatId);
                this.send(sendMessage);
            }

            String telephone = message.getText();


            SendMessage sendMessage = telegramUtils.sendMessage("Привет!", chatId);
            this.execute(sendMessage);


        // Обработка нажатий на inline кнопки
        } else if (update.hasCallbackQuery()) {
            CallbackQuery query = update.getCallbackQuery();

            MaybeInaccessibleMessage message = query.getMessage();

            Long chatId = message.getChatId();
            String data = query.getData();

            callBackQueryHandler.fillData(data);
        }
    }


    @SneakyThrows
    public void send(SendMessage sendMessage) {
        this.execute(sendMessage);
    }

}
