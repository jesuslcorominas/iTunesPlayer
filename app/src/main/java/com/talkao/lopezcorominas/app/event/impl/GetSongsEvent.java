package com.talkao.lopezcorominas.app.event.impl;

import com.talkao.lopezcorominas.app.event.Event;
import com.talkao.lopezcorominas.commons.model.Song;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class GetSongsEvent implements Event {

    private final List<Song> songs;

    public GetSongsEvent(List<Song> songs) {
        this.songs = songs;
    }

    public List<Song> getSongs() {
        return songs;
    }
}
