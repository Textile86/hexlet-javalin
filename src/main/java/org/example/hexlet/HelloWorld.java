package org.example.hexlet;
import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/hello", ctx -> {
            String name = ctx.queryParam("name");git
            if (name == null) {
                name = "World";
            }
            String greeting = "Hello " + name + "!";
            ctx.result(greeting);
        });
        app.start(7070);
    }
}