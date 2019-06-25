package com.talkao.lopezcorominas.app.presenter;

import com.talkao.lopezcorominas.app.view.callbackview.MainView;

/**
 * {@inheritDoc}
 * <p>
 * Presenter de la com.talkao.lopezcorominas.app.view.activity.MainActivity
 */
public interface MainPresenter extends Presenter<MainView> {

    void performSearch(String searchTerm);

}