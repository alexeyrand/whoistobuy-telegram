package ru.alexeyrand.whoistobuytelegram.telegram.Inline;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class RegisterInlineKeyboard extends BaseInlineKeyboard {

    @Override
    public InlineKeyboardMarkup createInlineKeyboardMarkup() {
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton registerButton = new InlineKeyboardButton();
        registerButton.setText("📝 Регистрация");
        registerButton.setCallbackData("register-button");

        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(registerButton);

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(row);

        keyboardMarkup.setKeyboard(keyboard);

        return keyboardMarkup;
    }
}
