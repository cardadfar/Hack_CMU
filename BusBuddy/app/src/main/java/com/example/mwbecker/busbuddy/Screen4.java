package com.example.mwbecker.busbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.util.HashMap;

public class Screen4 extends AppCompatActivity {
    // input
    static String und = "usernameDriver";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4);

        // gets information from screen 1 (about the username, was found in driver-list)
        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString(und); //keyname is un

        LinearLayout linear = (LinearLayout) findViewById(R.id.layout4);
        linear.setOrientation(LinearLayout.VERTICAL);

        // GET ARRAY OF BUSES FOR DRIVER
        HashMap<String, Button> ab = new HashMap<String, Button>();

        Driver driv = new Driver("");
        int busNum = driv.getBusNum();
        for (int i = 0; i < busNum; i++) {
            String busID = driv.getBusID(i);
            Bus object bus
            String busName = bus.getName();

            Button temp = new Button();
            temp.setText(busName);
            ab.put(busID, temp);
        }

        for (String bus : ab.keySet()) {
            Button b = ab.get(bus);

            linear.addView(b);
            b.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // go to screen 6

                }
            });
        };
        setContentView(linear);
    }
}
