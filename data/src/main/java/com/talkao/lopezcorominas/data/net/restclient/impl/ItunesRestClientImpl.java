package com.talkao.lopezcorominas.data.net.restclient.impl;

import com.talkao.lopezcorominas.commons.Error;
import com.talkao.lopezcorominas.commons.GetCallback;
import com.talkao.lopezcorominas.commons.model.Song;
import com.talkao.lopezcorominas.commons.utils.ErrorKeys;
import com.talkao.lopezcorominas.commons.utils.Keys;
import com.talkao.lopezcorominas.data.net.dto.ResponseDto;
import com.talkao.lopezcorominas.data.net.restclient.ItunesRestClient;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

import javax.annotation.Nonnull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Jesús López Corominas
 */
public class ItunesRestClientImpl implements ItunesRestClient {

    private final ModelMapper mapper;
    private final ItunesRestClient.Api api;

    public ItunesRestClientImpl(ModelMapper mapper, Api api) {
        this.mapper = mapper;
        this.api = api;
    }

    @Override
    public void search(String searchTerm, GetCallback<List<Song>> callback) {
        api.search(searchTerm, Keys.COUNTRY, Keys.MEDIA_TYPE).enqueue(new Callback<ResponseDto>() {
            @Override
            public void onResponse(@Nonnull Call<ResponseDto> call, @Nonnull Response<ResponseDto> response) {
                if (!response.isSuccessful()) {
                    callback.onError(new Error(ErrorKeys.NET_ERROR, "HTTP Error: " + response.code()));
                    return;
                }

                if (response.body() != null) {
                    ResponseDto responseDto = response.body();
                    if (responseDto != null) {
                        List<Song> songs = mapper.map(responseDto.getResults(), new TypeToken<List<Song>>() {
                        }.getType());

                        callback.onSuccess(songs);
                        return;
                    }
                }

                // No deberiamos llegar nunca hasta aqui
                callback.onError(new Error(ErrorKeys.UNEXPECTED_ERROR, "La peticion de getPhotos no ha devuelto resultado"));

            }

            @Override
            public void onFailure(@Nonnull Call<ResponseDto> call, @Nonnull Throwable t) {
                callback.onError(new Error(ErrorKeys.NET_ERROR, "Error en la peticion: " + t.getMessage()));
            }
        });
    }
}
