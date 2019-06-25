package com.talkao.lopezcorominas.app.presenter;

import com.talkao.lopezcorominas.app.view.callbackview.CallbackView;

/**
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
public interface Presenter<V extends CallbackView> {

    void setCallbackView(V view);

    void onResume();

    void onPause();

}
