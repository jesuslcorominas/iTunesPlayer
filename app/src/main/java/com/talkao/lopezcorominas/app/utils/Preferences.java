package com.talkao.lopezcorominas.app.utils;

import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Bean de preferencias de Android Annotations.
 * <p>
 * Al anotar la clase como @{@link SharedPref}, unicamente tenemos que crear los metodos que devuelvan
 * el tipo de preferencia y con el nombre de la preferencia.
 * <p>
 * Este es el unico caso de AndroidAnnotations en el que tenemos que trabajar con la clase
 * extendida es decir {@link com.talkao.lopezcorominas.app.utils.Preferences_}
 *
 * @see <a href="https://github.com/androidannotations/androidannotations/wiki/SharedPreferencesHelpers" />
 * <p>
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
@SharedPref(value = SharedPref.Scope.UNIQUE)
public interface Preferences {

    /**
     * Preferencia que almacena la ultima busqueda realizada
     *
     * @return Almacena la ultima busqueda realizada
     */
    String lastSearch();
}
