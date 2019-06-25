package com.talkao.lopezcorominas.app.di.module;

import android.content.Context;

import com.talkao.lopezcorominas.app.utils.PreferencesHelperImpl_;
import com.talkao.lopezcorominas.model.preferences.PreferencesHelper;

import dagger.Module;
import dagger.Provides;

@Module
public class PreferencesModule {

    private Context context;

    public PreferencesModule(Context context) {
        this.context = context;
    }

    @Provides
    PreferencesHelper providePreferencesHelper() {
        return PreferencesHelperImpl_.getInstance_(context);
    }
}
