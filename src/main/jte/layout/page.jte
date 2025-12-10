@import gg.jte.Content
@import org.example.hexlet.model.NamedRoutes
@import org.example.hexlet.dto.BasePage
@param Content content
@param BasePage page = null


<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Образовательная платформа</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<header>
    <h1>Образовательная платформа</h1>
    <nav>
        <a href="/">Главная</a>
        <a href="${NamedRoutes.coursesPath()}">Курсы</a>
        <a href="${NamedRoutes.usersPath()}">Пользователи</a>
        @if(page != null && page.getCurrentUser() != null)
            <span>Привет, ${page.getCurrentUser()} !</span>
            <form action="${NamedRoutes.sessionsPath()}" method="post" style="display: inline;">
                <button type="submit">Выйти</button>
            </form>
        @else
            <a href="${NamedRoutes.buildSessionsPath()}">Войти</a>
        @endif
    </nav>
</header>

<main>
    <!-- Вывод флеш-сообщений об успехе -->
    @if(page != null && page.getFlashSuccess() != null)
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            ${page.getFlashSuccess()}
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    @endif

    <!-- Вывод флеш-сообщений об ошибке -->
    @if(page != null && page.getFlashError() != null)
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            ${page.getFlashError()}
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    @endif

    <!-- Вывод старых флеш-сообщений (для обратной совместимости) -->
    @if(page != null && page.getFlash() != null)
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            ${page.getFlash()}
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    @endif

    ${content}
</main>

<footer>
    <p>© 2025
        <a href="https://github.com/Textile86" target="_blank">
            Мой GitHub профиль
        </a>
    </p>
</footer>
</body>
</html>