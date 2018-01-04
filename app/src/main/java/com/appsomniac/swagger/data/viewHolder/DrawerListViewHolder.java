package com.appsomniac.swagger.data.viewHolder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.data.model.Drawer;
import com.appsomniac.swagger.data.model.TodayBookingsHome;
import com.appsomniac.swagger.fragment.HomeFragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

/**
 * Created by absolutelysaurabh on 21/12/17.
 */

public class DrawerListViewHolder extends RecyclerView.ViewHolder {

   public ImageView drawerIcon;
    public TextView drawerTitle;
    private Context mContext;
    public int single_position;
    public ArrayList<Drawer> al_drawers;

    public DrawerListViewHolder(LayoutInflater from, ViewGroup viewGroup, int position, ArrayList<Drawer> al_drawers, final Context context) {
        super(from.inflate(R.layout.drawer_lists, viewGroup, false));

        //this.tvTitle = itemView.findViewById(R.id.media_title);
        this.drawerIcon = itemView.findViewById(R.id.drawer_icon);
        this.drawerTitle = itemView.findViewById(R.id.drawer_title);
        this.mContext = context;
        this.al_drawers = al_drawers;
        this.single_position = position;
    }
}
