package com.talkao.lopezcorominas.data.datasource;

import com.talkao.lopezcorominas.commons.GetStringCallback;
import com.talkao.lopezcorominas.commons.VoidCallback;

/**
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
public interface PreferencesDatasource extends Datasource {

    void getLastSearch(GetStringCallback callback);

    void setLastSearch(String lastSearch, VoidCallback callback);

}


