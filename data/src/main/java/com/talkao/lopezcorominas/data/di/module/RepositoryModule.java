package com.talkao.lopezcorominas.data.di.module;


import com.talkao.lopezcorominas.data.datasource.ItunesDatasource;
import com.talkao.lopezcorominas.data.datasource.PreferencesDatasource;
import com.talkao.lopezcorominas.data.repository.impl.ItunesRepositoryImpl;
import com.talkao.lopezcorominas.data.repository.impl.PreferencesRepositoryImpl;
import com.talkao.lopezcorominas.model.repository.ItunesRepository;
import com.talkao.lopezcorominas.model.repository.PreferencesRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
@Module(includes = {DatasourceModule.class})
public class RepositoryModule {

    @Provides
    PreferencesRepository providePreferencesRepository(PreferencesDatasource preferencesDatasource) {
        return new PreferencesRepositoryImpl(preferencesDatasource);
    }

    @Provides
    ItunesRepository provideItunesRepository(ItunesDatasource itunesDatasource) {
        return new ItunesRepositoryImpl(itunesDatasource);
    }

}
