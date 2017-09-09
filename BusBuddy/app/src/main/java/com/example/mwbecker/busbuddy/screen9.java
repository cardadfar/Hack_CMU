package com.example.mwbecker.busbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;

public class screen9 extends AppCompatActivity {
    //input
    static String BID = "busID9";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen9);

        // gets information from screen 8 (about the bus ID)
        Bundle bundle = getIntent().getExtras();
        String busID = bundle.getString(BID);

        LinearLayout linear = (LinearLayout) findViewById(R.id.layout9);
        linear.setOrientation(LinearLayout.VERTICAL);

        // array of stops
        HashMap<Integer, Button> ab = new HashMap<Integer, Button>();

        // FIX BUS TO QUERY
        Bus bus = new Bus("", "", new String[0]);

        // make textView
        String busName = bus.getName();
        TextView tv = (TextView) findViewById(R.id.textView9);
        tv.setText(busName);

        // get num of stops
        int numStops = bus.getStopNum();
        for (int i = 0; i < numStops; i++) {
            String stopName = bus.getStopName(i);
            Button temp = new Button();
            temp.setText(String.format("Stop %d",i));
            ab.put(i, temp);
        }

        for (Integer i : ab.keySet()) {
            Button b = ab.get(i);

            linear.addView(b);
            b.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // go to screen 10

                }
            });
        };
        setContentView(linear);
    }
}
