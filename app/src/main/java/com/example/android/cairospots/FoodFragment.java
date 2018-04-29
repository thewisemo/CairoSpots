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
public class FoodFragment extends Fragment {


    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.spot_grid_one_colum, container, false);

        // Create a list of foodSpots
        final ArrayList<Spot> foodSpots = new ArrayList<>();
        foodSpots.add(new Spot(getString(R.string.elprince), R.string.dummy_description,
                R.drawable.drawable_food_el_prince, getString(R.string.dummy_opening_hours),
                2, "http://maps.google.com/maps?daddr=30.0806262, 31.2188924,15z"));
        foodSpots.add(new Spot(getString(R.string.dummy_food_name), R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", getString(R.string.dummy_opening_hours),
                10, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        foodSpots.add(new Spot(getString(R.string.dummy_food_name), R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", getString(R.string.dummy_opening_hours),
                30, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        foodSpots.add(new Spot(getString(R.string.dummy_food_name), R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", getString(R.string.dummy_opening_hours),
                15, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        foodSpots.add(new Spot(getString(R.string.dummy_food_name), R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", getString(R.string.dummy_opening_hours),
                25, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        foodSpots.add(new Spot(getString(R.string.dummy_food_name), R.string.dummy_description,
                "https://images.memphistours.com/large/214261814_EgyptianMuseum.jpg", getString(R.string.dummy_opening_hours),
                23, "http://maps.google.com/maps?daddr=30.786416, 30.999049"));
        // Create an {@link SpotAdapter}, whose data source is a list of {@link Spot}s. The
        // adapter knows how to create list items for each item in the list.
        SpotAdapter adapter = new SpotAdapter(getActivity(), foodSpots);
        // Find the {@link GridView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link GridView} with the view ID called grid, which is declared in the
        // spot_grid_one_colum.xml layout file.
        GridView gridView = rootView.findViewById(R.id.grid);
        // Make the {@link GridView} use the {@link SpotAdapter} we created above, so that the
        // {@link GridView} will display grid items for each {@link Spot} in the list.
        gridView.setAdapter(adapter);
        //add event listener so we can handle clicks
        AdapterView.OnItemClickListener adapterViewListener = new AdapterView.OnItemClickListener() {
            //on click
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Spot foodSpot = foodSpots.get(position);
                Intent intent = new Intent(getActivity(), FoodDetailsActivity.class);
                intent.putExtra("SpotImage", foodSpot.getImageUrl());
                intent.putExtra("SpotName", foodSpot.getSpotName());
                intent.putExtra("ShortDescription", foodSpot.getShortDescription());
                intent.putExtra("DrawableImage", foodSpot.getImageResourceId());
                intent.putExtra("AccsessTime", foodSpot.getOpeningHours());
                intent.putExtra("TicketPrice", foodSpot.getTicketPrice());
                intent.putExtra("SpotLocation", foodSpot.getMapLocation());
                startActivity(intent);
            }
        };
        //set the listener to the grid view
        gridView.setOnItemClickListener(adapterViewListener);

        return rootView;
    }

}
