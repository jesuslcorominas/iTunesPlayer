package com.talkao.lopezcorominas.data.net.dto;

import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class ResponseDto {

    private int resultCount;
    private List<SongDto> results;

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<SongDto> getResults() {
        return results;
    }

    public void setResults(List<SongDto> results) {
        this.results = results;
    }
}
