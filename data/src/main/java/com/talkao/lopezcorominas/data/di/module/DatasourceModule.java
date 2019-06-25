package com.talkao.lopezcorominas.data.di.module;

import com.talkao.lopezcorominas.data.datasource.ItunesDatasource;
import com.talkao.lopezcorominas.data.datasource.PreferencesDatasource;
import com.talkao.lopezcorominas.data.datasource.impl.ItunesDatasourceImpl;
import com.talkao.lopezcorominas.data.datasource.impl.PreferencesDatasourceImpl;
import com.talkao.lopezcorominas.data.net.restclient.ItunesRestClient;
import com.talkao.lopezcorominas.model.preferences.PreferencesHelper;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
@Module(includes = {NetModule.class})
public class DatasourceModule {

    @Provides
    PreferencesDatasource providePreferencesDatasource(PreferencesHelper preferencesHelper) {
        return new PreferencesDatasourceImpl(preferencesHelper);
    }

    @Provides
    ItunesDatasource provideItunesDatasource(ItunesRestClient itunesRestClient) {
        return new ItunesDatasourceImpl(itunesRestClient);
    }

}
