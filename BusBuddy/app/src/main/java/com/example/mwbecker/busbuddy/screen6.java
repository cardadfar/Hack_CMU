package com.example.mwbecker.busbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class screen6 extends AppCompatActivity {
    // input
    static String BID = "busID7";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen6);

        // gets information from screen 4 (about the bus ID)
        Bundle bundle = getIntent().getExtras();
        String busID = bundle.getString(BID);

        LinearLayout linear = (LinearLayout) findViewById(R.id.layout6);
        linear.setOrientation(LinearLayout.VERTICAL);

        // GET ARRAY OF STOPS FOR BUSES
        HashMap<Integer, CheckBox> ab = new HashMap<Integer, CheckBox>();

        // FIX BUS TO QUERY
        Bus bus = new Bus("", "", new String[0]);

        // make textView
        String busName = bus.getName();
        TextView tv = (TextView) findViewById(R.id.textView6);
        tv.setText(busName);

        // get num of stops
        int numStops = bus.getStopNum();
        for (int i = 0; i < numStops; i++) {
            CheckBox temp = new CheckBox(this);
            int numPass = bus.getPassNum(i);
            int numGoing = bus.getPassGoing(i);
            temp.setText(String.format("Stop %d\t%d|%d", i,numGoing,numPass));// DO THE STOP NUMBER!!! AND NAME!!! AND PEOPLE!!!
            ab.put(i, temp);
        }

        for (Integer i : ab.keySet()) {
            CheckBox b = ab.get(i);

            linear.addView(b);

            //UPDATE so that if numGoing changes, get voided, maybe end, gray out
            b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (buttonView.isChecked()) {
                        // SET TRACK TO STOP
                        return;
                    }
                }
            });
            setContentView(linear);
        }
    }
}
