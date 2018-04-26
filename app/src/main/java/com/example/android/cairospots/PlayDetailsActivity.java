package com.example.android.cairospots;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PlayDetailsActivity extends AppCompatActivity {

    ImageButton locationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        // Coordinator layout object
        CoordinatorLayout clayout = findViewById(R.id.coordinator_layout);
        // Set the GridView background color.
        clayout.setBackgroundColor(getResources().getColor(android.R.color.black));
        // Toolbar object
        android.support.v7.widget.Toolbar toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        //set the back (up) button
        if (getSupportActionBar() !=null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Location ImageButton
        locationBtn = findViewById(R.id.locationBtn);
        //find all our view components
        ImageView spotImage = findViewById(R.id.image);
        TextView shortDescription = findViewById(R.id.description);
        TextView accessTimeTv = findViewById(R.id.access_time_tv);
        TextView ticketPriceTv = findViewById(R.id.ticket_range);
        //collect our intent and populate our layout
        Intent intent = getIntent();
        String image = intent.getStringExtra("SpotImage");
        String spotName = intent.getStringExtra("SpotName");
        Integer description = intent.getIntExtra("ShortDescription", 0);
        String accessTime = intent.getStringExtra("AccsessTime");
        Integer ticketPrice = intent.getIntExtra("TicketPrice", 0);
        final String spotLocation = intent.getStringExtra("SpotLocation");
        // locationBtn OnClickListener
        locationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent that opens the Google maps App with the @Link spotLocation location drop pin.
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(spotLocation));
                // Start the intent
                startActivity(intent);
            }
        });
        //set elements
        // Glide set for the spot image
        Glide.with(getApplicationContext())
                .asBitmap()
                .load(image)
                .into(spotImage);
        shortDescription.setText(description);
        accessTimeTv.setText(accessTime);
        ticketPriceTv.setText(String.valueOf(ticketPrice));
        //set the title of this activity to be the street name
        getSupportActionBar().setTitle(spotName);
    }
}
