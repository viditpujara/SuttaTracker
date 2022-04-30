package com.rv.suttatracker.Design;

import androidx.appcompat.app.AppCompatActivity;


import android.content.ContentValues;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.rv.suttatracker.Model.BrandsModel;
import com.rv.suttatracker.Model.CigarettesModel;
import com.rv.suttatracker.adapter.BrandListAdapter;
import com.rv.suttatracker.adapter.CigaretteListAdapter;
import com.rv.suttatracker.dbhandler.DatabaseHandler;
import com.rv.suttatracker.R;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class activity_data_entry extends AppCompatActivity {
    Button btnAdd;
    EditText Price, Place, etDate, etTime, etPlace;
    Spinner etBrand,etCigarette, etTrip;
    DatabaseHandler databaseHandler;
    ArrayList<BrandsModel> brandlist = new ArrayList<>();
    ArrayList<CigarettesModel> cigarettelist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);

        btnAdd = findViewById(R.id.entryAdd);
        etBrand = findViewById(R.id.entryBrand);
        Price = findViewById(R.id.Price);
        Place = findViewById(R.id.Place);
        etDate = findViewById(R.id.entryDate);
        etTime = findViewById(R.id.entryTime);
        etCigarette = findViewById(R.id.entryCigarrete);
        etTrip = findViewById(R.id.entryTrip);
        etPlace = findViewById(R.id.Place);
        String[] items = new String[]{"Good Trip","No Trip","Bad Trip"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,items);
        etTrip.setAdapter(adapter);

        Date c = Calendar.getInstance().getTime();

        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
        String formattedDate = df.format(c);

        etDate.setText(formattedDate);

        String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
        etTime.setText(currentTime);

        databaseHandler = new DatabaseHandler(this);
        brandlist = databaseHandler.getBrands();
        etBrand.setAdapter(new BrandListAdapter(this,brandlist));

        etBrand.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String a = brandlist.get(etBrand.getSelectedItemPosition()).getBrand_name();
                String x = databaseHandler.getbrandN(a);
                cigarettelist = databaseHandler.getCigarettes(x);
                etCigarette.setAdapter(new CigaretteListAdapter(getApplicationContext(),cigarettelist));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        String a = brandlist.get(etBrand.getSelectedItemPosition()).getBrand_name();
        String x = databaseHandler.getbrandN(a);
        cigarettelist = databaseHandler.getCigarettes(x);
        etCigarette.setAdapter(new CigaretteListAdapter(getApplicationContext(),cigarettelist));




        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valid()){
                    insert();
                }
            }
        });

    }
    boolean valid(){
        if(TextUtils.isEmpty(Price.getText().toString())) {
            Price.setError("Enter Price");
            return false;
        }
        if(TextUtils.isEmpty(Place.getText().toString())) {
            Place.setError("Enter Place");
            return false;
        }
        return true;
    }

    void insert(){
        ContentValues c = new ContentValues();
        String a = cigarettelist.get(etCigarette.getSelectedItemPosition()).getCigerettes_name();
        String x = databaseHandler.getCigN(a);
        c.put("cigarettes_id",x);
        c.put("s_price", Price.getText().toString());
        c.put("s_date",etDate.getText().toString());
        c.put("s_time",etTime.getText().toString());
        c.put("trip",etTrip.getSelectedItem().toString());
        c.put("s_place",etPlace.getText().toString());

        if (databaseHandler.insertsmoked(c) > 0 ) {
            Toast.makeText(this,"Entry Successfully",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();
        }
    }
}