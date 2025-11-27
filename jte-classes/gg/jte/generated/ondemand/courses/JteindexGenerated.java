package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursesPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,11,11,11,11,13,18,24,24,24,24,24,24,24,24,24,29,30,30,31,31,33,33,34,34,34,35,35,36,36,37,37,40,40,40,40,41,41,41,44,44,44,46,46,47,47,49,49,49,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\r\n<!DOCTYPE html>\r\n<html lang=\"ru\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n    <title>Курсы по программированию</title>\r\n</head>\r\n<body>\r\n<h1>");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(page.getHeader());
		jteOutput.writeContent("</h1>\r\n\r\n");
		jteOutput.writeContent("\r\n<div style=\"margin-bottom: 20px;\">\r\n    <a href=\"/courses/build\">+ Добавить курс</a>\r\n</div>\r\n\r\n");
		jteOutput.writeContent("\r\n<form action=\"/courses\" method=\"get\">\r\n    <input\r\n            type=\"search\"\r\n            name=\"term\"\r\n            placeholder=\"Введите название или описание курса...\"");
		var __jte_html_attribute_0 = page.getTerm() != null ? page.getTerm() : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent("\r\n    >\r\n    <input type=\"submit\" value=\"Искать\">\r\n</form>\r\n\r\n");
		jteOutput.writeContent("\r\n");
		if (page.getCourses().isEmpty()) {
			jteOutput.writeContent("\r\n    ");
			if (page.getTerm() == null || page.getTerm().isEmpty()) {
				jteOutput.writeContent("\r\n        <p>Пока не добавлено ни одного курса</p>\r\n    ");
			} else {
				jteOutput.writeContent("\r\n        <p>По запросу \"");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(page.getTerm());
				jteOutput.writeContent("\" ничего не найдено</p>\r\n    ");
			}
			jteOutput.writeContent("\r\n");
		} else {
			jteOutput.writeContent("\r\n    ");
			for (var course : page.getCourses()) {
				jteOutput.writeContent("\r\n        <div>\r\n            <h2>\r\n                <a href=\"/courses/");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(course.getId());
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\">\r\n                    ");
				jteOutput.setContext("a", null);
				jteOutput.writeUserContent(course.getName());
				jteOutput.writeContent("\r\n                </a>\r\n            </h2>\r\n            <p>");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(course.getDescription());
				jteOutput.writeContent("</p>\r\n        </div>\r\n    ");
			}
			jteOutput.writeContent("\r\n");
		}
		jteOutput.writeContent("\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
