package com.talkao.lopezcorominas.data.repository.impl;

import com.talkao.lopezcorominas.commons.GetStringCallback;
import com.talkao.lopezcorominas.commons.VoidCallback;
import com.talkao.lopezcorominas.data.datasource.PreferencesDatasource;
import com.talkao.lopezcorominas.model.repository.PreferencesRepository;

/**
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
public class PreferencesRepositoryImpl implements PreferencesRepository {

    private final PreferencesDatasource preferencesDatasource;

    public PreferencesRepositoryImpl(PreferencesDatasource preferencesDatasource) {
        this.preferencesDatasource = preferencesDatasource;
    }

    @Override
    public void setLastSearch(String lastSearch, VoidCallback callback) {
        preferencesDatasource.setLastSearch(lastSearch, callback);
    }

    @Override
    public void getLastSearch(GetStringCallback callback) {
        preferencesDatasource.getLastSearch(callback);
    }
}
