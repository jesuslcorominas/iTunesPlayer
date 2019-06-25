package com.talkao.lopezcorominas.app.event.impl;

import com.talkao.lopezcorominas.app.event.Event;
import com.talkao.lopezcorominas.commons.model.Song;

/**
 * @author Jesús López Corominas
 */
public class GetSongDetailEvent implements Event {

    private final Song song;

    public GetSongDetailEvent(Song song) {
        this.song = song;
    }

    public Song getSong() {
        return song;
    }
}
