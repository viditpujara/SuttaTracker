package com.rv.suttatracker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rv.suttatracker.Model.SmokedModel;
import com.rv.suttatracker.R;

import java.util.ArrayList;

public class ReportListAdapter extends RecyclerView.Adapter<ReportListAdapter.UserViewHolder> {
    Context context;
    ArrayList<SmokedModel> SmokedModelList;

    public ReportListAdapter(Context context,ArrayList<SmokedModel> SmokedModelList){
        this.context = context;
        this.SmokedModelList = SmokedModelList;
    }
    @NonNull
    @Override
    public ReportListAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ReportListAdapter.UserViewHolder(LayoutInflater.from(context).inflate(R.layout.view_row_report_canvas, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ReportListAdapter.UserViewHolder holder, int position) {
        holder.repDate.setText(SmokedModelList.get(position).getS_date());
        holder.repTime.setText(SmokedModelList.get(position).getS_time());
        holder.repCig.setText(SmokedModelList.get(position).getC_name());
        holder.repNec.setText(SmokedModelList.get(position).getNicotine());
        holder.repTrip.setText(SmokedModelList.get(position).getTrip());
        holder.repPrice.setText(SmokedModelList.get(position).getS_price());
        holder.repPlace.setText(SmokedModelList.get(position).getS_place());
    }

    @Override
    public int getItemCount() {
        return SmokedModelList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView repDate, repTime,repCig,repNec,repTrip,repPlace,repPrice;
        public UserViewHolder(@NonNull View v) {
            super(v);
            repDate=v.findViewById(R.id.repDate1);
            repTime=v.findViewById(R.id.repTime1);
            repCig=v.findViewById(R.id.repCig1);
            repNec=v.findViewById(R.id.repNec1);
            repTrip=v.findViewById(R.id.repTrip1);
            repPlace=v.findViewById(R.id.repPlace1);
            repPrice=v.findViewById(R.id.repPrice1);
        }
    }
}
