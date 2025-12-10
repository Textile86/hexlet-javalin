package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.NamedRoutes;
import org.example.hexlet.repository.CourseRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.sql.SQLException;

import static io.javalin.rendering.template.TemplateUtil.model;

public class CoursesController {
    public static void build(Context ctx) {
        var page = new BuildCoursePage();
        ctx.render("courses/build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        String name = null;
        String description = null;
        try {
            name = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() > 2, "Имя должно быть длиннее 2х символов")
                    .get();
            description = ctx.formParamAsClass("description", String.class)
                    .check(value -> value.length() > 10, "Описание должно быть длиннее 10ти символов")
                    .get();
            var course = new Course(name, description);
            CourseRepository.save(course);
            ctx.sessionAttribute("flash", "Курс успешно создан");
            ctx.redirect(NamedRoutes.coursesPath());
        } catch (ValidationException e) {
            var page = new BuildCoursePage(name, description, e.getErrors());

            String errorMessage = "Ошибка при создании курса: ";
            if (name != null && name.length() <= 2) {
                errorMessage += "имя должно быть длиннее 2х символов";
            } else if (description != null && description.length() <= 10) {
                errorMessage += "описание должно быть длиннее 10ти символов";
            }
            page.setFlashError(errorMessage);

            ctx.render("courses/build.jte", model("page", page));
        } catch (SQLException e) {
            var page = new BuildCoursePage(name, description, null);
            page.setFlashError("Ошибка базы данных: " + e.getMessage());
            ctx.render("courses/build.jte", model("page", page));
        }

    }

    public static void index(Context ctx) {
        try {
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
            String flashSuccess = ctx.consumeSessionAttribute("flash");
            String flashError = ctx.consumeSessionAttribute("flash-error");

            if (flashSuccess != null) {
                page.setFlashSuccess(flashSuccess);
            } else if (flashError != null) {
                page.setFlashError(flashError);
            }
            ctx.render("courses/index.jte", model("page", page));
        } catch (SQLException e) {
            var page = new CoursesPage(List.of(), "Ошибка базы данных", null);
            page.setFlashError("Не удалось загрузить курсы: " + e.getMessage());
            ctx.render("courses/index.jte", model("page", page));
        }
    }

    public static void show(Context ctx) {
        try {
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

        } catch (SQLException e) {
            ctx.status(500).result("Ошибка базы данных: " + e.getMessage());
        } catch (NumberFormatException e) {
            ctx.status(400).result("Неверный формат ID");
        }
    }

}
