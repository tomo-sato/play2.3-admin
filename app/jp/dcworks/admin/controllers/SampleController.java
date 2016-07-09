package jp.dcworks.admin.controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * サンプルコントローラクラス。
 * @author tomo-sato
 */
public class SampleController extends Controller {

	/**
	 * [GET] /sample/ サンプル一覧画面アクション。
	 * @return Result
	 */
	public static Result indexGet() {
		return ok(views.html.sample.index.render());
	}

	/**
	 * [GET] /sample/input サンプル登録・編集画面アクション。
	 * @return Result
	 */
	public static Result inputGet() {
		return ok(views.html.sample.input.render());
	}

	/**
	 * [POST] /sample/input サンプル登録・編集画面アクション。
	 * @return Result
	 */
	public static Result inputPost() {
		return ok(views.html.sample.input.render());
	}
}
