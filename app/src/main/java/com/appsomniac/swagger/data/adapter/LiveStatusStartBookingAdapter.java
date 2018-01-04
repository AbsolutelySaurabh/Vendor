package com.appsomniac.swagger.data.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appsomniac.swagger.data.model.LiveStatusStartBooking;
import com.appsomniac.swagger.data.model.TodayBookingsHome;
import com.appsomniac.swagger.data.model.TotalBookingsHome;
import com.appsomniac.swagger.data.viewHolder.LiveStatusStartBookingViewHolder;
import com.appsomniac.swagger.data.viewHolder.TodayBookingViewHolder;
import com.appsomniac.swagger.data.viewHolder.TotalBookingViewHolder;

import java.util.ArrayList;

public class LiveStatusStartBookingAdapter extends RecyclerView.Adapter<LiveStatusStartBookingViewHolder> {

    private ArrayList<LiveStatusStartBooking> al_live_status_start_booking;
    private Context mContext;
    public static String EXTRA_MESSAGE = "";

    public LiveStatusStartBookingAdapter(Context context, ArrayList<LiveStatusStartBooking> al_live_status_start_booking) {
        this.al_live_status_start_booking = al_live_status_start_booking;
        this.mContext = context;
    }

    @Override
    public LiveStatusStartBookingViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {

        return new LiveStatusStartBookingViewHolder(LayoutInflater.from(viewGroup.getContext()), viewGroup, position, al_live_status_start_booking);

    }

    @Override
    public void onBindViewHolder(LiveStatusStartBookingViewHolder holder, int position) {

        holder.guest_name.setText(al_live_status_start_booking.get(position).getName());
        holder.date.setText(al_live_status_start_booking.get(position).getDate());
        holder.time.setText(al_live_status_start_booking.get(position).getTime());
        holder.amount.setText(al_live_status_start_booking.get(position).getAmount());

        holder.start_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //empty

            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != al_live_status_start_booking ? al_live_status_start_booking.size() : 0);
    }
}