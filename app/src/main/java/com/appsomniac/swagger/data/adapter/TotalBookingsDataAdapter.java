package com.appsomniac.swagger.data.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.appsomniac.swagger.data.model.Bookings.TotalBookingsHome;
import com.appsomniac.swagger.data.viewHolder.TotalBookingViewHolder;

import java.util.ArrayList;

public class TotalBookingsDataAdapter extends RecyclerView.Adapter<TotalBookingViewHolder> {

    private ArrayList<TotalBookingsHome> totalBookingsList;
    private Context mContext;
    public static String EXTRA_MESSAGE = "";

    public TotalBookingsDataAdapter(Context context, ArrayList<TotalBookingsHome> totalBookingsList) {
        this.totalBookingsList = totalBookingsList;
        this.mContext = context;
    }

    @Override
    public TotalBookingViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {

        return new TotalBookingViewHolder(LayoutInflater.from(viewGroup.getContext()), viewGroup, position, totalBookingsList);

    }

    @Override
    public void onBindViewHolder(TotalBookingViewHolder holder, int position) {

        holder.bookingNumber.setText(totalBookingsList.get(position).getNumber());
        holder.bookingTitle.setText(totalBookingsList.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return (null != totalBookingsList ? totalBookingsList.size() : 0);
    }
}