package com.talkao.lopezcorominas.app.di.component;

import com.talkao.lopezcorominas.app.di.module.SplashModule;
import com.talkao.lopezcorominas.app.view.activity.SplashActivity;
import com.talkao.lopezcorominas.data.di.module.RepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * {@link dagger.Component} Dagger de la com.talkao.lopezcorominas.app.view.activity.SplashActivity
 */
@Singleton
@Component(modules = {SplashModule.class})
public interface SplashComponent {

    void inject(SplashActivity activity);
}

