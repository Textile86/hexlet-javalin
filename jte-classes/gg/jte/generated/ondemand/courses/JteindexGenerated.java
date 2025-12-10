package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,7,7,8,8,8,10,12,12,12,12,12,12,12,12,12,15,16,16,16,16,16,16,16,16,16,21,21,21,21,21,21,21,21,21,26,27,27,28,28,30,30,31,31,31,32,32,33,33,34,34,37,37,37,37,37,37,37,37,37,38,38,38,41,41,41,43,43,44,44,45,45,45,45,45,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <h1>");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getHeader());
				jteOutput.writeContent("</h1>\r\n\r\n    ");
				jteOutput.writeContent("\r\n    <div style=\"margin-bottom: 20px;\">\r\n        <a");
				var __jte_html_attribute_0 = NamedRoutes.buildCoursesPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">+ Добавить курс</a>\r\n    </div>\r\n\r\n    ");
				jteOutput.writeContent("\r\n    <form");
				var __jte_html_attribute_1 = NamedRoutes.coursesPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"get\">\r\n        <input\r\n                type=\"search\"\r\n                name=\"term\"\r\n                placeholder=\"Введите название или описание курса...\"");
				var __jte_html_attribute_2 = page.getTerm() != null ? page.getTerm() : "";
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_2);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("\r\n        >\r\n        <input type=\"submit\" value=\"Искать\">\r\n    </form>\r\n\r\n    ");
				jteOutput.writeContent("\r\n    ");
				if (page.getCourses().isEmpty()) {
					jteOutput.writeContent("\r\n        ");
					if (page.getTerm() == null || page.getTerm().isEmpty()) {
						jteOutput.writeContent("\r\n            <p>Пока не добавлено ни одного курса</p>\r\n        ");
					} else {
						jteOutput.writeContent("\r\n            <p>По запросу \"");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(page.getTerm());
						jteOutput.writeContent("\" ничего не найдено</p>\r\n        ");
					}
					jteOutput.writeContent("\r\n    ");
				} else {
					jteOutput.writeContent("\r\n        ");
					for (var course : page.getCourses()) {
						jteOutput.writeContent("\r\n            <div>\r\n                <h2>\r\n                    <a");
						var __jte_html_attribute_3 = NamedRoutes.coursePath(course.getId().toString());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(__jte_html_attribute_3);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">\r\n                        ");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(course.getName());
						jteOutput.writeContent("\r\n                    </a>\r\n                </h2>\r\n                <p>");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(course.getDescription());
						jteOutput.writeContent("</p>\r\n            </div>\r\n        ");
					}
					jteOutput.writeContent("\r\n    ");
				}
				jteOutput.writeContent("\r\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
