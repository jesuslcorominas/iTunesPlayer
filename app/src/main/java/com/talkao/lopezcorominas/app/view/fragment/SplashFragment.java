package com.talkao.lopezcorominas.app.view.fragment;

import android.app.Activity;

import com.talkao.lopezcorominas.app.R;

import org.androidannotations.annotations.EFragment;

/**
 * {@inheritDoc}
 */
@EFragment(R.layout.fragment_splash)
public class SplashFragment extends AbstractBaseFragment {

    private SplashFragmentInteractionListener listener;

    // =============================
    // region View
    // =============================

    // endregion

    // =============================
    // region NewInstance
    // =============================    
    public static SplashFragment newInstance() {
        return SplashFragment_.builder().build();
    }

    // endregion

    // =============================
    // region Fragment
    // =============================
    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);

        try {
            listener = (SplashFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new RuntimeException("Debes implementar " + SplashFragmentInteractionListener.class.getName());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        listener = null;
    }

    // endregion

    // =============================
    // region AbstractBaseFragment
    // =============================

    @Override
    void init() {

    }

    // endregion

    // =============================
    // region Events
    // =============================

    // endregion    

    // =============================
    // region Interaction
    // =============================
    public interface SplashFragmentInteractionListener {

    }

    // endregion

    // =============================
    // region Metodos privados
    // =============================

    // endregion    
}