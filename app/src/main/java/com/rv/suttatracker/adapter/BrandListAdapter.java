package com.rv.suttatracker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rv.suttatracker.Model.BrandsModel;
import com.rv.suttatracker.R;

import java.util.ArrayList;

public class BrandListAdapter extends BaseAdapter {
    ArrayList<BrandsModel> brandlist;
    Context context;

    public BrandListAdapter (Context context, ArrayList<BrandsModel> brandlist){
        this.brandlist = brandlist;
        this.context = context;
    }


    @Override
    public int getCount() {
        return brandlist.size();
    }

    @Override
    public Object getItem(int position) {
        return brandlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_row_brand, null);
        TextView tvbrand = v.findViewById(R.id.tvbrand);
        tvbrand.setText(brandlist.get(position).getBrand_name());
        return v;
    }
}
