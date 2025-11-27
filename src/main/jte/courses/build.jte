<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Добавление курса</title>
</head>
<body>
<form action="/courses" method="post">
    <div>
        <label>
            Название курса
            <input type="text" name="name" />
        </label>
    </div>
    <div>
        <label>
            Описание курса
            <input type="text" required name="description" />
        </label>
    </div>
    <input type="submit" value="Добавить курс" />
</form>
</body>
</html>