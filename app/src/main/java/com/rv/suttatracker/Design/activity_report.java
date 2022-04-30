package com.rv.suttatracker.Design;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.rv.suttatracker.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class activity_report extends AppCompatActivity {
    EditText fromDate, toDate;
    Button btnApply;
    Date date,date2;
    final Calendar myCalendar= Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        fromDate = findViewById(R.id.fromDate);
        toDate = findViewById(R.id.toDate);
        btnApply = findViewById(R.id.btnApply);

        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }
        };
        fromDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dpd;
                dpd = new DatePickerDialog(activity_report.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });

        DatePickerDialog.OnDateSetListener date2 =new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel2();
            }
        };
        toDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dpd;
                dpd = new DatePickerDialog(activity_report.this,date2,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valid()){
                    Intent in = new Intent(getApplicationContext(),activity_report_data.class);
                    in.putExtra("fromDate", fromDate.getText().toString());
                    in.putExtra("toDate", toDate.getText().toString());
                    startActivity(in);
                }
            }
        });

    }

    boolean valid(){
        if(TextUtils.isEmpty(toDate.getText().toString())) {
            toDate.setError("Enter Date");
            return false;
        }
        if(TextUtils.isEmpty(fromDate.getText().toString())) {
            fromDate.setError("Enter Date");
            return false;
        }
//        SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY");
//        try {
//            date = format.parse(fromDate.toString());
//            date2 = format.parse(toDate.toString());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        if(date2.after(date)){
//            return false;
//        }
        return true;
    }
    private void updateLabel(){
        String myFormat="YYYY/MM/dd";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        fromDate.setText(dateFormat.format(myCalendar.getTime()));
    }
    private void updateLabel2(){
        String myFormat="YYYY/MM/dd";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        toDate.setText(dateFormat.format(myCalendar.getTime()));
    }
}