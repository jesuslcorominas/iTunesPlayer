package com.talkao.lopezcorominas.app.presenter.impl;

import com.talkao.lopezcorominas.app.presenter.MainPresenter;
import com.talkao.lopezcorominas.app.view.callbackview.MainView;
import com.talkao.lopezcorominas.commons.Error;
import com.talkao.lopezcorominas.commons.GetCallback;
import com.talkao.lopezcorominas.commons.model.Song;
import com.talkao.lopezcorominas.model.usecase.SearchUseCase;

import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 * <p>
 * Implementacion del {@link com.talkao.lopezcorominas.app.presenter.Presenter} de la com.talkao.lopezcorominas.app.view.activity.MainActivity
 */
public class MainPresenterImpl extends AbstractPresenter<MainView> implements MainPresenter {

    private final SearchUseCase searchUseCase;

    public MainPresenterImpl(SearchUseCase searchUseCase) {
        this.searchUseCase = searchUseCase;
    }

    @Override
    public void performSearch(String searchTerm) {
        callbackView.showProgress();

        searchUseCase.execute(searchTerm, new GetCallback<List<Song>>() {
            @Override
            public void onSuccess(List<Song> result) {
                if (resumed) {
                    callbackView.hideProgress();

                    callbackView.refreshSongs(result == null || result.isEmpty() ? new ArrayList<Song>() : result);
                }
            }

            @Override
            public void onError(Error error) {
                if (resumed) {
                    callbackView.hideProgress();
                    callbackView.showUndefinedError();
                }
            }
        });

    }
}