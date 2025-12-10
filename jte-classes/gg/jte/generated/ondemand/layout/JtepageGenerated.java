package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
import org.example.hexlet.model.NamedRoutes;
import org.example.hexlet.dto.BasePage;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,20,20,20,20,20,20,20,20,20,20,21,21,21,21,21,21,21,21,21,22,22,23,23,23,24,24,24,24,24,24,24,24,24,27,27,28,28,28,28,28,28,28,28,28,29,29,34,35,35,37,37,37,40,40,42,43,43,45,45,45,48,48,50,51,51,53,53,53,56,56,58,58,58,69,69,69,3,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, BasePage page) {
		jteOutput.writeContent("\r\n\r\n<!DOCTYPE html>\r\n<html lang=\"ru\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n    <title>Образовательная платформа</title>\r\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n</head>\r\n<body>\r\n<header>\r\n    <h1>Образовательная платформа</h1>\r\n    <nav>\r\n        <a href=\"/\">Главная</a>\r\n        <a");
		var __jte_html_attribute_0 = NamedRoutes.coursesPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Курсы</a>\r\n        <a");
		var __jte_html_attribute_1 = NamedRoutes.usersPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Пользователи</a>\r\n        ");
		if (page != null && page.getCurrentUser() != null) {
			jteOutput.writeContent("\r\n            <span>Привет, ");
			jteOutput.setContext("span", null);
			jteOutput.writeUserContent(page.getCurrentUser());
			jteOutput.writeContent(" !</span>\r\n            <form");
			var __jte_html_attribute_2 = NamedRoutes.sessionsPath();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
				jteOutput.writeContent(" action=\"");
				jteOutput.setContext("form", "action");
				jteOutput.writeUserContent(__jte_html_attribute_2);
				jteOutput.setContext("form", null);
				jteOutput.writeContent("\"");
			}
			jteOutput.writeContent(" method=\"post\" style=\"display: inline;\">\r\n                <button type=\"submit\">Выйти</button>\r\n            </form>\r\n        ");
		} else {
			jteOutput.writeContent("\r\n            <a");
			var __jte_html_attribute_3 = NamedRoutes.buildSessionsPath();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
				jteOutput.writeContent(" href=\"");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(__jte_html_attribute_3);
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\"");
			}
			jteOutput.writeContent(">Войти</a>\r\n        ");
		}
		jteOutput.writeContent("\r\n    </nav>\r\n</header>\r\n\r\n<main>\r\n    ");
		jteOutput.writeContent("\r\n    ");
		if (page != null && page.getFlashSuccess() != null) {
			jteOutput.writeContent("\r\n        <div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">\r\n            ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(page.getFlashSuccess());
			jteOutput.writeContent("\r\n            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\r\n        </div>\r\n    ");
		}
		jteOutput.writeContent("\r\n\r\n    ");
		jteOutput.writeContent("\r\n    ");
		if (page != null && page.getFlashError() != null) {
			jteOutput.writeContent("\r\n        <div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">\r\n            ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(page.getFlashError());
			jteOutput.writeContent("\r\n            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\r\n        </div>\r\n    ");
		}
		jteOutput.writeContent("\r\n\r\n    ");
		jteOutput.writeContent("\r\n    ");
		if (page != null && page.getFlash() != null) {
			jteOutput.writeContent("\r\n        <div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">\r\n            ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(page.getFlash());
			jteOutput.writeContent("\r\n            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\r\n        </div>\r\n    ");
		}
		jteOutput.writeContent("\r\n\r\n    ");
		jteOutput.setContext("main", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\r\n</main>\r\n\r\n<footer>\r\n    <p>© 2025\r\n        <a href=\"https://github.com/Textile86\" target=\"_blank\">\r\n            Мой GitHub профиль\r\n        </a>\r\n    </p>\r\n</footer>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		BasePage page = (BasePage)params.getOrDefault("page", null);
		render(jteOutput, jteHtmlInterceptor, content, page);
	}
}
