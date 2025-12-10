package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.NamedRoutes;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class UsersController {
    public static void build(Context ctx) {
        var page = new BuildUserPage();
        ctx.render("users/build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var email = ctx.formParam("email");

        try {
            var passwordConfirmation = ctx.formParam("passwordConfirmation");
            var password = ctx.formParamAsClass("password", String.class)
                    .check(value -> value.equals(passwordConfirmation), "Пароли не совпадают")
                    .get();
            var user = new User(name, email, password);
            UserRepository.save(user);
            ctx.sessionAttribute("flash", "Пользователь успешно создан");
            ctx.redirect(NamedRoutes.usersPath());
        } catch (ValidationException e) {
            var page = new BuildUserPage(name, email, e.getErrors());
            page.setFlashError("Ошибка при регистрации пользователя: пароли не совпадают");
            ctx.render("users/build.jte", model("page", page));
        } catch (SQLException e) {
            var page = new BuildUserPage(name, email, null);
            page.setFlashError("Ошибка при регистрации пользователя: " + e.getMessage());
            ctx.render("users/build.jte", model("page", page));
        }
    }

    public static void index(Context ctx) {
        try {
            var users = UserRepository.getEntities();
            UsersPage page = new UsersPage(users);

            String flashSuccess = ctx.consumeSessionAttribute("flash");
            String flashError = ctx.consumeSessionAttribute("flash-error");  // с дефисом!

            if (flashError != null) {
                page.setFlashError(flashError);  // Используем setFlashError
            } else if (flashSuccess != null) {
                page.setFlashSuccess(flashSuccess);  // Используем setFlashSuccess
            }

            ctx.render("users/index.jte", model("page", page));  // Передаём page, а не users
        } catch (SQLException e) {
            var page = new UsersPage(List.of());
            page.setFlashError("Не удалось загрузить пользователей: " + e.getMessage());
            ctx.render("users/index.jte", model("page", page));
        }
        }
}
