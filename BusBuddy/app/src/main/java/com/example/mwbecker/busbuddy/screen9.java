package com.example.mwbecker.busbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;

public class screen9 extends AppCompatActivity {
    //input
    static String BID = "busID";
    static String unp = "username";

    int stopInd = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen9);

        // gets information from screen 8 (about the bus ID)
        Bundle bundle = getIntent().getExtras();
        final String busID = bundle.getString(BID);
        final String username = bundle.getString(unp);

        // FIX BUS TO QUERY
        final Bus bus = new Bus("", "", new String[0]);
        final Passenger pass = new Passenger(username); // FIX

        LinearLayout linear = (LinearLayout) findViewById(R.id.layout9);
        linear.setOrientation(LinearLayout.VERTICAL);

        // array of stops
        HashMap<Integer, Button> ab = new HashMap<Integer, Button>();

        // make textView
        String busName = bus.getName();
        TextView tv = (TextView) findViewById(R.id.textView9);
        tv.setText(busName);

        // get num of stops
        int numStops = bus.getStopNum();
        for (int i = 0; i < numStops; i++) {
            String stopName = bus.getStopName(i);
            Button temp = new Button(this);
            temp.setText(String.format("Stop %d",i));
            ab.put(i, temp);
        }

        for (Integer i : ab.keySet()) {
            Button b = ab.get(i);
            final Integer ind = i; // a bit of a hack

            linear.addView(b);
            b.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    stopInd = ind; // update chosen stopInd
                }
            });
        };
        setContentView(linear);

        // goes to page 10
        Button subBus = (Button) findViewById(R.id.submitBtn9);
        subBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stopInd > -1) {
                    // do stuff for passenger
                    pass.addBus(busID, stopInd);

                    Intent intent = new Intent(screen9.this, screen7.class);
                    startActivity(intent);
                }
                //else consider putting a red field
            }
        });

        // goes back to page 1
        Button back = (Button) findViewById(R.id.backBtn9);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(screen9.this, screen8.class);
                startActivity(intent);
            }
        });
    }
}
