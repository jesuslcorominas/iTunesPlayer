package com.talkao.lopezcorominas.app.view.activity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.util.Pair;
import android.view.View;

import com.talkao.lopezcorominas.app.App;
import com.talkao.lopezcorominas.app.R;
import com.talkao.lopezcorominas.app.event.impl.GetSongsEvent;
import com.talkao.lopezcorominas.app.presenter.MainPresenter;
import com.talkao.lopezcorominas.app.presenter.Presenter;
import com.talkao.lopezcorominas.app.view.adapter.item.SongItemView;
import com.talkao.lopezcorominas.app.view.callbackview.MainView;
import com.talkao.lopezcorominas.app.view.fragment.MainFragment;
import com.talkao.lopezcorominas.commons.model.Song;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.res.StringRes;
import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import de.psdev.licensesdialog.LicensesDialog;

/**
 * {@inheritDoc}
 */
@SuppressLint("Registered")
@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.menu_main)
public class MainActivity extends AbstractBaseAppCompatActivity<MainView> implements MainView,
        MainFragment.MainFragmentInteractionListener {

    @Inject
    MainPresenter presenter;

    @Extra
    ArrayList<Song> songs;

    @StringRes(R.string.photo_animation)
    String animationPhoto;

    @StringRes(R.string.name_animation)
    String animationName;

    @StringRes(R.string.info_animation)
    String animationInfo;

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
                .add(R.id.content_main_frameLayout_content, MainFragment.newInstance())
                .commit();
    }

    @Override
    Presenter<MainView> getPresenter() {
        return presenter;
    }

    @Override
    MainView getCallbackView() {
        return this;
    }

    @Override
    void initializeDagger() {
        ((App) getApplication()).getMainComponent().inject(this);
    }
    // endregion

    // =============================
    // region Menu
    // =============================
    @OptionsItem(R.id.item_menu_copyright)
    void showLicenses() {
        new LicensesDialog.Builder(this)
                .setNotices(R.raw.notices)
                .setIncludeOwnLicense(false)
                .setCloseText(R.string.button_accept)
                .build()
                .show();
    }
    // endregion

    // =============================
    // region CallbackView
    // =============================
    @UiThread
    @Override
    public void refreshSongs(List<Song> songs) {
        this.songs = new ArrayList<>(songs);
        postSongs();
    }


    // endregion

    // =============================
    // region MainFragment.MainFragmentInteractionListener
    // =============================
    @Override
    public void onInitFinished() {
        postSongs();
    }

    @Override
    public void onItemClick(SongItemView songItemView, int position) {
        Pair<View, String>[] pairs = new Pair[]{
                new Pair<>(songItemView.getImageViewPhoto(), animationPhoto),
                new Pair<>(songItemView.getTextViewName(), animationName),
                new Pair<>(songItemView.getTextViewInfo(), animationInfo)
        };

        navigator.detail(this, songs, position, ActivityOptions.makeSceneTransitionAnimation(this, pairs).toBundle());
    }

    @Override
    public void searchSongs(String searchTerm) {
        callPresenterPerformSearch(searchTerm);
    }

    // endregion

    // =============================
    // region Llamadas al Presenter
    // =============================
    @Background
    void callPresenterPerformSearch(String searchTerm) {
        presenter.performSearch(searchTerm);
    }

    // endregion

    // =============================
    // region Metodos privados
    // =============================
    private void postSongs() {
        EventBus.getDefault().post(new GetSongsEvent(songs));
    }

    // endregion
}