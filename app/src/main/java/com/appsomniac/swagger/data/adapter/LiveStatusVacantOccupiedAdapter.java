package com.appsomniac.swagger.data.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.appsomniac.swagger.data.model.LiveStatus.LiveStatusVacantOccupied;
import com.appsomniac.swagger.data.viewHolder.LiveStatusVacantOrOccupiedViewHolder;

import java.util.ArrayList;

public class LiveStatusVacantOccupiedAdapter extends RecyclerView.Adapter<LiveStatusVacantOrOccupiedViewHolder> {

    private ArrayList<LiveStatusVacantOccupied> al_live_status_vacant_or_occupied;
    private Context mContext;
    public static String EXTRA_MESSAGE = "";

    public LiveStatusVacantOccupiedAdapter(Context context, ArrayList<LiveStatusVacantOccupied> al_live_status_vacant_or_occupied) {
        this.al_live_status_vacant_or_occupied = al_live_status_vacant_or_occupied;
        this.mContext = context;
    }

    @Override
    public LiveStatusVacantOrOccupiedViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {

        return new LiveStatusVacantOrOccupiedViewHolder(LayoutInflater.from(viewGroup.getContext()), viewGroup, position, al_live_status_vacant_or_occupied);

    }

    @Override
    public void onBindViewHolder(LiveStatusVacantOrOccupiedViewHolder holder, int position) {

        holder.number.setText(al_live_status_vacant_or_occupied.get(position).getNumber());
        holder.vacant_or_occupied.setText(al_live_status_vacant_or_occupied.get(position).getVacantOrOccupied());
    }

    @Override
    public int getItemCount() {
        return (null != al_live_status_vacant_or_occupied ? al_live_status_vacant_or_occupied.size() : 0);
    }
}