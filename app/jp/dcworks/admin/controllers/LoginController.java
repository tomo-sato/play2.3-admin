package jp.dcworks.admin.controllers;

import play.data.Form;
import play.data.validation.Constraints.Required;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * ログインコントローラクラス。
 * @author tomo-sato
 */
public class LoginController extends Controller {

	/**
	 * ログインフォームクラス。
	 * @author tomo-sato
	 */
	public static class LoginForm {
		/** メールアドレス */
		@Required
		public String email;

		/** パスワード */
		@Required
		public String password;
	}

	/**
	 * ログイン画面アクション。
	 * <p>[GET] /
	 * @return Result
	 */
	public static Result indexGet() {
		return ok(views.html.login.index.render(Form.form(LoginForm.class)));
	}

	/**
	 * ログイン画面アクション。
	 * <p>[POST] /login
	 * @return Result
	 */
	public static Result login() {
		Form<LoginForm> requestParams = Form.form(LoginForm.class).bindFromRequest();

		// バリデーションチェック結果
		if (requestParams.hasErrors()) {
			return badRequest(views.html.login.index.render(requestParams));
		}

		return SampleController.indexGet();
	}
}
