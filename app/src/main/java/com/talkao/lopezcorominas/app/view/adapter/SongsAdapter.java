package com.talkao.lopezcorominas.app.view.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;

import com.talkao.lopezcorominas.app.view.adapter.item.SongItemView;
import com.talkao.lopezcorominas.app.view.adapter.item.SongItemView_;
import com.talkao.lopezcorominas.commons.model.Song;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Adaptador para mostrar el listado de {@link Song}
 *
 * @author Jesús López Corominas
 */
@EBean
public class SongsAdapter extends RecyclerViewBaseAdapter<Song, SongItemView> {

    @RootContext
    Context context;

    @Override
    protected SongItemView onCreateItemView(ViewGroup parent, int viewType) {
        SongItemView itemView = SongItemView_.build(context);
        itemView.setLayoutParams(new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.WRAP_CONTENT));

        return itemView;
    }
}
