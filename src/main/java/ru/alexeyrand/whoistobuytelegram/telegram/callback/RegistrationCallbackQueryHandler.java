package ru.alexeyrand.whoistobuytelegram.telegram.callback;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.alexeyrand.whoistobuytelegram.telegram.TelegramBot;

import java.util.List;

@Component
public class RegistrationCallbackQueryHandler extends AbstractCallbackQueryHandler  {


    public RegistrationCallbackQueryHandler(TelegramBot telegramBot) {
        super(telegramBot);
    }

    @Override
    public String getCallbackQueryType() {
        return "registration";
    }

    @Override
    public InlineKeyboardMarkup getInlineMarkup() {
        return InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder()
                                .text("Зарегистрироваться")
                                .callbackData("registration:confirm")
                                .build(),
                        InlineKeyboardButton.builder()
                                .text("Отмена")
                                .callbackData("registration:cancel")
                                .build()
                ))
                .build();
    }

    @Override
    protected void processCallback(CallbackQuery callbackQuery) {
        String data = callbackQuery.getData();

        if (data.equals("registration:confirm")) {
            handleRegistrationConfirm(callbackQuery);
        } else if (data.equals("registration:cancel")) {
            handleRegistrationCancel(callbackQuery);
        }
    }

    private void handleRegistrationConfirm(CallbackQuery callbackQuery) {
        SendMessage sendMessage = SendMessage.builder().text("Регистрация подтверждена!").build();
        telegramBot.send(sendMessage);
    }

    private void handleRegistrationCancel(CallbackQuery callbackQuery) {
        SendMessage sendMessage = SendMessage.builder().text("Регистрация отменена!").build();
        telegramBot.send(sendMessage);
    }
}
