package com.example.android.cairospots;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MuseumsFragment extends Fragment {


    public MuseumsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.spot_grid_one_colum, container, false);
        // Create a list of museumsSpots
        final ArrayList<Spot> museumsSpots = new ArrayList<>();
        museumsSpots.add(new Spot(getString(R.string.giza_pyramids), R.string.dummy_description,
                R.drawable.drawable_historic_pyramids, getString(R.string.dummy_opening_hours),
                2, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        museumsSpots.add(new Spot(getString(R.string.dummy_historic_name), R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", getString(R.string.dummy_opening_hours),
                30, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        museumsSpots.add(new Spot(getString(R.string.dummy_historic_name), R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", getString(R.string.dummy_opening_hours),
                40, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        museumsSpots.add(new Spot(getString(R.string.dummy_historic_name), R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", getString(R.string.dummy_opening_hours),
                25, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        museumsSpots.add(new Spot(getString(R.string.dummy_historic_name), R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", getString(R.string.dummy_opening_hours),
                15, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        museumsSpots.add(new Spot(getString(R.string.dummy_historic_name), R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", getString(R.string.dummy_opening_hours),
                24, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        // Create an {@link SpotAdapter}, whose data source is a list of {@link Spot}s. The
        // adapter knows how to create list items for each item in the list.
        SpotAdapter adapter = new SpotAdapter(getActivity(), museumsSpots);
        // Find the {@link GridView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link GridView} with the view ID called grid, which is declared in the
        // spot_grid_one_colum.xml layout file.
        GridView gridView = rootView.findViewById(R.id.grid);
        // Make the {@link GridView} use the {@link SpotAdapter} we created above, so that the
        // {@link GridView} will display grid items for each {@link Spot} in the list.
        gridView.setAdapter(adapter);
        // Force the Grid View" to be setNestedScrolling
        ViewCompat.setNestedScrollingEnabled(gridView, true);
        //add event listener so we can handle clicks
        AdapterView.OnItemClickListener adapterViewListener = new AdapterView.OnItemClickListener() {
            //on click
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Spot museumSpot = museumsSpots.get(position);
                Intent intent = new Intent(getActivity(), MuseumsDetailsActivity.class);
                intent.putExtra("SpotImage", museumSpot.getImageUrl());
                intent.putExtra("SpotName", museumSpot.getSpotName());
                intent.putExtra("ShortDescription", museumSpot.getShortDescription());
                intent.putExtra("DrawableImage", museumSpot.getImageResourceId());
                intent.putExtra("AccsessTime", museumSpot.getOpeningHours());
                intent.putExtra("TicketPrice", museumSpot.getTicketPrice());
                intent.putExtra("SpotLocation", museumSpot.getMapLocation());
                startActivity(intent);
            }
        };
        //set the listener to the grid view
        gridView.setOnItemClickListener(adapterViewListener);
            return rootView;
    }
}
