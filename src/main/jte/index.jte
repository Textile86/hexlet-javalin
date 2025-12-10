@import org.example.hexlet.model.NamedRoutes
@import org.example.hexlet.dto.MainPage
@param MainPage page

@template.layout.page(
content = @`
    @if(!page.isVisited())
        <div>
            Это сообщение показывается только один раз.
            Если вы хотите увидеть его снова, сотрите куки
        </div>
    @endif

    <h1>Добро пожаловать на образовательную платформу!</h1>
    <p>Изучайте программирование с нашими курсами</p>
    <a href="${NamedRoutes.coursesPath()}">Перейти к курсам →</a>
`,
page = page
)