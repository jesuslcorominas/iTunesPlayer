package com.talkao.lopezcorominas.app.view.activity;

import android.annotation.SuppressLint;

import com.talkao.lopezcorominas.app.App;
import com.talkao.lopezcorominas.app.R;
import com.talkao.lopezcorominas.app.presenter.Presenter;
import com.talkao.lopezcorominas.app.presenter.SplashPresenter;
import com.talkao.lopezcorominas.app.view.callbackview.SplashView;
import com.talkao.lopezcorominas.app.view.fragment.SplashFragment;
import com.talkao.lopezcorominas.commons.model.Song;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;

import java.util.List;

import javax.inject.Inject;

/**
 * {@inheritDoc}
 */
@SuppressLint("Registered")
@EActivity(R.layout.activity_splash)
public class SplashActivity extends AbstractBaseActivity<SplashView> implements SplashView,
        SplashFragment.SplashFragmentInteractionListener {

    @Inject
    SplashPresenter presenter;

    // =============================
    // region Activity
    // =============================

    @Override
    protected void onResume() {
        super.onResume();

        callPresenterPerformLastSearch();
    }

    // endregion

    // =============================
    // region AbstractBaseAppCompatActivity
    // =============================
    @Override
    void init() {
        getFragmentManager().beginTransaction()
                .add(R.id.content_splash_frameLayout_content, SplashFragment.newInstance())
                .commit();
    }

    @Override
    Presenter<SplashView> getPresenter() {
        return presenter;
    }

    @Override
    SplashView getCallbackView() {
        return this;
    }

    @Override
    void initializeDagger() {
        ((App) getApplication()).getSplashComponent().inject(this);
    }
    // endregion

    // =============================
    // region CallbackView
    // =============================
    @UiThread
    @Override
    public void continueToMain(List<Song> result) {
        navigator.main(this, result);
    }

    // endregion

    // =============================
    // region SplashFragment.SplashFragmentInteractionListener
    // =============================

    // endregion    

    // =============================
    // region Llamadas al Presenter
    // =============================
    @Background
    void callPresenterPerformLastSearch() {
        presenter.performLastSearch();
    }


    // endregion

    // =============================
    // region Metodos privados
    // =============================

    // endregion
}