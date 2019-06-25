package com.talkao.lopezcorominas.data.datasource.impl;

import com.talkao.lopezcorominas.commons.GetCallback;
import com.talkao.lopezcorominas.commons.model.Song;
import com.talkao.lopezcorominas.data.datasource.ItunesDatasource;
import com.talkao.lopezcorominas.data.net.restclient.ItunesRestClient;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class ItunesDatasourceImpl implements ItunesDatasource {

    private final ItunesRestClient itunesRestClient;

    public ItunesDatasourceImpl(ItunesRestClient itunesRestClient) {
        this.itunesRestClient = itunesRestClient;
    }

    @Override
    public void search(String searchTerm, GetCallback<List<Song>> callback) {
        itunesRestClient.search(searchTerm, callback);
    }
}
