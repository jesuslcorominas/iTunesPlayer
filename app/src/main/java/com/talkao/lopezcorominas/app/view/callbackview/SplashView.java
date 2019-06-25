package com.talkao.lopezcorominas.app.view.callbackview;

import com.talkao.lopezcorominas.commons.model.Song;

import java.util.List;

/**
 * {@inheritDoc}
 */
public interface SplashView extends CallbackView {

    void continueToMain(List<Song> songs);

}