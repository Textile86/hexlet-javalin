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
            ctx.redirect(NamedRoutes.coursesPath());
        } catch (ValidationException e) {
            var page = new BuildCoursePage(name, description, e.getErrors());
            ctx.render("courses/build.jte", model("page", page));
        }
    }

    public static void index(Context ctx) {
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
    }

    public static void show(Context ctx) {
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
    }






}
