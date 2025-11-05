package ru.alexeyrand.whoistobuytelegram.telegram.callback;

import java.util.HashMap;
import java.util.Map;


public class BaseCallBackQueryHandler {

    private BaseCallBackQueryHandler handler;
    private Map<String, BaseCallBackQueryHandler> handlerContainer = new HashMap<>();

    public BaseCallBackQueryHandler(String key, BaseCallBackQueryHandler handler) {
        handlerContainer.put(key, handler);
    }

    public void fill() {};



//    public static void handle(BaseCallBackQueryHandler  handler) {
////        handler.fill();
//
//    }

    public  void fillData(String data) {

            handlerContainer.get(data).fill();

    }

}
