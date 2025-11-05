package ru.alexeyrand.whoistobuytelegram.enums;

import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.alexeyrand.whoistobuytelegram.telegram.SendMessageBuilder;

public enum InlineKeyboardType {
    REGISTRATION {
        @Override
        public void setText() {
            this.text = "Регистрация";
        }

        @Override
        public InlineKeyboardMarkup createKeyboard() {
            InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
            return markup;
        }
    },

    MENU {
        @Override
        public void setText() {
            this.text = "Меню";
        }

        @Override
        public InlineKeyboardMarkup createKeyboard() {
            InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
            return markup;
        }
    };


    @Getter
    String text;
    public abstract InlineKeyboardMarkup createKeyboard();
    public abstract void setText();
    public SendMessage createMessage(Long chatId) {
        return SendMessageBuilder.builder()
                .text(getText())
                .chatId(chatId)
                .inlineKeyboard(createKeyboard())
                .build();
    }
}
