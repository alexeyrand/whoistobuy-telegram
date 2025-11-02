package ru.alexeyrand.whoistobuytelegram.telegram;

import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Setter
public class SendMessageBuilder {

    private Long chatId;
    private String text;
    private InlineKeyboardMarkup inlineKeyboardMarkup;

    public SendMessage build() {
        if (chatId == null) {
            throw new IllegalStateException("chatId is required");
        }
        if (text == null) {
            throw new IllegalStateException("text is required");
        }

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        return sendMessage;
    }

    public static SendMessageBuilder builder() {
        return new SendMessageBuilder();
    }

    public SendMessageBuilder chatId(Long chatId) {
        this.setChatId(chatId);
        return this;
    }

    public SendMessageBuilder inlineKeyboard(InlineKeyboardMarkup inlineKeyboardMarkup) {
        this.setInlineKeyboardMarkup(inlineKeyboardMarkup);
        return this;
    }

    public SendMessageBuilder text(String text) {
        this.setText(text);
        return this;
    }

}