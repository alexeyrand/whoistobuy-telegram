package ru.alexeyrand.whoistobuytelegram.telegram.Inline;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.alexeyrand.whoistobuytelegram.telegram.SendMessageBuilder;

public abstract class BaseInlineKeyboard {

    abstract InlineKeyboardMarkup createInlineKeyboardMarkup();



    public SendMessage createSendMessage() {
        return SendMessageBuilder.builder()
                .text("")
                .chatId(1L)
                .inlineKeyboard(createInlineKeyboardMarkup())
                .build();
    }
}
