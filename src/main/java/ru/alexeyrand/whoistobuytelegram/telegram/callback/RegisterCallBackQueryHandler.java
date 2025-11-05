package ru.alexeyrand.whoistobuytelegram.telegram.callback;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.alexeyrand.whoistobuytelegram.services.TelegramUserService;

@Component
@RequiredArgsConstructor
public class RegisterCallBackQueryHandler extends BaseCallBackQueryHandler {

    private final TelegramUserService telegramUserService;

    @Override
    void fill() {

    }
}
