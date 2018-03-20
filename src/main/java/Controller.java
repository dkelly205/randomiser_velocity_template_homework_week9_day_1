import models.Randomizer;
import spark.ModelAndView;
import spark.Spark;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class Controller {

    public static void main(String[] args) {
        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        staticFileLocation("/public");


        get("/names/:number", (req, res)->{

            int amount = Integer.parseInt(req.params(":number"));
            List<String> names = Randomizer.getNames(amount);

            HashMap<String, Object> model = new HashMap<>();
            model.put("names", names);
            model.put("template", "one.vtl");

            return new ModelAndView(model, "layout.vtl");

        }, velocityTemplateEngine);

        Spark.exception(Exception.class, (exception, request, response) -> {
            exception.printStackTrace();
        });

    }
}
