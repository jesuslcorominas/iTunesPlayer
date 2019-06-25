package com.talkao.lopezcorominas.app.di.component;

import com.talkao.lopezcorominas.app.di.module.DetailModule;
import com.talkao.lopezcorominas.app.view.activity.DetailActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * {@link dagger.Component} Dagger de la com.talkao.lopezcorominas.app.view.activity.DetailActivity
 */
@Singleton
@Component(modules = {DetailModule.class})
public interface DetailComponent {

    void inject(DetailActivity activity);
}

