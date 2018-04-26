package com.example.android.cairospots;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayFragment extends Fragment {


    public PlayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.spot_grid_two_colums, container, false);

        // Create a list of playSpots
        final ArrayList<Spot> playSpots = new ArrayList<>();
        playSpots.add(new Spot("Play 1", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "9 AM : 5 PM",
                10, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        playSpots.add(new Spot("Play 2", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "10 AM : 6 PM",
                20, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        playSpots.add(new Spot("Play 3", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "10 AM : 8 PM",
                15, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        playSpots.add(new Spot("Play 4", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "9 AM : 5 PM",
                10, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        playSpots.add(new Spot("Play 1", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "9 AM : 5 PM",
                10, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        playSpots.add(new Spot("Play 2", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "10 AM : 6 PM",
                20, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        playSpots.add(new Spot("Play 3", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "10 AM : 8 PM",
                15, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        playSpots.add(new Spot("Play 4", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "9 AM : 5 PM",
                10, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        playSpots.add(new Spot("Play 1", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "9 AM : 5 PM",
                10, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        playSpots.add(new Spot("Play 2", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "10 AM : 6 PM",
                20, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        playSpots.add(new Spot("Play 3", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "10 AM : 8 PM",
                15, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        playSpots.add(new Spot("Play 4", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "9 AM : 5 PM",
                10, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        playSpots.add(new Spot("Play 1", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "9 AM : 5 PM",
                10, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        playSpots.add(new Spot("Play 2", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "10 AM : 6 PM",
                20, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        playSpots.add(new Spot("Play 3", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "10 AM : 8 PM",
                15, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        playSpots.add(new Spot("Play 4", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "9 AM : 5 PM",
                10, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        // Create an {@link SpotAdapter}, whose data source is a list of {@link Spot}s. The
        // adapter knows how to create list items for each item in the list.
        SpotAdapter adapter = new SpotAdapter(getActivity(), playSpots);
        // Find the {@link GridView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link GridView} with the view ID called grid, which is declared in the
        // spot_grid_two_colums.xml layout file.
        GridView gridView = rootView.findViewById(R.id.grid);
        // Make the {@link GridView} use the {@link SpotAdapter} we created above, so that the
        // {@link GridView} will display list items for each {@link Spot} in the grid.
        gridView.setAdapter(adapter);
        //add event listener so we can handle clicks
        AdapterView.OnItemClickListener adapterViewListener = new AdapterView.OnItemClickListener() {
            //on click
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Spot museumSpot = playSpots.get(position);
                Intent intent = new Intent(getActivity(), PlayDetailsActivity.class);
                intent.putExtra("SpotImage", museumSpot.getImageUrl());
                intent.putExtra("SpotName", museumSpot.getSpotName());
                intent.putExtra("ShortDescription", museumSpot.getShortDescription());
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
