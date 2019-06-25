package com.talkao.lopezcorominas.app.di.module;

import com.talkao.lopezcorominas.app.presenter.SplashPresenter;
import com.talkao.lopezcorominas.app.presenter.impl.SplashPresenterImpl;
import com.talkao.lopezcorominas.data.di.module.RepositoryModule;
import com.talkao.lopezcorominas.model.module.UseCaseModule;
import com.talkao.lopezcorominas.model.usecase.LastSearchUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * {@link dagger.Module} Dagger de la com.talkao.lopezcorominas.app.view.activity.SplashActivity
 */
@Module(includes = {UseCaseModule.class, PreferencesModule.class, RepositoryModule.class})
public class SplashModule {

    @Provides
    SplashPresenter provideSplashPresenter(LastSearchUseCase lastSearchUseCase) {
        return new SplashPresenterImpl(lastSearchUseCase);
    }
}