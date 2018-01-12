package com.appsomniac.swagger.base;

import android.content.Intent;
import android.content.SharedPreferences;
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
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.data.model.Drawer;
import com.appsomniac.swagger.fragment.BookingsFragment;
import com.appsomniac.swagger.fragment.EnquiryFragment;
import com.appsomniac.swagger.fragment.HomeFragment;
import com.appsomniac.swagger.fragment.DrawerListFragment;
import com.appsomniac.swagger.fragment.LiveStatusFragment;
import com.appsomniac.swagger.login.LoginActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerListFragment.OnFragmentInteractionListener {

    protected DrawerLayout drawerLayout;
    protected Toolbar actionBar;
    private TextView dateText, timeText, store_nameText, store_locationText, person_nameText;
    //fragment tags
    public static String TAG = "Home";
    private ImageView avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null)
            return;

        dateText = findViewById(R.id.date);
        timeText = findViewById(R.id.time);
        store_locationText = findViewById(R.id.store_address);
        store_nameText = findViewById(R.id.store_name);
        person_nameText = findViewById(R.id.user_name);
        avatar = findViewById(R.id.avatar);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();

        fragmentTransaction.add(R.id.framelayout_right, homeFragment);

        if(findViewById(R.id.framelayout_left)!=null){

            DrawerListFragment animalListFragment = new DrawerListFragment();
            fragmentTransaction.add(R.id.framelayout_left,animalListFragment);

        }else{
            setUi();
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

            TAG = "EnquiryData";
            EnquiryFragment enquiryFragment = new EnquiryFragment();
            fragmentTransaction.replace(R.id.framelayout_right, enquiryFragment, TAG);
            fragmentTransaction.commit();

        }else
            if(id == R.id.nav_drawer_logout){

                SharedPreferences.Editor prefs_vendor_details = getSharedPreferences("VENDOR_DETAILS", MODE_PRIVATE).edit();
                prefs_vendor_details.clear();
                prefs_vendor_details.apply();
                startActivity(new Intent(this, LoginActivity.class));
                finish();
            }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setActionBar() {

        actionBar = (Toolbar) findViewById(R.id.actionBar);
        //actionBar.setTitle("Swagger");
        setSupportActionBar(actionBar);

        setDateTime();
        setStoreNameLocation();
        setPersonImage();
        setPersonName();

    }
    public void setStoreNameLocation(){
        SharedPreferences prefs_vendor_details = getSharedPreferences("VENDOR_DETAILS", MODE_PRIVATE);
        String store_name = prefs_vendor_details.getString("store_name", " ");
        String store_location = prefs_vendor_details.getString("store_area", " ");

        store_nameText.setText(store_name);
        store_locationText.setText(store_location);
    }

    public void setPersonImage(){

        String posterBaseUrl = this.getSharedPreferences("VENDOR_DETAILS", MODE_PRIVATE).getString("person_photo", " ");
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.error(R.drawable.ic_account_circle_black_24dp);
        requestOptions.placeholder(R.drawable.ic_account_circle_black_24dp);

        Glide.with(this).load(posterBaseUrl)
                .apply(requestOptions).thumbnail(0.5f).into(avatar);

    }

    public void setPersonName(){
        SharedPreferences prefs_vendor_details = getSharedPreferences("VENDOR_DETAILS", MODE_PRIVATE);
        String person_name = prefs_vendor_details.getString("person_name", " ");
        person_nameText.setText(person_name);
    }

    public void setDateTime(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM, yyyy");
        String formattedDate = dateFormat.format(new Date()).toString();

        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa");
        String formattedTime = timeFormat.format(new Date()).toString();

        dateText.setText(formattedDate);
        timeText.setText(formattedTime);

    }

    private void setDrawer() {

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, actionBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void setUi() {
        setActionBar();
        setDrawer();
    }

    @Override
    public void onAnimalSelected(Drawer animal) {

    }
}
