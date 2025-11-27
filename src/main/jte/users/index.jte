@import org.example.hexlet.model.User
@import java.util.List
@param List<User> users

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Список пользователей</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Список пользователей</h1>
    <a href="/users/build" class="btn btn-primary mb-3">Добавить пользователя</a>

    @if(users.isEmpty())
        <p>Пользователей пока нет</p>
    @else
        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Имя</th>
                <th>Email</th>
            </tr>
            </thead>
            <tbody>
            @for(var user : users)
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getName()}</td>
                    <td>${user.getEmail()}</td>
                </tr>
            @endfor
            </tbody>
        </table>
    @endif

    <a href="/" class="btn btn-secondary">На главную</a>
</div>
</body>
</html>