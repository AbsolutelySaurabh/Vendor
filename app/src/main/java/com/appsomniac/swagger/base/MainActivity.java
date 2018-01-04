package com.appsomniac.swagger.base;

import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.data.model.Drawer;
import com.appsomniac.swagger.fragment.BookingsFragment;
import com.appsomniac.swagger.fragment.EnquiryFragment;
import com.appsomniac.swagger.fragment.HomeFragment;
import com.appsomniac.swagger.fragment.DrawerListFragment;
import com.appsomniac.swagger.fragment.LiveStatusFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerListFragment.OnFragmentInteractionListener {

    protected DrawerLayout drawerLayout;
    protected Toolbar actionBar;
    //fragment tags
    public static String TAG = "Home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null)
            return;

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Drawer animal = new Drawer();
        animal.setName("Penguin");
        animal.setImageUrl("http://www.emperor-penguin.com/penguin-chick.jpg");
        animal.setDescription("Penguin Penguin Penguin Penguin Penguin Penguin Penguin Penguin Penguin Penguin Penguin Penguin Penguin ");

        Bundle bundle = new Bundle();
        bundle.putSerializable("animal",animal);

        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setArguments(bundle);

        fragmentTransaction.add(R.id.framelayout_right, homeFragment);

        if(findViewById(R.id.framelayout_left)!=null){

            DrawerListFragment animalListFragment = new DrawerListFragment();
            Toast.makeText(getApplicationContext(), "This is Tablet Layout!", Toast.LENGTH_LONG).show();

            fragmentTransaction.add(R.id.framelayout_left,animalListFragment);

        }else{
            setUi();
            Toast.makeText(getApplicationContext(), "This is Phone Layout!",
                    Toast.LENGTH_LONG).show();
        }

        fragmentTransaction.commit();
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction() ;
        int id = item.getItemId();

        if(id == R.id.nav_drawer_home){
            TAG = "Home";
            HomeFragment homeFragment = new HomeFragment();
            fragmentTransaction.replace(R.id.framelayout_right, homeFragment, TAG);
            fragmentTransaction.commit();

        }else
        if(id == R.id.nav_drawer_bookings){

            TAG = "Bookings";
            BookingsFragment bookingsFragment = new BookingsFragment();
            fragmentTransaction.replace(R.id.framelayout_right, bookingsFragment, TAG);
            fragmentTransaction.commit();

        }else
        if(id==R.id.nav_drawer_live_status){

            TAG = "LiveStatus";
            LiveStatusFragment liveStatusFragment = new LiveStatusFragment();
            fragmentTransaction.replace(R.id.framelayout_right, liveStatusFragment, TAG);
            fragmentTransaction.commit();

        }else
        if(id==R.id.nav_drawer_enquiry){

            TAG = "Enquiry";
            EnquiryFragment enquiryFragment = new EnquiryFragment();
            fragmentTransaction.replace(R.id.framelayout_right, enquiryFragment, TAG);
            fragmentTransaction.commit();

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

//    private void setActionBar() {
//
//        actionBar = (Toolbar) findViewById(R.id.actionBar);
//        //actionBar.setTitle("Swagger");
//        setSupportActionBar(actionBar);
//    }

    private void setDrawer() {

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        //ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                //this, drawerLayout, actionBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //drawerLayout.setDrawerListener(toggle);
        //toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void setUi() {
        //setActionBar();
        setDrawer();
    }

    @Override
    public void onAnimalSelected(Drawer animal) {

    }
}
