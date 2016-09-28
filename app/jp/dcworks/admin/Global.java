package jp.dcworks.admin;


import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.api.mvc.EssentialFilter;
import play.filters.csrf.CSRFFilter;
import play.libs.F.Promise;
import play.mvc.Http.RequestHeader;
import play.mvc.Result;
import play.mvc.Results;

/**
 * アプリケーショングローバル設定クラス。
 * <p>起動、停止、エラー関連のイベントリスナーを実装。
 *
 * @author tomo-sato
 */
public class Global extends GlobalSettings {

	@SuppressWarnings("unchecked")
	@Override
	public <T extends EssentialFilter> Class<T>[] filters() {
		return new Class[]{CSRFFilter.class};
	}

	/**
	 * アプリケーション起動イベント。
	 * @see play.GlobalSettings#onStart(play.Application)
	 */
	@Override
	public void onStart(Application app) {
		super.onStart(app);
		Logger.info("=== play2.3-admin start ===");
	}

	/**
	 * アプリケーション停止イベント。
	 * @see play.GlobalSettings#onStop(play.Application)
	 */
	@Override
	public void onStop(Application app) {
		Logger.info("=== play2.3-admin stop ===");
		super.onStop(app);
	}

	/**
	 * 404：アクションが見つからない場合。
	 * @see play.GlobalSettings#onHandlerNotFound(play.mvc.Http.RequestHeader)
	 */
	@Override
	public Promise<Result> onHandlerNotFound(RequestHeader request) {
		Logger.warn(new StringBuffer("Request 404 Error：request=").append(request).toString());
		return Promise.<Result>pure(Results.notFound());
	}

	/**
	 * 400：リクエストエラー。
	 * @see play.GlobalSettings#onBadRequest(play.mvc.Http.RequestHeader, java.lang.String)
	 */
	@Override
	public Promise<Result> onBadRequest(RequestHeader request, String error) {
		Logger.warn(new StringBuffer("Request 400 Error：request=").append(request).append(", error=").append(error).toString());
		return Promise.<Result>pure(Results.badRequest());
	}

	/**
	 * 500：エラー共通。
	 * @see play.GlobalSettings#onError(play.mvc.Http.RequestHeader, java.lang.Throwable)
	 */
	@Override
	public Promise<Result> onError(RequestHeader request, Throwable t) {
		Logger.error(new StringBuffer("Request 500 Error：request=").append(request).toString(), t);
		return Promise.<Result>pure(Results.internalServerError());
	}
}
