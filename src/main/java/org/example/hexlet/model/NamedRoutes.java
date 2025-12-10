package org.example.hexlet.model;

public class NamedRoutes {
    public static String usersPath() {
        return "/us";
    }

    public static String buildUsersPath() {
        return "/us/build";
    }

    public static String coursesPath() {
        return "/co";
    }

    public static String buildCoursesPath() {
        return "/co/build";
    }

    public static String coursePath(Long id) {
        return coursePath(String.valueOf(id));
    }

    public static String coursePath(String id) {
        return "/co/" + id;
    }

    public static String userPath(Long id) {
        return userPath(String.valueOf(id));
    }

    public static String userPath(String id) {
        return "/us/" + id;
    }

    public static String sessionsPath() {
        return "/sessions";
    }

    public static String buildSessionsPath() {
        return "/sessions/build";
    }

}
