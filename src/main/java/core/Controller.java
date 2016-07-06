package core;
import org.json.JSONException;
import java.io.IOException;
/**
 * Created by samuelmachado on 05/07/2016.
 */
public class Controller {
    Model model = new Model();


    protected void send(String chatId, String text){
        model.sendMessage(chatId,text);
    }
}
