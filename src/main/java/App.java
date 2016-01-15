import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        // ProcessBuilder process = new ProcessBuilder();
        // Integer port;
        // if (process.environment().get("PORT") != null) {
        //     port = Integer.parseInt(process.environment().get("PORT"));
        // } else {
        //     port = 4567;
        // }
        //
        // setPort(port);

        //RESTful ARCHITECTURE
        //Use POST to create something on the server
        //Use GET to retrieve something from the server
        //Use PUT to change or update something on the server
        //Use DELETE to remove or delete something on the server
        //Keep URLs intuitive
        //Each request from client contains all info necessary for that request

        //ROUTES: Home Page

        get("/", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
            model.put("words", Word.getAll());
            model.put("template", "templates/allwords.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        //ROUTES: Identification of Resources

        get("/new", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/new.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/:id", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          boolean wordNotAdded = false;
          if (Word.getWord(request.params(":id")) == null) {
            wordNotAdded = true;
          }
          model.put("wordnotadded", wordNotAdded);
          model.put("word", Word.getWord(request.params(":id")));
          model.put("template", "templates/word.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        //ROUTES: Changing Resources

        post("/", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          boolean alreadyAdded = false;
          String userWord = request.queryParams("userword");

          if (Word.getWord(userWord) != null) {
            alreadyAdded = true;
          } else {
            Word newWord = new Word(userWord);
          }

          model.put("alreadyadded", alreadyAdded);
          model.put("words", Word.getAll());
          model.put("template", "templates/allwords.vtl");
          return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      post("/:id", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          Word thisWord = Word.getWord(request.params(":id"));
          String userDefinition = request.queryParams("userdefinition");
          String userExample = request.queryParams("userexample");
          Definition newDefinition = new Definition(userDefinition, userExample);

          thisWord.addDefinition(newDefinition);

          model.put("word", thisWord);
          model.put("template", "templates/word.vtl");
          return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

    }
}
