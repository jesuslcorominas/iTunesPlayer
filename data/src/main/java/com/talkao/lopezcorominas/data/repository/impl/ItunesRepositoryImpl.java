package com.talkao.lopezcorominas.data.repository.impl;

import com.talkao.lopezcorominas.commons.GetCallback;
import com.talkao.lopezcorominas.commons.model.Song;
import com.talkao.lopezcorominas.data.datasource.ItunesDatasource;
import com.talkao.lopezcorominas.model.repository.ItunesRepository;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class ItunesRepositoryImpl implements ItunesRepository {

    private final ItunesDatasource itunesDatasource;

    public ItunesRepositoryImpl(ItunesDatasource itunesDatasource) {
        this.itunesDatasource = itunesDatasource;
    }

    @Override
    public void search(String searchTerm, GetCallback<List<Song>> callback) {
        itunesDatasource.search(searchTerm, callback);
    }
}
