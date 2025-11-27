package gg.jte.generated.ondemand.users;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {36,36,36,36,36,36,36,36,36,36,36};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("<!DOCTYPE html>\r\n<html lang=\"ru\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n    <title>Регистрация</title>\r\n</head>\r\n<body>\r\n<form action=\"/users\" method=\"post\">\r\n    <div>\r\n        <label>\r\n            Имя\r\n            <input type=\"text\" name=\"name\" />\r\n        </label>\r\n    </div>\r\n    <div>\r\n        <label>\r\n            Email\r\n            <input type=\"email\" required name=\"email\" />\r\n        </label>\r\n    </div>\r\n    <div>\r\n        <label>\r\n            Пароль\r\n            <input type=\"password\" required name=\"password\" />\r\n        </label>\r\n    </div>\r\n    <div>\r\n        <label>\r\n            Подтверждение пароля\r\n            <input type=\"password\" required name=\"passwordConfirmation\" />\r\n        </label>\r\n    </div>\r\n    <input type=\"submit\" value=\"Зарегистрировать\" />\r\n</form>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
