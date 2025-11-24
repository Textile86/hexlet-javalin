package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;

import org.example.hexlet.model.Course;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.courses.CoursePage;

import java.util.List;
import java.util.ArrayList;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // Создаем тестовые данные (пока без базы данных)
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1L, "Java Basics", "Основы программирования на Java"));
        courses.add(new Course(2L, "Web Development", "Веб-разработка с Javalin"));
        courses.add(new Course(3L, "Database", "Работа с базами данных"));

        app.get("/", ctx -> ctx.render("index.jte"));

        app.get("/courses", ctx -> {
            var header = "Курсы по программированию";
            var page = new CoursesPage(courses, header);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.get("/courses/{id}", ctx -> {
            var id = Long.parseLong(ctx.pathParam("id"));
            var course = courses.stream()
                    .filter(c -> c.getId().equals(id))
                    .findFirst()
                    .orElse(null);

            if (course != null) {
                var page = new CoursePage(course);
                ctx.render("courses/show.jte", model("page", page));
            } else {
                ctx.status(404).result("Course not found");
            }
        });

        app.start(7070);
    }
}