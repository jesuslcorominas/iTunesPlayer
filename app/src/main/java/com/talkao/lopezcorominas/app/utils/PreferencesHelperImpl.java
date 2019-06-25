package com.talkao.lopezcorominas.app.utils;

import com.talkao.lopezcorominas.model.preferences.PreferencesHelper;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.sharedpreferences.Pref;

@EBean
public class PreferencesHelperImpl implements PreferencesHelper {

    @Pref
    Preferences_ preferences;

    @Override
    public String getLastSearch() {
        return preferences.lastSearch().get();
    }

    @Override
    public void setLastSearch(String lastSearch) {
        preferences.lastSearch().put(lastSearch);
    }
}
