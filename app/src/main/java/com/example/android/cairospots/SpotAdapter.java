package com.example.android.cairospots;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * {@link SpotAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Spot} objects.
 */
public class SpotAdapter extends ArrayAdapter<Spot> {
    private int mBackGroundColor;
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *  @param context The current context. Used to inflate the layout file.
     * @param spots    A List of Word objects to display in a list
     */
    public SpotAdapter(Context context, ArrayList<Spot> spots) {
        super(context, 0, spots);
    }

    /**
     * Provides a view for an AdapterView (GridView)
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View gridItemView = convertView;
        if (gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.grid_item, parent, false);
        }
        // Get the {@link Spot} object located at this position in the list.
        Spot currentSpot = getItem(position);
        // Get the Spot name from the currentSpot object and set this text on
        // the name TextView.
        TextView spotName = gridItemView.findViewById(R.id.name_tv);
        assert currentSpot != null;
        spotName.setText(currentSpot.getSpotName());
        // Get the Spot image from the currentSpot object and set the image on
        // the image ImageView.
        ImageView spotImage = gridItemView.findViewById(R.id.image_iv);
        spotImage.setImageResource(currentSpot.getImageResourceId());
        if (currentSpot.getImageResourceId() == 0) {
            // Glide
            Glide.with(getContext())
                    .asBitmap()
                    .load(currentSpot.getImageUrl())
                    .into(spotImage);
        }
        // Return the whole list item layout (containing image & text views) so that it can be shown in
        // the GridView.
        return gridItemView;
    }
}
