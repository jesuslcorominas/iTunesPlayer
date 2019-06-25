package com.talkao.lopezcorominas.data.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
@Module
public class GsonModule {

    @Singleton
    @Provides
    Gson provideGson() {
        return new GsonBuilder().
                setPrettyPrinting().
                create();
    }
}
