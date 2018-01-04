package com.appsomniac.swagger.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.base.MainActivity;
import com.appsomniac.swagger.data.adapter.TodayBookingsDataAdapter;
import com.appsomniac.swagger.data.model.Drawer;
import com.appsomniac.swagger.data.adapter.DrawerListAdapter;

import java.util.ArrayList;
import java.util.List;

public class DrawerListFragment extends Fragment {

    OnFragmentInteractionListener listener;
    View drawerFragment;
    public DrawerListFragment(){
        return;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        drawerFragment = inflater.inflate(R.layout.fragment_drawer_list,null);
        return drawerFragment;


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setDrawer();

        //ListView animalListView = (ListView) view.findViewById(android.R.id.recyclerView_drawer);
//        DrawerListAdapter drawerListAdapter = new DrawerListAdapter(getActivity(),generateDrawerList());
//        animalListView.setAdapter(drawerListAdapter);

        //animalListView.setOnItemClickListener(onAnimalListViewItemClickListener);

    }

    public void setDrawer(){

        RecyclerView drawer_recycler_view = drawerFragment.findViewById(R.id.recyclerView_drawer);

        DrawerListAdapter drawerListAdapter = new DrawerListAdapter(getContext(),generateDrawerList(), (MainActivity) getActivity());
        drawer_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        drawer_recycler_view.setAdapter(drawerListAdapter);
        drawer_recycler_view.setHasFixedSize(true);
        drawer_recycler_view.setNestedScrollingEnabled(true);

    }

    AdapterView.OnItemClickListener onAnimalListViewItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Drawer animal = (Drawer)adapterView.getItemAtPosition(i);
            if(listener!=null)
                listener.onAnimalSelected(animal);
        }
    };

    private ArrayList<Drawer> generateDrawerList(){
        ArrayList<Drawer> al_drawers = new ArrayList<Drawer>(10);

        Drawer drawer_1 = new Drawer();
        drawer_1.setName("Home");
        drawer_1.setImageUrl(String.valueOf(R.drawable.home));
        drawer_1.setTextColour("#FFFFFF");
        al_drawers.add(drawer_1);

        Drawer drawer_2 = new Drawer();
        drawer_2.setName("Bookings");
        drawer_2.setTextColour("#90A4AE");
        drawer_2.setImageUrl(String.valueOf(R.drawable.calendar_grey));
        al_drawers.add(drawer_2);

        Drawer drawer_3 = new Drawer();
        drawer_3.setName("Live Status");
        drawer_3.setTextColour("#90A4AE");
        drawer_3.setImageUrl(String.valueOf(R.drawable.live_grey));
        al_drawers.add(drawer_3);

        Drawer drawer_4 = new Drawer();
        drawer_4.setName("Enquiry");
        drawer_4.setTextColour("#90A4AE");
        drawer_4.setImageUrl(String.valueOf(R.drawable.enquiry_grey));
        al_drawers.add(drawer_4);

        return al_drawers;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof  OnFragmentInteractionListener){
            listener = (OnFragmentInteractionListener) activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface OnFragmentInteractionListener {
        public void onAnimalSelected(Drawer animal);
    }
}