package com.appsomniac.swagger.data.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.appsomniac.swagger.data.model.Bookings.PopUpPendingBookings;
import com.appsomniac.swagger.data.viewHolder.PopUpViewHolderPendingBookings;

import java.util.ArrayList;

public class PopUpAdapterPendingBookings extends RecyclerView.Adapter<PopUpViewHolderPendingBookings> {

    private ArrayList<PopUpPendingBookings> popUpServicesList;
    private Context mContext;
    public static String EXTRA_MESSAGE = "";

    public PopUpAdapterPendingBookings(Context context, ArrayList<PopUpPendingBookings> popUpServicesList) {
        this.popUpServicesList = popUpServicesList;
        this.mContext = context;
    }

    @Override
    public PopUpViewHolderPendingBookings onCreateViewHolder(ViewGroup viewGroup, int position) {

        return new PopUpViewHolderPendingBookings(LayoutInflater.from(viewGroup.getContext()), viewGroup, position, popUpServicesList, mContext);

    }

    @Override
    public void onBindViewHolder(PopUpViewHolderPendingBookings holder, int position) {

        PopUpPendingBookings singleItem = popUpServicesList.get(position);

        holder.service_name.setText(popUpServicesList.get(position).getBooking_service());
        holder.service_amount.setText(popUpServicesList.get(position).getBooking_amount());

    }

    @Override
    public int getItemCount() {
        return (null != popUpServicesList ? popUpServicesList.size() : 0);
    }
}