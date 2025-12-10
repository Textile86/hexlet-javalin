@import org.example.hexlet.dto.courses.CoursesPage
@import org.example.hexlet.model.NamedRoutes
@param CoursesPage page

@template.layout.page(
content = @`
    <h1>${page.getHeader()}</h1>

    <!-- КНОПКА ДОБАВЛЕНИЯ КУРСА -->
    <div style="margin-bottom: 20px;">
        <a href="${NamedRoutes.buildCoursesPath()}">+ Добавить курс</a>
    </div>

    <!-- ПОИСКОВАЯ ФОРМА -->
    <form action="${NamedRoutes.coursesPath()}" method="get">
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
                    <a href="${NamedRoutes.coursePath(course.getId().toString())}">
                        ${course.getName()}
                    </a>
                </h2>
                <p>${course.getDescription()}</p>
            </div>
        @endfor
    @endif
`,
page = page
)