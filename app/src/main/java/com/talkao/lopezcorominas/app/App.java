package com.talkao.lopezcorominas.app;

import android.app.Application;

import com.talkao.lopezcorominas.app.di.component.DaggerDetailComponent;
import com.talkao.lopezcorominas.app.di.component.DaggerMainComponent;
import com.talkao.lopezcorominas.app.di.component.DaggerSplashComponent;
import com.talkao.lopezcorominas.app.di.component.DetailComponent;
import com.talkao.lopezcorominas.app.di.component.MainComponent;
import com.talkao.lopezcorominas.app.di.component.SplashComponent;
import com.talkao.lopezcorominas.app.di.module.PreferencesModule;
import com.talkao.lopezcorominas.data.di.module.NetModule;

/**
 * @author Jesús López Corominas
 */
public class App extends Application {

    SplashComponent splashComponent;
    MainComponent mainComponent;
    DetailComponent detailComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        String endPoint = BuildConfig.END_POINT;

        NetModule netModule = NetModule.getInstance(endPoint);
        PreferencesModule preferencesModule = new PreferencesModule(this);

        splashComponent = DaggerSplashComponent
                .builder()
                .netModule(netModule)
                .preferencesModule(preferencesModule)
                .build();
        mainComponent = DaggerMainComponent
                .builder()
                .netModule(netModule)
                .preferencesModule(preferencesModule)
                .build();
        detailComponent = DaggerDetailComponent.builder().build();
    }

    public SplashComponent getSplashComponent() {
        return splashComponent;
    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }

    public DetailComponent getDetailComponent() {
        return detailComponent;
    }
}
