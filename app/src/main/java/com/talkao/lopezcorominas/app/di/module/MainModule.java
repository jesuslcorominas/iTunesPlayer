package com.talkao.lopezcorominas.app.di.module;

import dagger.Module;
import dagger.Provides;

import com.talkao.lopezcorominas.app.presenter.MainPresenter;
import com.talkao.lopezcorominas.app.presenter.impl.MainPresenterImpl;
import com.talkao.lopezcorominas.data.di.module.RepositoryModule;
import com.talkao.lopezcorominas.model.module.UseCaseModule;
import com.talkao.lopezcorominas.model.usecase.SearchUseCase;

/**
 * {@link dagger.Module} Dagger de la com.talkao.lopezcorominas.app.view.activity.MainActivity
 */
@Module(includes = {UseCaseModule.class, PreferencesModule.class, RepositoryModule.class})
public class MainModule {

    @Provides
    MainPresenter provideMainPresenter(SearchUseCase searchUseCase) {
        return new MainPresenterImpl(searchUseCase);
    }
}