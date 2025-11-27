package gg.jte.generated.ondemand.courses;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "courses/build.jte";
	public static final int[] JTE_LINE_INFO = {24,24,24,24,24,24,24,24,24,24,24};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("<!DOCTYPE html>\r\n<html lang=\"ru\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n    <title>Добавление курса</title>\r\n</head>\r\n<body>\r\n<form action=\"/courses\" method=\"post\">\r\n    <div>\r\n        <label>\r\n            Название курса\r\n            <input type=\"text\" name=\"name\" />\r\n        </label>\r\n    </div>\r\n    <div>\r\n        <label>\r\n            Описание курса\r\n            <input type=\"text\" required name=\"description\" />\r\n        </label>\r\n    </div>\r\n    <input type=\"submit\" value=\"Добавить курс\" />\r\n</form>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
