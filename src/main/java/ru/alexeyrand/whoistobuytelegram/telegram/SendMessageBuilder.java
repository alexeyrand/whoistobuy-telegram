package ru.alexeyrand.whoistobuytelegram.telegram;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class SendMessageBuilder {

    private SendMessage sendMessage;

    public SendMessage build() {
        return sendMessage;
    }

    public static SendMessageBuilder builder() {
        return new SendMessageBuilder();
    }

    public SendMessageBuilder chatId(Long chatId) {
        sendMessage.setChatId(chatId);
        return this;
    }

    public SendMessageBuilder text(String text) {
        sendMessage.setText(text);
        return this;
    }

}