package org.example.hexlet;
import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/courses/{id}", ctx -> {
            ctx.result("Cource ID: " + ctx.pathParam("id"));
        });
        app.get("/users/{id}", ctx -> {
            ctx.result("Users ID: " + ctx.pathParam("id"));
        });
        app.get("/users/{id}/posts/{postId}", ctx -> {
            String userId = ctx.pathParam("id");
            String postId = ctx.pathParam("postId");
            ctx.result("Course ID: " + userId + " Post ID: " + postId);
        });
        app.start(7071);
    }
}