package com.talkao.lopezcorominas.data.net.restclient;

import com.talkao.lopezcorominas.commons.GetCallback;
import com.talkao.lopezcorominas.commons.model.Song;
import com.talkao.lopezcorominas.data.net.dto.ResponseDto;
import com.talkao.lopezcorominas.data.net.utils.NetKeys;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Jesús López Corominas
 */
public interface ItunesRestClient extends RestClient {

    void search(String searchTerm, GetCallback<List<Song>> callback);

    interface Api {

        @GET(NetKeys.SEARCH_PATH)
        Call<ResponseDto> search(@Query(NetKeys.QUERY_TERM) String searchTerm,
                                 @Query(NetKeys.QUERY_COUNTRY) String country,
                                 @Query(NetKeys.QUERY_MEDIA) String media);

    }
}
