package core;
import com.pengrad.telegrambot.*;
/**
 * Created by samuelmachado on 05/07/2016.
 */
public class Model {
    TelegramBot bot = TelegramBotAdapter.build("235548784:AAHkS-f8J4D4LTM527TldPFHRKt0DL1ykB4");

    protected void sendMessage(String chatId,String text){
        bot.sendMessage(chatId, text);
    }
}
