package com.talkao.lopezcorominas.data.datasource.impl;


import com.talkao.lopezcorominas.commons.Error;
import com.talkao.lopezcorominas.commons.GetStringCallback;
import com.talkao.lopezcorominas.commons.VoidCallback;
import com.talkao.lopezcorominas.commons.utils.ErrorKeys;
import com.talkao.lopezcorominas.data.datasource.PreferencesDatasource;
import com.talkao.lopezcorominas.model.preferences.PreferencesHelper;

/**
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
public class PreferencesDatasourceImpl implements PreferencesDatasource {

    private final PreferencesHelper preferencesHelper;

    public PreferencesDatasourceImpl(PreferencesHelper preferencesHelper) {
        this.preferencesHelper = preferencesHelper;
    }

    @Override
    public void setLastSearch(String lastSearch, VoidCallback callback) {
        try {
            preferencesHelper.setLastSearch(lastSearch);

            callback.onSuccess();
        } catch (Exception e) {
            callback.onError(new Error(ErrorKeys.PREFERENCES_ERROR, "Error al guardar el termino de busqueda en preferencias: " + e.getMessage()));
        }
    }

    @Override
    public void getLastSearch(GetStringCallback callback) {
        try {
            callback.onSuccess(preferencesHelper.getLastSearch());
        } catch (Exception e) {
            callback.onError(new Error(ErrorKeys.PREFERENCES_ERROR, "Error al obtener el termino de busqueda de preferencias: " + e.getMessage()));
        }
    }
}
