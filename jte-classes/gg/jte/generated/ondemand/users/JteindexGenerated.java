package gg.jte.generated.ondemand.users;
import org.example.hexlet.model.NamedRoutes;
import org.example.hexlet.model.User;
import java.util.List;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,16,16,16,16,16,16,16,16,16,16,18,18,20,20,30,30,32,32,32,33,33,33,34,34,34,36,36,39,39,44,44,44,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<User> users) {
		jteOutput.writeContent("\r\n<!DOCTYPE html>\r\n<html lang=\"ru\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n    <title>Список пользователей</title>\r\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n</head>\r\n<body>\r\n<div class=\"container mt-4\">\r\n    <h1>Список пользователей</h1>\r\n    <a");
		var __jte_html_attribute_0 = NamedRoutes.buildUsersPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" class=\"btn btn-primary mb-3\">Добавить пользователя</a>\r\n\r\n    ");
		if (users.isEmpty()) {
			jteOutput.writeContent("\r\n        <p>Пользователей пока нет</p>\r\n    ");
		} else {
			jteOutput.writeContent("\r\n        <table class=\"table table-striped\">\r\n            <thead>\r\n            <tr>\r\n                <th>ID</th>\r\n                <th>Имя</th>\r\n                <th>Email</th>\r\n            </tr>\r\n            </thead>\r\n            <tbody>\r\n            ");
			for (var user : users) {
				jteOutput.writeContent("\r\n                <tr>\r\n                    <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(user.getId());
				jteOutput.writeContent("</td>\r\n                    <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(user.getName());
				jteOutput.writeContent("</td>\r\n                    <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(user.getEmail());
				jteOutput.writeContent("</td>\r\n                </tr>\r\n            ");
			}
			jteOutput.writeContent("\r\n            </tbody>\r\n        </table>\r\n    ");
		}
		jteOutput.writeContent("\r\n\r\n    <a href=\"/\" class=\"btn btn-secondary\">На главную</a>\r\n</div>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<User> users = (List<User>)params.get("users");
		render(jteOutput, jteHtmlInterceptor, users);
	}
}
