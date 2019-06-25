package com.talkao.lopezcorominas.model.repository;

import com.talkao.lopezcorominas.commons.GetStringCallback;
import com.talkao.lopezcorominas.commons.VoidCallback;

/**
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
public interface PreferencesRepository extends Repository {

    void setLastSearch(String lastSearch, VoidCallback callback);

    void getLastSearch(GetStringCallback callback);

}
