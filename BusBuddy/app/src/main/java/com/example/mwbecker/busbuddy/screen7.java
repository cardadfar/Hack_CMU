package com.example.mwbecker.busbuddy;

import android.content.Intent;
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
    // output
    static String BID = "busID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen7);

        // gets information from screen 1 (about the username, was found in passenger-list)
        Bundle bundle = getIntent().getExtras();
        final String username = bundle.getString(unp);

        // FIX PASSENGER
        final Passenger pass = new Passenger("");

        LinearLayout linear = (LinearLayout) findViewById(R.id.layout7);
        linear.setOrientation(LinearLayout.VERTICAL);

        // GET ARRAY OF BUSES FOR PASSENGER
        HashMap<String, Button> ab = new HashMap<String, Button>();

        // bus name, curr stop, your stop, coloring if your stop >= curr stop || voided
        int numBuses = pass.getNumBuses();
        for (String bus : pass.Buses.keySet()) {
            String busName = pass.getName(bus);
            int currStop = pass.getCurrStopIndex(bus);
            int yourStop = pass.getStopInd(bus);

            Button temp = new Button(this);
            temp.setText(String.format("%s\t%d|%d", busName,currStop,yourStop));
            ab.put(bus, temp);
        }

        for (String bus : ab.keySet()) {
            final String busf = bus;
            Button b = ab.get(bus);
            Bus busObj = new Bus(bus, "", new String[0]); //FIX
            final int currStop = busObj.getCurrStopInd(); // hack
            final int yourStop = pass.getStopInd(bus); // hack

            linear.addView(b);
            // every time currStop updates, update TEXT, and get taken

            // go to 10
            b.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // go to screen 10 IF currstop < yourstop, else nothing
                    // pass passenger and bus
                    if (currStop < yourStop) {
                        Intent intent = new Intent(screen7.this, screen10.class);
                        intent.putExtra(BID, busf);
                        intent.putExtra(unp, username);
                        startActivity(intent);
                    }
                }
            });
        };
        setContentView(linear);

        // goes to page 8
        Button addBus = (Button) findViewById(R.id.addBtn7);
        addBus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // carry over passenger
                Intent intent = new Intent(screen7.this, screen8.class);
                intent.putExtra(unp, username);
                startActivity(intent);
            }
        });

        // goes back to page 1
        Button back = (Button) findViewById(R.id.backBtn7);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(screen7.this, screen1.class);
                startActivity(intent);
            }
        });
    }
}

