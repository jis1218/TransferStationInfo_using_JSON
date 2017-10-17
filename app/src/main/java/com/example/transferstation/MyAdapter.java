package com.example.transferstation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.transferstation.model.Row;

import java.util.ArrayList;

/**
 * Created by 정인섭 on 2017-10-17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    ArrayList<Row> list;
    public MyAdapter(ArrayList<Row> list) {
        this.list = list;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.tvNo.setText(list.get(position).getSN());
        holder.tvStation.setText(list.get(position).getSTATN_NM());
        holder.tvWeekday.setText(list.get(position).getWKDAY());
        holder.tvSaturday.setText(list.get(position).getSATDAY());
        holder.tvSunday.setText(list.get(position).getSUNDAY());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView tvNo, tvStation, tvWeekday, tvSaturday, tvSunday;
        public Holder(View itemView) {
            super(itemView);
            tvNo = itemView.findViewById(R.id.tvNo);
            tvStation = itemView.findViewById(R.id.tvStation);
            tvWeekday = itemView.findViewById(R.id.tvWeekday);
            tvSaturday = itemView.findViewById(R.id.tvSaturday);
            tvSunday = itemView.findViewById(R.id.tvSunday);
        }
    }
}
