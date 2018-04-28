package com.example.android.cairospots;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GreenFragment extends Fragment {


    public GreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.spot_grid_two_colums, container, false);

        // Create a list of greenSpots
        final ArrayList<Spot> greenSpots = new ArrayList<>();
        greenSpots.add(new Spot("Al Azhar Park", R.string.dummy_description,
                R.drawable.drawable_green_azhar_park, "10 AM : 7 PM",
                2, "http://maps.google.com/maps?daddr=30.0406319, 31.2647327,15z"));
        greenSpots.add(new Spot("Green 2", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "10 AM : 6 PM",
                20, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        greenSpots.add(new Spot("Green 3", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "10 AM : 8 PM",
                15, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        greenSpots.add(new Spot("Green 4", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "9 AM : 5 PM",
                10, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        greenSpots.add(new Spot("Green 5", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "9 AM : 5 PM",
                10, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        greenSpots.add(new Spot("Green 6", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "10 AM : 6 PM",
                20, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        greenSpots.add(new Spot("Green 7", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "10 AM : 8 PM",
                15, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        greenSpots.add(new Spot("Green 8", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "9 AM : 5 PM",
                10, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        greenSpots.add(new Spot("Green 9", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "9 AM : 5 PM",
                10, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        greenSpots.add(new Spot("Green 10", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "10 AM : 6 PM",
                20, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        greenSpots.add(new Spot("Green 11", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "10 AM : 8 PM",
                15, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        greenSpots.add(new Spot("Green 12", R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", "9 AM : 5 PM",
                10, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        // Create an {@link SpotAdapter}, whose data source is a list of {@link Spot}s. The
        // adapter knows how to create list items for each item in the list.
        SpotAdapter adapter = new SpotAdapter(getActivity(), greenSpots);
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
                Spot greenSpot = greenSpots.get(position);
                Intent intent = new Intent(getActivity(), GreenDetailsActivity.class);
                intent.putExtra("SpotImage", greenSpot.getImageUrl());
                intent.putExtra("SpotName", greenSpot.getSpotName());
                intent.putExtra("ShortDescription", greenSpot.getShortDescription());
                intent.putExtra("DrawableImage", greenSpot.getImageResourceId());
                intent.putExtra("AccsessTime", greenSpot.getOpeningHours());
                intent.putExtra("TicketPrice", greenSpot.getTicketPrice());
                intent.putExtra("SpotLocation", greenSpot.getMapLocation());
                startActivity(intent);
            }
        };
        //set the listener to the grid view
        gridView.setOnItemClickListener(adapterViewListener);

        return rootView;
    }

}
