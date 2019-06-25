package com.talkao.lopezcorominas.app.presenter.impl;

import com.talkao.lopezcorominas.app.presenter.SplashPresenter;
import com.talkao.lopezcorominas.app.view.callbackview.SplashView;
import com.talkao.lopezcorominas.commons.Error;
import com.talkao.lopezcorominas.commons.GetCallback;
import com.talkao.lopezcorominas.commons.model.Song;
import com.talkao.lopezcorominas.model.usecase.LastSearchUseCase;

import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 * <p>
 * Implementacion del {@link com.talkao.lopezcorominas.app.presenter.Presenter} de la com.talkao.lopezcorominas.app.view.activity.SplashActivity
 */
public class SplashPresenterImpl extends AbstractPresenter<SplashView> implements SplashPresenter {

    private final LastSearchUseCase lastSearchUseCase;

    public SplashPresenterImpl(LastSearchUseCase lastSearchUseCase) {
        this.lastSearchUseCase = lastSearchUseCase;
    }

    @Override
    public void performLastSearch() {

        lastSearchUseCase.execute(null, new GetCallback<List<Song>>() {
            @Override
            public void onSuccess(List<Song> result) {
                if (resumed) {
                    callbackView.continueToMain(result);
                }
            }

            @Override
            public void onError(Error error) {
                callbackView.continueToMain(new ArrayList<Song>());
            }
        });
    }
}