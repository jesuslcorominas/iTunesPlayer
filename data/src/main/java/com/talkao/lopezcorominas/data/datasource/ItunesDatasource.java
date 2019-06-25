package com.talkao.lopezcorominas.data.datasource;

import com.talkao.lopezcorominas.commons.GetCallback;
import com.talkao.lopezcorominas.commons.model.Song;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public interface ItunesDatasource extends Datasource {

    void search(String searchTerm, GetCallback<List<Song>> callback);
}
