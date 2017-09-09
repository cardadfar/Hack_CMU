package com.example.mwbecker.busbuddy;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class secondscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondscreen);
        Button okayBtn = (Button) findViewById(R.id.nO);
        okayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent q = new Intent(secondscreen.this, accountCreated.class);
                startActivity(q);
            }
        });
    }
}
