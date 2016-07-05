package view;

import static spark.Spark.*;
import spark.ModelAndView;
import java.util.*;
import spark.template.mustache.*;

public class MainServer {
    public static void main(String[] args) {

		// Get port config of heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
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

    }
}
