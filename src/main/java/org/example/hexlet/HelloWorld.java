package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;

import io.javalin.validation.ValidationException;
import org.apache.commons.text.StringEscapeUtils;

import org.example.hexlet.controller.CoursesController;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.model.NamedRoutes;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

import java.util.List;
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

        app.get(NamedRoutes.buildCoursesPath(), CoursesController::build);
        app.post(NamedRoutes.coursesPath(), CoursesController::create);
        app.get(NamedRoutes.coursesPath(), CoursesController::index);
        app.get(NamedRoutes.coursePath("{id}"), CoursesController::show);

        app.get(NamedRoutes.buildUsersPath(), UsersController::build);
        app.post(NamedRoutes.usersPath(), UsersController::create);
        app.get(NamedRoutes.usersPath(), UsersController::index);


        app.get(NamedRoutes.userPath("{id}"), ctx -> {
            var id = ctx.pathParam("id");
            var escapedId = StringEscapeUtils.escapeHtml4(id);
            ctx.contentType("text/html");
            ctx.result(escapedId);
        });

        app.get("/safe-users/{id}", ctx -> {
            var id = ctx.pathParam("id");
            ctx.render("safe-user.jte", model("userId", id));
        });

        app.start(7070);
    }
}