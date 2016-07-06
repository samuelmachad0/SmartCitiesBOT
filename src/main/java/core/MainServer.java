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
            return "www.telegram.me/smartcitiesbot";
        });
        // Admin Group for Test -145562622
        get("/testMessage", (req, res) -> {
            controller.send("-145562622","test message");
            return "The message was sent for Admin Group";
        });
    }
}
