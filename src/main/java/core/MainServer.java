package core;

import static spark.Spark.*;

public class MainServer {
    public static void main(String[] args) {

		// Get port config of heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
        Controller controller = new Controller();

        Integer myPort;
        if (process.environment().get("PORT") != null) {
            myPort = Integer.parseInt(process.environment().get("PORT"));
        } else {
            myPort = 8080;
        }
        port(myPort);

		//Delivery static file
		staticFileLocation("/static");

		// Index
		get("/", (req, res) -> {
            return "Talk to me www.telegram.me/smartcitiesbot";
        });

        //Data is sent by telegram API on this route
        post("/readMessages", (req, res) -> {
             controller.read(req.bodyAsBytes());
            return "Success";
        });


        // Admin Group for Test -145562622
        get("/testMessage", (req, res) -> {
            controller.send("test message","-145562622");
            return "The message was sent for Admin Group";
        });
    }
}
