package com.rv.suttatracker.Design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rv.suttatracker.R;

public class MainActivity extends AppCompatActivity {
    Button btnReport, btnEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReport = findViewById(R.id.btnReport);
        btnEntry = findViewById(R.id.btnEntry);

        btnEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),activity_data_entry.class);
                startActivity(in);
            }
        });

        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),activity_report.class);
                startActivity(in);
            }
        });



    }
}