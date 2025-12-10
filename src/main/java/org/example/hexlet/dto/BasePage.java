    package org.example.hexlet.dto;

    import lombok.Getter;
    import lombok.Setter;

    @Getter
    @Setter
    public class BasePage {
        private String flash;
        private String flashSuccess;
        private String flashError;
        private String currentUser;
    }