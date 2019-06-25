package com.talkao.lopezcorominas.model.usecase.impl;

import com.talkao.lopezcorominas.commons.Error;
import com.talkao.lopezcorominas.commons.GetCallback;
import com.talkao.lopezcorominas.commons.GetStringCallback;
import com.talkao.lopezcorominas.commons.model.Song;
import com.talkao.lopezcorominas.commons.utils.ErrorKeys;
import com.talkao.lopezcorominas.commons.utils.TextUtils;
import com.talkao.lopezcorominas.model.repository.ItunesRepository;
import com.talkao.lopezcorominas.model.repository.PreferencesRepository;
import com.talkao.lopezcorominas.model.usecase.LastSearchUseCase;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class LastSearchUseCaseImpl implements LastSearchUseCase {

    private final PreferencesRepository preferencesRepository;
    private final ItunesRepository itunesRepository;

    public LastSearchUseCaseImpl(PreferencesRepository preferencesRepository, ItunesRepository itunesRepository) {
        this.preferencesRepository = preferencesRepository;
        this.itunesRepository = itunesRepository;
    }

    @Override
    public void execute(Void input, final GetCallback<List<Song>> callback) {
        preferencesRepository.getLastSearch(new GetStringCallback() {
            @Override
            public void onSuccess(String lastSearch) {
                if (TextUtils.isEmpty(lastSearch)) {
                    callback.onError(new Error(ErrorKeys.EMPTY_SEARCH, "Todavia no se ha realizado ninguna busqueda"));
                    return;
                }

                itunesRepository.search(lastSearch, new GetCallback<List<Song>>() {
                    @Override
                    public void onSuccess(List<Song> result) {
                        callback.onSuccess(result);
                    }

                    @Override
                    public void onError(Error error) {
                        callback.onError(error);
                    }
                });
            }

            @Override
            public void onError(Error error) {
                callback.onError(error);
            }
        });
    }
}
