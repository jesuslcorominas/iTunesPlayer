package com.talkao.lopezcorominas.model.module;

import com.talkao.lopezcorominas.model.repository.ItunesRepository;
import com.talkao.lopezcorominas.model.repository.PreferencesRepository;
import com.talkao.lopezcorominas.model.usecase.LastSearchUseCase;
import com.talkao.lopezcorominas.model.usecase.SearchUseCase;
import com.talkao.lopezcorominas.model.usecase.impl.LastSearchUseCaseImpl;
import com.talkao.lopezcorominas.model.usecase.impl.SearchUseCaseImpl;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module
public class UseCaseModule {

    @Provides
    public LastSearchUseCase provideLastSearchUseCase(PreferencesRepository preferencesRepository, ItunesRepository itunesRepository) {
        return new LastSearchUseCaseImpl(preferencesRepository, itunesRepository);
    }

    @Provides
    public SearchUseCase provideSearchUseCase(PreferencesRepository preferencesRepository, ItunesRepository itunesRepository) {
        return new SearchUseCaseImpl(preferencesRepository, itunesRepository);
    }
}
