package com.talkao.lopezcorominas.app.di.module;

import dagger.Module;
import dagger.Provides;

import com.talkao.lopezcorominas.app.presenter.DetailPresenter;
import com.talkao.lopezcorominas.app.presenter.impl.DetailPresenterImpl;

/**
 * {@link dagger.Module} Dagger de la com.talkao.lopezcorominas.app.view.activity.DetailActivity
 */
@Module
public class DetailModule {

    @Provides
    DetailPresenter provideDetailPresenter() {
        return new DetailPresenterImpl();
    }
}