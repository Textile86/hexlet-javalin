package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;
import org.apache.commons.text.StringEscapeUtils;

import org.example.hexlet.model.Course;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        CourseRepository.save(new Course(1L, "Java Basics", "Основы программирования на Java"));
        CourseRepository.save(new Course(2L, "Web Development", "Веб-разработка с Javalin"));
        CourseRepository.save(new Course(3L, "Database", "Работа с базами данных"));
        CourseRepository.save(new Course(4L, "Python", "Программист на Python"));
        CourseRepository.save(new Course(5L, "Front-End", "Фронт энт разработчик"));

        app.get("/", ctx -> ctx.render("index.jte"));

        app.get("/courses/build", ctx -> {
            ctx.render("courses/build.jte");
        });

        app.post("/courses", ctx -> {
            var name = ctx.formParam("name").trim();
            var description = ctx.formParam("description").trim();

            var course = new Course(name, description);
            CourseRepository.save(course);
            ctx.redirect("/courses");
        });

        app.get("/courses", ctx -> {
            var term = ctx.queryParam("term");
            var header = "Курсы по программированию";

            List<Course> filteredCourses;
            List<Course> allCourses = CourseRepository.getEntities();

            if (term != null && !term.trim().isEmpty()) {
                String searchTerm = term.toLowerCase().trim();
                filteredCourses = allCourses.stream()
                        .filter(course ->
                                course.getName().toLowerCase().contains(searchTerm) ||
                                        course.getDescription().toLowerCase().contains(searchTerm)
                        )
                        .collect(Collectors.toList());
            } else {
                filteredCourses = allCourses;
            }

            var page = new CoursesPage(filteredCourses, header, term);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.get("/courses/{id}", ctx -> {
            List<Course> courses = CourseRepository.getEntities();
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

        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");
        });

        app.post("/users", ctx -> {
            var name = ctx.formParam("name").trim();
            var email = ctx.formParam("email").trim().toLowerCase();
            var password = ctx.formParam("password");
            var passwordConfirmation = ctx.formParam("passwordConfirmation");

            var user = new User(name, email, password);
            UserRepository.save(user);
            ctx.redirect("/users");
        });

        app.get("/users", ctx -> {
            var users = UserRepository.getEntities();
            ctx.render("users/index.jte", model("users", users));
        });

        app.get("/test-escape", ctx -> {
            String dangerousInput = "<script>alert('XSS')</script><div>Normal text</div>";
            String safeOutput = StringEscapeUtils.escapeHtml4(dangerousInput);

            ctx.result("Оригинал: " + dangerousInput + "\n\nБезопасно: " + safeOutput);
        });

        app.get("/safe-users/{id}", ctx -> {
            var id = ctx.pathParam("id");
            ctx.render("safe-user.jte", model("userId", id));
        });

        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParam("id");
            var escapedId = StringEscapeUtils.escapeHtml4(id);
            ctx.contentType("text/html");
            ctx.result(escapedId);
        });

        app.start(7070);
    }
}