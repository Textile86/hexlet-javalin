package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,27,27,27,27,38,38,38,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content) {
		jteOutput.writeContent("\r\n<!DOCTYPE html>\r\n<html lang=\"ru\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n    <title>Образовательная платформа</title>\r\n    <style>\r\n        body { font-family: Arial; margin: 0; padding: 0; }\r\n        header { background: #2c3e50; color: white; padding: 1rem; }\r\n        nav a { color: white; margin-right: 1rem; text-decoration: none; }\r\n        main { padding: 2rem; }\r\n        footer { background: #ecf0f1; padding: 1rem; text-align: center; }\r\n    </style>\r\n</head>\r\n<body>\r\n<header>\r\n    <h1>🎓 Образовательная платформа</h1>\r\n    <nav>\r\n        <a href=\"/\">Главная</a>\r\n        <a href=\"/courses\">Курсы</a>\r\n    </nav>\r\n</header>\r\n\r\n<main>\r\n    ");
		jteOutput.setContext("main", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\r\n</main>\r\n\r\n<footer>\r\n    <p>© 2025\r\n        <a href=\"https://github.com/Textile86\" target=\"_blank\">\r\n            Мой GitHub профиль\r\n        </a>\r\n    </p>\r\n</footer>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		render(jteOutput, jteHtmlInterceptor, content);
	}
}
