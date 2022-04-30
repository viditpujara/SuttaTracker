package com.rv.suttatracker.Design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rv.suttatracker.Model.SmokedModel;
import com.rv.suttatracker.R;
import com.rv.suttatracker.adapter.ReportListAdapter;
import com.rv.suttatracker.dbhandler.DatabaseHandler;

import java.util.ArrayList;

public class activity_report_data extends AppCompatActivity {
    Button historydetail_close;
    RecyclerView rcv;
    ArrayList<SmokedModel> Smokedlist = new ArrayList<>();
    ReportListAdapter reportlist;
    DatabaseHandler databaseHandler;
    String toDate, fromDate;
    TextView tv1,tv2,tv3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_data);

        historydetail_close = findViewById(R.id.historydetail_close);
        rcv = findViewById(R.id.historydetail_rv_data);
        databaseHandler = new DatabaseHandler(this);
        tv1=findViewById(R.id.totCig);
        tv2=findViewById(R.id.totNec);
        tv3=findViewById(R.id.totPrice);

        toDate=getIntent().getStringExtra("toDate");
        fromDate=getIntent().getStringExtra("fromDate");
        System.out.println(toDate);
        System.out.println(fromDate);
        historydetail_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                finish();
                startActivity(in);
            }
        });
        Smokedlist = databaseHandler.getReport(fromDate,toDate);
        rcv.setLayoutManager(new GridLayoutManager(this, 1));
        reportlist = new ReportListAdapter(this, Smokedlist);
        rcv.setAdapter(reportlist);
        int total = 0;
        int total2 = 0;
        tv1.setText(String.valueOf(reportlist.getItemCount()));
        for(int i = 0; i < reportlist.getItemCount(); i++){
            int nic = Integer.parseInt(Smokedlist.get(i).getNicotine());
            total = total + nic;
            int pri = Integer.parseInt(Smokedlist.get(i).getS_price());
            total2 = total2 + pri;
        }
        tv2.setText(String.valueOf(total));
        tv3.setText(String.valueOf(total2));

    }
}