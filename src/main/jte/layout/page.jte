@import gg.jte.Content
@param Content content

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Образовательная платформа</title>
    <style>
        body { font-family: Arial; margin: 0; padding: 0; }
        header { background: #2c3e50; color: white; padding: 1rem; }
        nav a { color: white; margin-right: 1rem; text-decoration: none; }
        main { padding: 2rem; }
        footer { background: #ecf0f1; padding: 1rem; text-align: center; }
    </style>
</head>
<body>
<header>
    <h1>🎓 Образовательная платформа</h1>
    <nav>
        <a href="/">Главная</a>
        <a href="/courses">Курсы</a>
    </nav>
</header>

<main>
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