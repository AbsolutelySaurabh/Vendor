package com.appsomniac.swagger.data.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.data.model.LiveStatus.LiveStatusVacantOccupied;

import java.util.ArrayList;

/**
 * Created by absolutelysaurabh on 22/12/17.
 */
public class LiveStatusVacantOrOccupiedViewHolder extends RecyclerView.ViewHolder {

    public TextView number;
    public TextView vacant_or_occupied;

    public LiveStatusVacantOrOccupiedViewHolder(LayoutInflater from, ViewGroup viewGroup, int position, ArrayList<LiveStatusVacantOccupied> al_live_status_vacant_or_occupied) {
        super(from.inflate(R.layout.item_live_status_vacant_or_occupied, viewGroup, false));

        //this.tvTitle = itemView.findViewById(R.id.media_title);
        this.number = itemView.findViewById(R.id.live_status_vacant_occupied_number);
        this.vacant_or_occupied = itemView.findViewById(R.id.live_status_vacant_occupied);

    }
}
