package com.appsomniac.swagger.data.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.base.MainActivity;
import com.appsomniac.swagger.data.model.Drawer;
import com.appsomniac.swagger.data.viewHolder.DrawerListViewHolder;
import com.appsomniac.swagger.fragment.BookingsFragment;
import com.appsomniac.swagger.fragment.EnquiryFragment;
import com.appsomniac.swagger.fragment.HomeFragment;
import com.appsomniac.swagger.fragment.LiveStatusFragment;
import com.appsomniac.swagger.login.LoginActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class DrawerListAdapter extends RecyclerView.Adapter<DrawerListViewHolder> {

    private ArrayList<Drawer> al_drawers;
    private Context mContext;
    public static String EXTRA_MESSAGE = "";
    public MainActivity activity;
    public int selected_position = 0;
    //fragment tags
    public static String TAG = "Home";

    public DrawerListAdapter(Context context, ArrayList<Drawer> al_drawers, MainActivity activity) {
        this.al_drawers = al_drawers;
        this.mContext = context;
        this.activity = activity;
    }

    @Override
    public DrawerListViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {

        return new DrawerListViewHolder(LayoutInflater.from(viewGroup.getContext()), viewGroup, position, al_drawers, mContext);

    }

    @Override
    public void onBindViewHolder(final DrawerListViewHolder holder, final int position) {

        if(position == 0){

            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.home);
            requestOptions.error(R.drawable.home);

            Glide.with(mContext).asBitmap().load(Integer.parseInt(al_drawers.get(position).getImageUrl()))
                    .apply(requestOptions).thumbnail(0.5f).into(holder.drawerIcon);

            holder.drawerTitle.setTextColor(Color.parseColor(al_drawers.get(position).getTextColour()));

        }else
            if(position == 1){

                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(R.drawable.calendar_grey);
                requestOptions.error(R.drawable.calendar_grey);

                Glide.with(mContext).asBitmap().load(Integer.parseInt(al_drawers.get(position).getImageUrl()))
                        .apply(requestOptions).thumbnail(0.5f).into(holder.drawerIcon);
                holder.drawerTitle.setTextColor(Color.parseColor(al_drawers.get(position).getTextColour()));

            }else
                if(position == 2){
                    RequestOptions requestOptions = new RequestOptions();
                    requestOptions.placeholder(R.drawable.live_grey);
                    requestOptions.error(R.drawable.live_grey);

                    Glide.with(mContext).asBitmap().load(Integer.parseInt(al_drawers.get(position).getImageUrl()))
                            .apply(requestOptions).thumbnail(0.5f).into(holder.drawerIcon);
                    holder.drawerTitle.setTextColor(Color.parseColor(al_drawers.get(position).getTextColour()));


                }else
                    if(position == 3){

                        RequestOptions requestOptions = new RequestOptions();
                        requestOptions.placeholder(R.drawable.enquiry_grey);
                        requestOptions.error(R.drawable.enquiry_grey);

                        Glide.with(mContext).asBitmap().load(Integer.parseInt(al_drawers.get(position).getImageUrl()))
                                .apply(requestOptions).thumbnail(0.5f).into(holder.drawerIcon);
                        holder.drawerTitle.setTextColor(Color.parseColor(al_drawers.get(position).getTextColour()));

                    }

        holder.drawerTitle.setText(al_drawers.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction() ;
                if(position == 0){

                    TAG = "Home";

                    al_drawers.get(0).setImageUrl(String.valueOf(R.drawable.home));
                    al_drawers.get(1).setImageUrl(String.valueOf(R.drawable.calendar_grey));
                    al_drawers.get(2).setImageUrl(String.valueOf(R.drawable.live_grey));
                    al_drawers.get(3).setImageUrl(String.valueOf(R.drawable.enquiry_grey));

                    al_drawers.get(0).setTextColour("#FFFFFF");
                    al_drawers.get(1).setTextColour("#90A4AE");
                    al_drawers.get(2).setTextColour("#90A4AE");
                    al_drawers.get(3).setTextColour("#90A4AE");

                    // Updating old as well as new positions
                    notifyItemChanged(selected_position);
                    selected_position = position;
                    notifyItemChanged(selected_position);

                    HomeFragment homeFragment = new HomeFragment();
                    fragmentTransaction.replace(R.id.framelayout_right, homeFragment, TAG);
                    fragmentTransaction.commit();

                    //changin icon to white
                    RequestOptions requestOptions = new RequestOptions();
                    requestOptions.placeholder(R.drawable.home);
                    requestOptions.error(R.drawable.home);

                    Glide.with(mContext).asBitmap().load(Integer.parseInt(al_drawers.get(0).getImageUrl()))
                            .apply(requestOptions).thumbnail(0.5f).into(holder.drawerIcon);
                    holder.drawerTitle.setTextColor(Color.parseColor(al_drawers.get(position).getTextColour()));

                    notifyDataSetChanged();

                }else
                    if(position == 1){

                        TAG = "Bookings";

                        al_drawers.get(1).setImageUrl(String.valueOf(R.drawable.calendar));
                        al_drawers.get(0).setImageUrl(String.valueOf(R.drawable.home_grey));
                        al_drawers.get(2).setImageUrl(String.valueOf(R.drawable.live_grey));
                        al_drawers.get(3).setImageUrl(String.valueOf(R.drawable.enquiry_grey));


                        al_drawers.get(1).setTextColour("#FFFFFF");
                        al_drawers.get(3).setTextColour("#90A4AE");
                        al_drawers.get(2).setTextColour("#90A4AE");
                        al_drawers.get(0).setTextColour("#90A4AE");

                        // Updating old as well as new positions
                        notifyItemChanged(selected_position);
                        selected_position = position;
                        notifyItemChanged(selected_position);

                        BookingsFragment bookingsFragment = new BookingsFragment();
                        fragmentTransaction.replace(R.id.framelayout_right, bookingsFragment, TAG);
                        fragmentTransaction.commit();

                        //changin icon to white
                        RequestOptions requestOptions = new RequestOptions();
                        requestOptions.placeholder(R.drawable.calendar);
                        requestOptions.error(R.drawable.calendar);

                        Glide.with(mContext).asBitmap().load(Integer.parseInt(al_drawers.get(1).getImageUrl()))
                                .apply(requestOptions).thumbnail(0.5f).into(holder.drawerIcon);

                        //changing text colour
                        holder.drawerTitle.setTextColor(Color.parseColor(al_drawers.get(position).getTextColour()));

                        notifyDataSetChanged();

                    }else
                        if(position == 2){

                            TAG = "LiveStatus";

                            al_drawers.get(2).setImageUrl(String.valueOf(R.drawable.live));
                            al_drawers.get(0).setImageUrl(String.valueOf(R.drawable.home_grey));
                            al_drawers.get(1).setImageUrl(String.valueOf(R.drawable.calendar_grey));
                            al_drawers.get(3).setImageUrl(String.valueOf(R.drawable.enquiry_grey));


                            al_drawers.get(2).setTextColour("#FFFFFF");
                            al_drawers.get(1).setTextColour("#90A4AE");
                            al_drawers.get(3).setTextColour("#90A4AE");
                            al_drawers.get(0).setTextColour("#90A4AE");

                            // Updating old as well as new positions
                            notifyItemChanged(selected_position);
                            selected_position = position;
                            notifyItemChanged(selected_position);

                            LiveStatusFragment liveStatusFragment = new LiveStatusFragment();
                            fragmentTransaction.replace(R.id.framelayout_right, liveStatusFragment, TAG);
                            fragmentTransaction.commit();

                            //changin icon to white
                            RequestOptions requestOptions = new RequestOptions();
                            requestOptions.placeholder(R.drawable.live);
                            requestOptions.error(R.drawable.live);

                            Glide.with(mContext).asBitmap().load(Integer.parseInt(al_drawers.get(2).getImageUrl()))
                                    .apply(requestOptions).thumbnail(0.5f).into(holder.drawerIcon);

                            //changing text colour
                            holder.drawerTitle.setTextColor(Color.parseColor(al_drawers.get(position).getTextColour()));

                            notifyDataSetChanged();


                        }else
                            if(position == 3){

                                TAG = "EnquiryData";

                                al_drawers.get(3).setImageUrl(String.valueOf(R.drawable.enquiry));
                                al_drawers.get(1).setImageUrl(String.valueOf(R.drawable.calendar_grey));
                                al_drawers.get(2).setImageUrl(String.valueOf(R.drawable.live_grey));
                                al_drawers.get(0).setImageUrl(String.valueOf(R.drawable.home_grey));

                                al_drawers.get(3).setTextColour("#FFFFFF");
                                al_drawers.get(1).setTextColour("#90A4AE");
                                al_drawers.get(2).setTextColour("#90A4AE");
                                al_drawers.get(0).setTextColour("#90A4AE");

                                //000000
                                // Updating old as well as new positions
                                notifyItemChanged(selected_position);
                                selected_position = position;
                                notifyItemChanged(selected_position);

                                EnquiryFragment enquiryFragment = new EnquiryFragment();
                                fragmentTransaction.replace(R.id.framelayout_right, enquiryFragment, TAG);
                                fragmentTransaction.commit();

                                //changin icon to white
                                RequestOptions requestOptions = new RequestOptions();
                                requestOptions.placeholder(R.drawable.enquiry);
                                requestOptions.error(R.drawable.enquiry);

                                Glide.with(mContext).asBitmap().load(Integer.parseInt(al_drawers.get(3).getImageUrl()))
                                        .apply(requestOptions).thumbnail(0.5f).into(holder.drawerIcon);

                                //changing text colour
                                holder.drawerTitle.setTextColor(Color.parseColor(al_drawers.get(position).getTextColour()));

                                notifyDataSetChanged();

                            }else
                                if(position == 4){

                                    SharedPreferences.Editor prefs_vendor_details = mContext.getSharedPreferences("VENDOR_DETAILS", MODE_PRIVATE).edit();
                                    prefs_vendor_details.clear();
                                    mContext.startActivity(new Intent(mContext, LoginActivity.class));
                                    ((Activity)mContext).finish();
                                    prefs_vendor_details.apply();

                                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != al_drawers ? al_drawers.size() : 0);
    }
}