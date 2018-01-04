package com.appsomniac.swagger.data.viewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.data.model.PopUpPendingBookings;

import java.util.ArrayList;

/**
 * Created by absolutelysaurabh on 26/12/17.
 */

public class PopUpViewHolderPendingBookings  extends RecyclerView.ViewHolder {

    public TextView service_name;
    public TextView service_amount;
    public Context context;

    public PopUpViewHolderPendingBookings(LayoutInflater from, ViewGroup viewGroup, int position, ArrayList<PopUpPendingBookings> popUpServicesList, final Context context) {
        super(from.inflate(R.layout.item_custom_pop_up_pending_bookings, viewGroup, false));

        //this.tvTitle = itemView.findViewById(R.id.media_title);
        this.service_name = itemView.findViewById(R.id.pop_service_text);
        this.service_amount = itemView.findViewById(R.id.pop_service_amount);
        this.context = context;

    }
}
