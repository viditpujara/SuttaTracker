package com.rv.suttatracker.dbhandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

import com.rv.suttatracker.Model.BrandsModel;
import com.rv.suttatracker.Model.CigarettesModel;
import com.rv.suttatracker.Model.SmokedModel;

public class DatabaseHandler  extends SQLiteAssetHelper {
    public static final String db_name = "suttatracker.db";
    public static final int db_ver = 1;

    public DatabaseHandler(Context context) {
        super(context, db_name, null, db_ver);
    }

    public ArrayList<BrandsModel> getBrands() {

        ArrayList<BrandsModel> brand = new ArrayList<>();
        String SQL = "SELECT * FROM brands ORDER BY brand_id DESC";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SQL, null);
        cursor.moveToFirst();

        for(int i = 0; i < cursor.getCount(); i++){
            BrandsModel c = new BrandsModel();
            c.setBrand_id(cursor.getInt(cursor.getColumnIndex("brand_id")));
            c.setBrand_name(cursor.getString(cursor.getColumnIndex("brand_name")));

            brand.add(c);
            cursor.moveToNext();
        }
        db.close();
        cursor.close();
        return brand;
    }

    public String getbrandN(String BrandName){
        String name;
        String SQL = "SELECT brand_id FROM brands where brand_name = \""+BrandName+"\"" ;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SQL, null);
        cursor.moveToFirst();
        name = cursor.getString(cursor.getColumnIndex("brand_id"));

        db.close();
        cursor.close();

        return name;
    }
    public String getCigN(String Cigarettes){
        String name;
        String SQL = "SELECT cigarettes_id FROM cigarettes where cigarettes_name = \""+Cigarettes+"\"" ;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SQL, null);
        cursor.moveToFirst();
        name = cursor.getString(cursor.getColumnIndex("cigarettes_id"));

        db.close();
        cursor.close();

        return name;
    }

    public ArrayList<CigarettesModel> getCigarettes(String id) {

        ArrayList<CigarettesModel> cigarettes = new ArrayList<>();
        String SQL = "SELECT * FROM cigarettes,brands WHERE cigarettes.brand_id=brands.brand_id AND brands.brand_id= "+id;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SQL, null);
        cursor.moveToFirst();

        for(int i = 0; i < cursor.getCount(); i++){
            CigarettesModel c = new CigarettesModel();
            c.setBrand_id(cursor.getInt(cursor.getColumnIndex("brand_id")));
            c.setCigerettes_id(cursor.getInt(cursor.getColumnIndex("cigarettes_id")));
            c.setCigerettes_name(cursor.getString(cursor.getColumnIndex("cigarettes_name")));
            c.setNicotine(cursor.getString(cursor.getColumnIndex("nicotine")));

            cigarettes.add(c);
            cursor.moveToNext();
        }
        db.close();
        cursor.close();
        return cigarettes;
    }
    public long insertsmoked(ContentValues c){
        SQLiteDatabase db = getWritableDatabase();
        long id = db.insert("smoked",null,c);
        db.close();
        return id;
    }

    public ArrayList<SmokedModel> getReport(String fromDate,String toDate) {

        ArrayList<SmokedModel> canvas = new ArrayList<>();
        String SQL = "SELECT * FROM smoked,cigarettes WHERE smoked.cigarettes_id = cigarettes.cigarettes_id AND s_date BETWEEN \""+fromDate+"\" AND \""+toDate+"\"";
        System.out.println(SQL);
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SQL, null);
        cursor.moveToFirst();
        for(int i = 0; i < cursor.getCount(); i++){
            SmokedModel c = new SmokedModel();
            c.setS_id(cursor.getInt(cursor.getColumnIndex("s_id")));
            c.setC_name(cursor.getString(cursor.getColumnIndex("cigarettes_name")));
            c.setCigarette_id(cursor.getInt(cursor.getColumnIndex("cigarettes_id")));
            c.setNicotine(cursor.getString(cursor.getColumnIndex("nicotine")));
            c.setS_date(cursor.getString(cursor.getColumnIndex("s_date")));
            c.setS_place(cursor.getString(cursor.getColumnIndex("s_place")));
            c.setS_price(cursor.getString(cursor.getColumnIndex("s_price")));
            c.setS_time(cursor.getString(cursor.getColumnIndex("s_time")));
            c.setTrip(cursor.getString(cursor.getColumnIndex("trip")));

            canvas.add(c);
            cursor.moveToNext();
        }
        db.close();
        cursor.close();
        return canvas;
    }
}
