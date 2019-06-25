package com.talkao.lopezcorominas.app.view.adapter.item;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.talkao.lopezcorominas.app.R;
import com.talkao.lopezcorominas.commons.model.Song;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * @author Jesús López Corominas
 */
@EViewGroup(R.layout.item_song)
public class SongItemView extends CardView implements ItemView<Song> {

    /**
     * El contexto de la aplicacion
     */
    private Context context;

    @ViewById(R.id.item_song_linearLayout_content)
    LinearLayout linearLayoutContent;

    @ViewById(R.id.item_song_imageView_photo)
    AppCompatImageView imageViewPhoto;

    @ViewById(R.id.item_song_textView_name)
    AppCompatTextView textViewName;

    @ViewById(R.id.item_song_textView_info)
    AppCompatTextView textViewInfo;

    public SongItemView(Context context) {
        super(context);

        this.context = context;
    }

    @Override
    public void bind(Song item, int position) {
        this.setCardBackgroundColor(context.getResources().getColor(R.color.background_light));

        linearLayoutContent.setBackgroundColor(context.getResources().getColor(position % 2 == 0 ? R.color.white : R.color.odd_color));

        textViewName.setText(item.getTrackName());
        textViewInfo.setText(item.getArtistName());

        Picasso.with(context).
                load(item.getThumbnail()).
                placeholder(R.drawable.ic_no_image).
                error(R.drawable.ic_no_image).
                into(imageViewPhoto);
    }

    public View getImageViewPhoto() {
        return imageViewPhoto;
    }

    public View getTextViewName() {
        return textViewName;
    }

    public View getTextViewInfo() {
        return textViewInfo;
    }
}
