package com.talkao.lopezcorominas.app.view.fragment;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.talkao.lopezcorominas.app.R;
import com.talkao.lopezcorominas.app.event.impl.GetSongDetailEvent;
import com.talkao.lopezcorominas.commons.model.Song;
import com.talkao.lopezcorominas.commons.utils.TextUtils;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;

/**
 * {@inheritDoc}
 */
@EFragment(R.layout.fragment_detail)
public class DetailFragment extends AbstractBaseFragment implements MediaPlayer.OnPreparedListener {

    private DetailFragmentInteractionListener listener;

    @ViewById(R.id.fragment_detail_imageView_photo)
    ImageView imageViewPhoto;

    @ViewById(R.id.fragment_detail_textView_name)
    TextView textViewName;

    @ViewById(R.id.fragment_detail_textView_info)
    TextView textViewInfo;

    @ViewById(R.id.fragment_detail_linearLayout_buttons)
    LinearLayout linearLayoutButtons;

    @ViewById(R.id.fragment_detail_imageButton_playPause)
    ImageButton imageButtonPlayPause;

    @ViewById(R.id.fragment_detail_progressBar)
    ProgressBar progressBar;

    private MediaPlayer mediaPlayer;

    private boolean isPlaying;

    // =============================
    // region View
    // =============================

    // endregion

    // =============================
    // region NewInstance
    // =============================    
    public static DetailFragment newInstance() {
        return DetailFragment_.builder().build();
    }

    // endregion

    // =============================
    // region Fragment
    // =============================
    @Override
    public void onPause() {
        super.onPause();

        if (isPlaying) {
            pause();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if (mediaPlayer != null) {
            play();
        }
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);

        try {
            listener = (DetailFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new RuntimeException("Debes implementar " + DetailFragmentInteractionListener.class.getName());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        listener = null;
    }

    // endregion

    // =============================
    // region AbstractBaseFragment
    // =============================

    @Override
    void init() {
        if (listener != null) {
            listener.onInitFinished();
        }
    }

    // endregion

    // =============================
    // region Events
    // =============================
    @SuppressWarnings("unused")
    @Subscribe
    public void onGetSongDetailEvent(GetSongDetailEvent event) {
        Song song = event.getSong();

        Picasso.with(getActivity()).
                load(song.getThumbnail()).
                placeholder(R.drawable.ic_no_image).
                error(R.drawable.ic_no_image).
                into(imageViewPhoto);

        textViewName.setText(song.getTrackName());

        String info = song.getArtistName();
        if (!TextUtils.isEmpty(song.getCollectionName())) {
            info = info + " (" + song.getCollectionName() + ")";
        }

        textViewInfo.setText(info);

        changeControlsVisibiliyt(true);

        if (mediaPlayer != null) {
            mediaPlayer.release();
        }

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(this);
        try {
            mediaPlayer.setDataSource(song.getUrl());
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            if (listener != null) {
                listener.onError();

                mediaPlayer = null;

                imageButtonPlayPause.setImageResource(R.drawable.ic_play);
                changeControlsVisibiliyt(false);
            }
        }
    }

    // endregion

    // =============================
    // region Interaction
    // =============================
    public interface DetailFragmentInteractionListener {
        void onInitFinished();

        void onError();

        void onChangeSong(int nextPosition);
    }

    @Click({R.id.fragment_detail_imageButton_prev, R.id.fragment_detail_imageButton_next})
    void prev(View view) {
        if (listener != null) {
            listener.onChangeSong(view.getId() == R.id.fragment_detail_imageButton_next ? 1 : -1);
        }
    }

    @Click(R.id.fragment_detail_imageButton_playPause)
    void playPause() {
        if (isPlaying) {
            pause();
        } else {
            if (mediaPlayer == null) {
                if (listener != null) {
                    listener.onChangeSong(0);
                }
            }
            play();
        }
    }

    // endregion

    // =============================
    // region Events
    // =============================

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        play();

        changeControlsVisibiliyt(false);
    }

    // endregion

    // =============================
    // region Metodos privados
    // =============================

    private void pause() {
        mediaPlayer.pause();
        isPlaying = false;
        imageButtonPlayPause.setImageResource(R.drawable.ic_play);
    }

    private void play() {
        mediaPlayer.start();
        isPlaying = true;
        imageButtonPlayPause.setImageResource(R.drawable.ic_pause);
    }

    private void changeControlsVisibiliyt(boolean loading) {
        if (loading) {
            linearLayoutButtons.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        } else {
            linearLayoutButtons.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }
    }

    // endregion    
}