package com.appsomniac.swagger.data.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.data.model.TodayBookingsHome;

import java.util.ArrayList;

/**
 * Created by absolutelysaurabh on 21/12/17.
 */

public class TodayBookingViewHolder extends RecyclerView.ViewHolder {

    public TextView bookingNumber;
    public TextView bookingTitle;

    public TodayBookingViewHolder(LayoutInflater from, ViewGroup viewGroup, int position, ArrayList<TodayBookingsHome> todayBookingsList) {
        super(from.inflate(R.layout.today_bookings_single_card, viewGroup, false));

        //this.tvTitle = itemView.findViewById(R.id.media_title);
        this.bookingNumber = itemView.findViewById(R.id.today_bookings_number);
        this.bookingTitle = itemView.findViewById(R.id.today_bookings_title);

    }
}
