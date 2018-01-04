package com.appsomniac.swagger.data.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.data.model.LiveStatusStartBooking;
import com.appsomniac.swagger.data.model.PendingBookings;
import com.appsomniac.swagger.data.model.TodayBookingsHome;

import java.util.ArrayList;

/**
 * Created by absolutelysaurabh on 22/12/17.
 */
public class LiveStatusStartBookingViewHolder extends RecyclerView.ViewHolder {

    public TextView guest_name;
    public TextView date;
    public TextView time;
    public TextView amount;
    public TextView start_booking;

    public LiveStatusStartBookingViewHolder(LayoutInflater from, ViewGroup viewGroup, int position, ArrayList<LiveStatusStartBooking> al_live_status_start_booking) {
        super(from.inflate(R.layout.item_live_status_start_booking, viewGroup, false));

        //this.tvTitle = itemView.findViewById(R.id.media_title);
        this.guest_name = itemView.findViewById(R.id.live_status_user_name);
        this.date = itemView.findViewById(R.id.live_status_date);
        this.time = itemView.findViewById(R.id.live_status_time);
        this.amount = itemView.findViewById(R.id.live_status_amount);
        this.start_booking = itemView.findViewById(R.id.live_status_start_booking_button);
    }
}
