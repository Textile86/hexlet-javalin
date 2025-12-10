package org.example.hexlet;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;

import io.javalin.validation.ValidationException;
import org.apache.commons.text.StringEscapeUtils;

import org.example.hexlet.controller.CoursesController;
import org.example.hexlet.controller.SessionsController;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.model.NamedRoutes;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.BaseRepository;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class HelloWorld {

    public static void main(String[] args) throws Exception {
        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:h2:mem:project;DB_CLOSE_DELAY=-1;");

        var dataSource = new HikariDataSource(hikariConfig);

        var url = HelloWorld.class.getClassLoader().getResourceAsStream("schema.sql");
        var sql = new BufferedReader(new InputStreamReader(url))
                .lines().collect(Collectors.joining("\n"));

        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.execute(sql);
        }
        BaseRepository.dataSource = dataSource;

        try {
            // Используем конструктор с двумя параметрами (без ID)
            CourseRepository.save(new Course("Java Basics", "Основы программирования на Java"));
            CourseRepository.save(new Course("Web Development", "Веб-разработка с Javalin"));
            CourseRepository.save(new Course("Database", "Работа с базами данных"));
            CourseRepository.save(new Course("Python", "Программист на Python"));
            CourseRepository.save(new Course("Front-End", "Фронт энт разработчик"));
            System.out.println("DEBUG: Начальные курсы добавлены в базу");
        } catch (SQLException e) {
            System.out.println("DEBUG: Ошибка при добавлении начальных курсов: " + e.getMessage());
            e.printStackTrace();
        }

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.before(ctx -> {
            LocalDateTime now = java.time.LocalDateTime.now();
            System.out.println("Запрос получен в: " + now);
        });

        app.before(ctx -> {
            String path = ctx.path();
            System.out.println("Путь запроса: " + path);
        });

        app.get("/", ctx -> {
            Boolean visited = Boolean.valueOf(ctx.cookie("visited"));
            String currentUser = ctx.sessionAttribute("currentUser");
            MainPage page = new MainPage(visited, currentUser);
            page.setCurrentUser(currentUser);
            ctx.render("index.jte", model("page", page));
            ctx.cookie("visited", String.valueOf(true));
        });

        app.get(NamedRoutes.buildSessionsPath(), SessionsController::build);
        app.post(NamedRoutes.sessionsPath(), SessionsController::create);
        app.delete(NamedRoutes.sessionsPath(), SessionsController::destroy);

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

        app.after(ctx -> {
            System.out.println("Статус ответа: " + ctx.status());
        });

        app.start(7070);
    }
}