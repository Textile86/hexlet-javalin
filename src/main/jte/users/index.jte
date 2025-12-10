@import org.example.hexlet.dto.users.UsersPage
@import org.example.hexlet.model.NamedRoutes
@param UsersPage page

@template.layout.page(
content = @`
    <div class="container mt-4">
        <h1>Список пользователей</h1>
        <a href="${NamedRoutes.buildUsersPath()}" class="btn btn-primary mb-3">Добавить пользователя</a>

        @if(page.getUsers().isEmpty())
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
                @for(var user : page.getUsers())
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
`,
page = page
)