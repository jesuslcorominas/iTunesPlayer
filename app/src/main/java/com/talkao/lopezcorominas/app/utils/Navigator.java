
package com.talkao.lopezcorominas.app.utils;

import android.app.Activity;
import android.os.Bundle;

import com.talkao.lopezcorominas.app.R;
import com.talkao.lopezcorominas.app.view.activity.DetailActivity_;
import com.talkao.lopezcorominas.app.view.activity.MainActivity_;
import com.talkao.lopezcorominas.commons.model.Song;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de utilidad para gestionar la navegacion de la aplicacion. Todos los cambios de pantallas
 * (Activity) de la aplicacion deben hacerse a traves de este @{@link EBean}, que es inyectado
 * en todas las {@link Activity} a traves de las clases base
 * {@link com.talkao.lopezcorominas.app.view.activity.AbstractBaseActivity} y
 * {@link com.talkao.lopezcorominas.app.view.activity.AbstractBaseAppCompatActivity}
 *
 * @see <a href="https://github.com/androidannotations/androidannotations/wiki/Enhance-custom-classes">EBean</a>
 * <p>
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
@EBean
public class Navigator {

    /**
     * Hace up en la aplicacion. En esta aplicacion, mata la Activity que lo invoca
     *
     * @param origin La activity que invoca la accion up
     * @see <a href="https://developer.android.com/design/patterns/navigation.html">Up vs Back</a>
     */
    public void up(Activity origin) {
        origin.finish();
        origin.overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_right);
    }

    public void main(Activity origin, List<Song> songs) {
        MainActivity_.intent(origin).songs(new ArrayList<>(songs)).start();
        anim(origin);

        origin.finish();
    }

    public void detail(Activity origin, List<Song> songs, int position, Bundle options) {
        DetailActivity_.intent(origin).songs(new ArrayList<Song>(songs)).position(position).withOptions(options).start();
    }

    private void anim(Activity origin) {
        origin.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

}
