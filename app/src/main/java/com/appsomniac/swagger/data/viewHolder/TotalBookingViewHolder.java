package com.appsomniac.swagger.data.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.data.model.TotalBookingsHome;

import java.util.ArrayList;

/**
 * Created by absolutelysaurabh on 21/12/17.
 */

public class TotalBookingViewHolder extends RecyclerView.ViewHolder {

    public TextView bookingNumber;
    public TextView bookingTitle;

    public TotalBookingViewHolder(LayoutInflater from, ViewGroup viewGroup, int position, ArrayList<TotalBookingsHome> totalBookingsList) {
        super(from.inflate(R.layout.total_bookings_single_card, viewGroup, false));

        //this.tvTitle = itemView.findViewById(R.id.media_title);
        this.bookingNumber = itemView.findViewById(R.id.today_bookings_number);
        this.bookingTitle = itemView.findViewById(R.id.today_bookings_title);
    }
}
