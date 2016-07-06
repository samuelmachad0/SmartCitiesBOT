package core;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.Long;


/**
 * Created by samuelmachado on 05/07/2016.
 */
public class Controller {
    Model model = new Model();
    JSONObject body;

    protected void send(String text, String chatId){model.sendMessage(text,chatId);
    }

    protected void read(byte[] bodyRequest){
        try {
            model.setUpdate(new String(bodyRequest, "UTF-8"));
            if(model.getTypeChatCommon() == true){
                send("Hello, you sent me: " + model.getMessage(),model.getChatId());
            } else {
                send("Hello, you using inline!",model.getChatId());
            }
        } catch(Exception e){
            // Admin notification
            send(e.getMessage() + "\n" + e.getStackTrace(),"-145562622");
        }
    }
}
