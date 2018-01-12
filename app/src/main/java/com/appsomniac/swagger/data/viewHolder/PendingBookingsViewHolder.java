package com.appsomniac.swagger.data.viewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.data.model.Bookings.Bookings;
import com.appsomniac.swagger.data.model.Bookings.PopUpPendingBookings;

import java.util.ArrayList;

/**
 * Created by absolutelysaurabh on 22/12/17.
 */
public class PendingBookingsViewHolder extends RecyclerView.ViewHolder {

    public TextView guest_name;
    public TextView date;
    public TextView time;
    public TextView amount;
    public TextView services;
    public Context context;

    public PendingBookingsViewHolder(LayoutInflater from, ViewGroup viewGroup, int position, ArrayList<Bookings> pendingBookingsList, final Context context) {
        super(from.inflate(R.layout.item_pending_bookings, viewGroup, false));

        //this.tvTitle = itemView.findViewById(R.id.media_title);
        this.guest_name = itemView.findViewById(R.id.pending_bookings_guest_name);
        this.date = itemView.findViewById(R.id.pending_bookings_date);
        this.time = itemView.findViewById(R.id.pending_bookings_time);
        this.amount = itemView.findViewById(R.id.pending_bookings_amount_to_collect);
        this.services = itemView.findViewById(R.id.pending_bookings_services);
        this.context = context;

    }

    public ArrayList<PopUpPendingBookings> generatePopUpData(ArrayList<PopUpPendingBookings> al_pop_urp_pending_bookings, int position){

        al_pop_urp_pending_bookings.get(position).setSetviceName("Hair Cut");
        al_pop_urp_pending_bookings.get(position).setServiceAmount("400");
        al_pop_urp_pending_bookings.get(position).setSetviceName("Nakhun Cut");
        al_pop_urp_pending_bookings.get(position).setServiceAmount("800");
        al_pop_urp_pending_bookings.get(position).setSetviceName("Spa");
        al_pop_urp_pending_bookings.get(position).setServiceAmount("900");
        return al_pop_urp_pending_bookings;
    }
}
