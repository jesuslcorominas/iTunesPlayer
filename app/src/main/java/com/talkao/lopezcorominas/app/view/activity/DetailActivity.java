package com.talkao.lopezcorominas.app.view.activity;

import android.annotation.SuppressLint;

import com.talkao.lopezcorominas.app.App;
import com.talkao.lopezcorominas.app.R;
import com.talkao.lopezcorominas.app.event.impl.GetSongDetailEvent;
import com.talkao.lopezcorominas.app.presenter.DetailPresenter;
import com.talkao.lopezcorominas.app.presenter.Presenter;
import com.talkao.lopezcorominas.app.view.callbackview.DetailView;
import com.talkao.lopezcorominas.app.view.fragment.DetailFragment;
import com.talkao.lopezcorominas.commons.model.Song;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * {@inheritDoc}
 */
@SuppressLint("Registered")
@EActivity(R.layout.activity_detail)
public class DetailActivity extends AbstractBaseAppCompatActivity<DetailView> implements DetailView,
        DetailFragment.DetailFragmentInteractionListener {

    @Inject
    DetailPresenter presenter;

    @Extra
    ArrayList<Song> songs;

    @Extra
    int position;

    // =============================
    // region Activity
    // =============================

    // endregion

    // =============================
    // region AbstractBaseAppCompatActivity
    // =============================
    @Override
    void init() {
        getFragmentManager().beginTransaction()
                .add(R.id.content_detail_frameLayout_content, DetailFragment.newInstance())
                .commit();
    }

    @Override
    Presenter<DetailView> getPresenter() {
        return presenter;
    }

    @Override
    DetailView getCallbackView() {
        return this;
    }

    @Override
    void initializeDagger() {
        ((App) getApplication()).getDetailComponent().inject(this);
    }
    // endregion

    // =============================
    // region CallbackView
    // =============================
    @Override
    public void onInitFinished() {
        postSong();
    }

    @Override
    public void onError() {
        showUndefinedError();

        finish();
    }

    @Override
    public void onChangeSong(int nextPosition) {
        int newPosition = position + nextPosition;
        if (newPosition >= songs.size() || newPosition < 0) {
            return;
        }


        position = newPosition;

        postSong();
    }

    // endregion

    // =============================
    // region DetailFragment.DetailFragmentInteractionListener
    // =============================

    // endregion    

    // =============================
    // region Llamadas al Presenter
    // =============================

    // endregion

    // =============================
    // region Metodos privados
    // =============================
    private void postSong() {
        EventBus.getDefault().post(new GetSongDetailEvent(songs.get(position)));
    }

    // endregion
}