@import org.example.hexlet.dto.courses.CoursePage
@import org.example.hexlet.model.NamedRoutes
@param CoursePage page

@template.layout.page(
content = @`
    <h1>${page.getCourse().getName()}</h1>
    <p><strong>Описание:</strong> ${page.getCourse().getDescription()}</p>
    <a href="${NamedRoutes.coursesPath()}">← Назад к списку курсов</a>
`
)