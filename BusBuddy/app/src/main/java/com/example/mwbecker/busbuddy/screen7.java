package com.example.mwbecker.busbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import java.util.HashMap;

public class screen7 extends AppCompatActivity {
    //input
    static String unp = "usernamePassenger";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen7);

        // gets information from screen 1 (about the username, was found in passenger-list)
        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString(unp);

        LinearLayout linear = (LinearLayout) findViewById(R.id.layout7);
        linear.setOrientation(LinearLayout.VERTICAL);

        // GET ARRAY OF BUSES FOR PASSENGER
        HashMap<String, Button> ab = new HashMap<String, Button>();

        // FIX PASSENGER
        Passenger pass = new Passenger("");
        // bus name, curr stop, your stop, coloring if your stop >= curr stop || voided
        int numBuses = pass.getNumBuses();
        for (String bus : pass.Buses.keySet()) {
            String busName = pass.getName(bus);
            int currStop = pass.getCurrStopIndex(bus);
            int yourStop = pass.getStopInd(bus);

            Button temp = new Button();
            temp.setText(String.format("%s\t%d|%d", busName,currStop,yourStop));
            ab.put(bus, temp);
        }

        for (String bus : ab.keySet()) {
            Button b = ab.get(bus);

            linear.addView(b);
            // every time currStop updates, update TEXT, and get taken

            // go to 10
            b.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // go to screen 10

                }
            });
        };
        setContentView(linear);
    }
}

