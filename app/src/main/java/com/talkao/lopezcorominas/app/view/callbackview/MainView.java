package com.talkao.lopezcorominas.app.view.callbackview;

import com.talkao.lopezcorominas.commons.model.Song;

import java.util.List;

/**
 * {@inheritDoc}
 */
public interface MainView extends CallbackView {

    void refreshSongs(List<Song> songs);
}