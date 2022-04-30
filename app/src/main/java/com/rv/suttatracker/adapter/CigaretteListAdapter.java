package com.rv.suttatracker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rv.suttatracker.Model.CigarettesModel;
import com.rv.suttatracker.R;

import java.util.ArrayList;

public class CigaretteListAdapter extends BaseAdapter {
    ArrayList<CigarettesModel> cigarettelist;
    Context context;

    public CigaretteListAdapter(Context context, ArrayList<CigarettesModel> cigarettelist){
        this.cigarettelist = cigarettelist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return cigarettelist.size();
    }

    @Override
    public Object getItem(int position) {
        return cigarettelist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_row_cigarette, null);
        TextView tvcigarrete = v.findViewById(R.id.tvcigarette);
        tvcigarrete.setText(cigarettelist.get(position).getCigerettes_name());
        return v;
    }
}
