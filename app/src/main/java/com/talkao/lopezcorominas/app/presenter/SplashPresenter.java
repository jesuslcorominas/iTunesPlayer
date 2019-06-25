package com.talkao.lopezcorominas.app.presenter;

import com.talkao.lopezcorominas.app.view.callbackview.SplashView;

/**
 * {@inheritDoc}
 * <p>
 * Presenter de la com.talkao.lopezcorominas.app.view.activity.SplashActivity
 */
public interface SplashPresenter extends Presenter<SplashView> {

    void performLastSearch();

}