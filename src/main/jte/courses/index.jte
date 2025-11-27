@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Курсы по программированию</title>
</head>
<body>
<h1>${page.getHeader()}</h1>

<!-- КНОПКА ДОБАВЛЕНИЯ КУРСА -->
<div style="margin-bottom: 20px;">
    <a href="/courses/build">+ Добавить курс</a>
</div>

<!-- ПОИСКОВАЯ ФОРМА -->
<form action="/courses" method="get">
    <input
            type="search"
            name="term"
            placeholder="Введите название или описание курса..."
            value="${page.getTerm() != null ? page.getTerm() : ""}"
    >
    <input type="submit" value="Искать">
</form>

<!-- СПИСОК КУРСОВ -->
@if(page.getCourses().isEmpty())
    @if(page.getTerm() == null || page.getTerm().isEmpty())
        <p>Пока не добавлено ни одного курса</p>
    @else
        <p>По запросу "${page.getTerm()}" ничего не найдено</p>
    @endif
@else
    @for(var course : page.getCourses())
        <div>
            <h2>
                <a href="/courses/${course.getId()}">
                    ${course.getName()}
                </a>
            </h2>
            <p>${course.getDescription()}</p>
        </div>
    @endfor
@endif
</body>
</html>