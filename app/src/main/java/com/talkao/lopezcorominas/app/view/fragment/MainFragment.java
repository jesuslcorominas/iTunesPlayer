package com.talkao.lopezcorominas.app.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.talkao.lopezcorominas.app.R;
import com.talkao.lopezcorominas.app.event.impl.GetSongsEvent;
import com.talkao.lopezcorominas.app.view.adapter.SongsAdapter;
import com.talkao.lopezcorominas.app.view.adapter.divider.HorizontalSpaceItemDecoration;
import com.talkao.lopezcorominas.app.view.adapter.divider.VerticalSpaceItemDecoration;
import com.talkao.lopezcorominas.app.view.adapter.item.SongItemView;
import com.talkao.lopezcorominas.commons.model.Song;
import com.talkao.lopezcorominas.commons.utils.TextUtils;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.EditorAction;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.Subscribe;

/**
 * {@inheritDoc}
 */
@EFragment(R.layout.fragment_main)
public class MainFragment extends AbstractBaseFragment implements SongsAdapter.OnItemClickListener<Song, SongItemView> {

    private MainFragmentInteractionListener listener;

    @ViewById(R.id.fragment_main_editText_search)
    EditText editTextSearch;

    @ViewById(R.id.fragment_main_recyclerView_songs)
    RecyclerView recyclerViewSongs;

    @Bean
    SongsAdapter songsAdapter;

    @Bean
    HorizontalSpaceItemDecoration horizontalSpaceItemDecoration;

    @Bean
    VerticalSpaceItemDecoration verticalSpaceItemDecoration;

    // =============================
    // region View
    // =============================

    // endregion

    // =============================
    // region NewInstance
    // =============================    
    public static MainFragment newInstance() {
        return MainFragment_.builder().build();
    }

    // endregion

    // =============================
    // region Fragment
    // =============================
    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);

        try {
            listener = (MainFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new RuntimeException("Debes implementar " + MainFragmentInteractionListener.class.getName());
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
        songsAdapter.setOnItemClickListener(this);

        recyclerViewSongs.setAdapter(songsAdapter);

        verticalSpaceItemDecoration.setHeightDimen(R.dimen.margin);
        horizontalSpaceItemDecoration.setWidthDimen(R.dimen.margin);

        recyclerViewSongs.addItemDecoration(verticalSpaceItemDecoration);
        recyclerViewSongs.addItemDecoration(horizontalSpaceItemDecoration);

        recyclerViewSongs.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        if (listener != null) {
            listener.onInitFinished();
        }
    }

    // endregion

    // =============================
    // region Events
    // =============================
    @SuppressWarnings("unused")
    @Subscribe
    public void onGetSongsEvent(GetSongsEvent event) {
        songsAdapter.clear();
        songsAdapter.addItems(event.getSongs());
    }
    // endregion    

    // =============================
    // region Interaction
    // =============================
    public interface MainFragmentInteractionListener {
        void onInitFinished();

        void searchSongs(String searchTerm);

        void onItemClick(SongItemView songItemView, int position);
    }

    @EditorAction(R.id.fragment_main_editText_search)
    void onEditorActionsOnHelloTextView(TextView textViewSearch, int actionId, KeyEvent keyEvent) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH
                || actionId == EditorInfo.IME_ACTION_DONE
                || keyEvent.getAction() == KeyEvent.ACTION_DOWN
                && keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            if (!TextUtils.isEmpty(textViewSearch.getText().toString()) && listener != null) {
                final InputMethodManager inputMethodManager = (InputMethodManager) getActivity()
                        .getSystemService(Context.INPUT_METHOD_SERVICE);

                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(textViewSearch.getWindowToken(), 0);
                }

                listener.searchSongs(textViewSearch.getText().toString());
            }
        }
    }

    // endregion

    // =========================================
    //  region SongsAdapter.OnItemClickListener
    // =========================================
    @Override
    public void onItemClick(int position, SongItemView view, Song data) {
        if (listener != null) {
            listener.onItemClick(view, position);
        }
    }

    // endregion

    // =============================
    // region Metodos privados
    // =============================

    // endregion
}