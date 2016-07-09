package jp.dcworks.admin.controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * ログインコントローラクラス。
 * @author tomo-sato
 */
public class LoginController extends Controller {

	/**
	 * ログイン画面アクション。
	 * <p>[GET] /
	 * @return Result
	 */
	public static Result indexGet() {
		return ok(views.html.login.index.render());
	}
}
