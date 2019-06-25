package com.talkao.lopezcorominas.model.repository;

import com.talkao.lopezcorominas.commons.GetCallback;
import com.talkao.lopezcorominas.commons.model.Song;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public interface ItunesRepository extends Repository {

    void search(String searchTerm, GetCallback<List<Song>> callback);
}
