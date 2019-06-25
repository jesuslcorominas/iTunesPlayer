package com.talkao.lopezcorominas.app.di.component;

import com.talkao.lopezcorominas.app.di.module.MainModule;
import com.talkao.lopezcorominas.app.view.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * {@link dagger.Component} Dagger de la com.talkao.lopezcorominas.app.view.activity.MainActivity
 */
@Singleton
@Component(modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity activity);
}

