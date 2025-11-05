package ru.alexeyrand.whoistobuytelegram.telegram.callback;

import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.alexeyrand.whoistobuytelegram.services.TelegramUserService;
import ru.alexeyrand.whoistobuytelegram.telegram.TelegramBot;

@RequiredArgsConstructor
public abstract class AbstractCallbackQueryHandler {

    protected final TelegramBot telegramBot;

    public abstract String getCallbackQueryType();

    public abstract InlineKeyboardMarkup getInlineMarkup();

    public void handleCallbackQuery(CallbackQuery callbackQuery) {
        try {
            processCallback(callbackQuery);
        } catch (Exception e) {
            handleError(callbackQuery, e);
        }
    }

    protected abstract void processCallback(CallbackQuery callbackQuery);

    protected void handleError(CallbackQuery callbackQuery, Exception e) {
        SendMessage sendMessage = SendMessage.builder().text("Произошла ошибка при обработке запроса").build();
        telegramBot.send(sendMessage);
    }
}