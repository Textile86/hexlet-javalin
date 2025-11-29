@import org.example.hexlet.model.NamedRoutes
@template.layout.page(
content = @`
    <h1>Добро пожаловать на образовательную платформу!</h1>
    <p>Изучайте программирование с нашими курсами</p>
    <a href="${NamedRoutes.coursesPath()}">Перейти к курсам →</a>
`
)