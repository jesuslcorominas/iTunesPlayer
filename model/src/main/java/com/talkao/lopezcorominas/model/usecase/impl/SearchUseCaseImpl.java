package com.talkao.lopezcorominas.model.usecase.impl;

import com.talkao.lopezcorominas.commons.Error;
import com.talkao.lopezcorominas.commons.GetCallback;
import com.talkao.lopezcorominas.commons.VoidCallback;
import com.talkao.lopezcorominas.commons.model.Song;
import com.talkao.lopezcorominas.commons.utils.ErrorKeys;
import com.talkao.lopezcorominas.commons.utils.TextUtils;
import com.talkao.lopezcorominas.model.repository.ItunesRepository;
import com.talkao.lopezcorominas.model.repository.PreferencesRepository;
import com.talkao.lopezcorominas.model.usecase.SearchUseCase;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class SearchUseCaseImpl implements SearchUseCase {

    private final PreferencesRepository preferencesRepository;
    private final ItunesRepository itunesRepository;

    public SearchUseCaseImpl(PreferencesRepository preferencesRepository, ItunesRepository itunesRepository) {
        this.preferencesRepository = preferencesRepository;
        this.itunesRepository = itunesRepository;
    }

    @Override
    public void execute(final String input, final GetCallback<List<Song>> callback) {
        if (TextUtils.isEmpty(input)) {
            callback.onError(new Error(ErrorKeys.EMPTY_SEARCH, "El termino de busqueda no puede estar vacio"));
            return;
        }

        itunesRepository.search(input, new GetCallback<List<Song>>() {
            @Override
            public void onSuccess(final List<Song> result) {
                preferencesRepository.setLastSearch(input, new VoidCallback() {
                    @Override
                    public void onSuccess() {
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
