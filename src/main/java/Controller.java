import models.Randomizer;
import spark.ModelAndView;
import spark.Spark;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class Controller {

    public static void main(String[] args) {
        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
        VelocityTemplateEngine velocityTemplateEngine2 = new VelocityTemplateEngine();

        staticFileLocation("/public");


        get("/one", (req, res)->{
            Randomizer randomizer = new Randomizer();
            randomizer.addName("Neil");
            randomizer.addName("Rick");
            randomizer.addName("Mike");
            randomizer.addName("Vivien");

            HashMap<String, Object> model = new HashMap<>();
            model.put("result", randomizer.getWinner());
            model.put("template", "one.vtl");

            return new ModelAndView(model, "layout.vtl");

        }, velocityTemplateEngine);

        Spark.exception(Exception.class, (exception, request, response) -> {
            exception.printStackTrace();
        });


        get("/two", (req, res)->{
            Randomizer randomizer = new Randomizer();
            randomizer.addName("Neil");
            randomizer.addName("Rick");
            randomizer.addName("Mike");
            randomizer.addName("Vivien");

            HashMap<String, Object> model = new HashMap<>();
            model.put("result", randomizer.getPairOfNames());
            model.put("template", "two.vtl");

            return new ModelAndView(model, "layout.vtl");

        }, velocityTemplateEngine2);


    }
}
