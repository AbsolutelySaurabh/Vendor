package com.appsomniac.swagger.data.viewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.data.model.Bookings.Bookings;

import java.util.ArrayList;

/**
 * Created by absolutelysaurabh on 22/12/17.
 */

public class CompletedBookingsViewHolder extends RecyclerView.ViewHolder {

    public TextView guest_name;
    public TextView date;
    public TextView time;
    public TextView amount;
    public TextView feedback;
    private Context context;

    public CompletedBookingsViewHolder(LayoutInflater from, ViewGroup viewGroup, int position, ArrayList<Bookings> completedBookingsList, final Context context) {
        super(from.inflate(R.layout.item_completed_bookings, viewGroup, false));

        this.context = context;
        //this.tvTitle = itemView.findViewById(R.id.media_title);
        this.guest_name = itemView.findViewById(R.id.completed_bookings_guest_name);
        this.date = itemView.findViewById(R.id.completed_bookings_date);
        this.time = itemView.findViewById(R.id.completed_bookings_time);
        this.amount = itemView.findViewById(R.id.completed_bookings_amount_collected);
        this.feedback = itemView.findViewById(R.id.completed_bookings_feedback);

    }
}
