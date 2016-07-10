package com.juilyoon.discoverwaterloo;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // Set up TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(mViewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // List of locations to display.
            // NOTE: Update String[] title in SectionsPagerAdapter
            ArrayList<Location> locationList = new ArrayList<>();
            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1:
                    // Restaurants
                    Log.v("onCreateView", "Restaurant list loaded.");
                    locationList.add(new Location("Ennio's", 4, "A very nice and romantic Italian restaurant.",
                            "https://www.tripadvisor.ca/Restaurant_Review-g181736-d704123-Reviews-Ennio_s_Pasta_House-Waterloo_Region_of_Waterloo_Ontario.html",
                            "https://goo.gl/maps/NGg2KPGkhoB2",
                            R.drawable.ennios));
                    locationList.add(new Location("Bao Sandwich Bar", 5, "Excellent Vietnamese (bahn mi) and Taiwanese (gua bao) sandwiches.",
                            "https://www.tripadvisor.ca/Restaurant_Review-g181736-d9729136-Reviews-Bao_Sandwich_Bar-Waterloo_Region_of_Waterloo_Ontario.html",
                            "https://goo.gl/maps/DasC8zLv11K2",
                            R.drawable.bao));
                    locationList.add(new Location("Mozy's Shawarma", 4, "Large portion and delicious shawarma sandwiches.",
                            "https://www.tripadvisor.ca/Restaurant_Review-g181736-d4123939-Reviews-Mozy_s_Shawarma-Waterloo_Region_of_Waterloo_Ontario.html",
                            "https://goo.gl/maps/KmwVJpjNWip",
                            R.drawable.mozys));
                    locationList.add(new Location("Mory's Pub", 4, "Chicken wing pub opne late and wing specials.",
                            "https://www.tripadvisor.ca/Restaurant_Review-g181736-d803941-Reviews-Morty_s-Waterloo_Region_of_Waterloo_Ontario.html",
                            "https://goo.gl/maps/yjYtT5jyPnk",
                            R.drawable.mortys));
                    break;
                case 2:
                    // Activities
                    locationList.add(new Location("The Clever Archer", 5, "Paintball, but with bows and arrows!",
                            "http://www.thecleverarcher.com/",
                            "https://goo.gl/maps/hgivSfQQG9S2",
                            R.drawable.clever_archer));
                    locationList.add(new Location("Elora Quarry", 4, "Water, sandy beach, and cliff jumping.",
                            "https://www.tripadvisor.ca/Attraction_Review-g679248-d6650716-Reviews-Elora_Quarry_Conservation_Area-Elora_Ontario.html",
                            "https://goo.gl/maps/wr5hNQdYf9L2",
                            R.drawable.elora_quarry));
                    break;
                case 3:
                    // Attractions
                    locationList.add(new Location("Oktoberfest", 4, "Canada's largest German celebration.",
                            "https://www.facebook.com/kitchenerwaterloooktoberfest/",
                            "http://www.oktoberfest.ca/",
                            R.drawable.oktoberfest));
                    locationList.add(new Location("Elmira Maple Syrup Festival", 5,
                            "A huge festival celebrating maple syrup.",
                            "https://www.facebook.com/ElmiraMapleSyrupFestival/",
                            "http://www.elmiramaplesyrup.com/",
                            R.drawable.elmira));
                    break;
                case 4:
                    // Shopping
                    locationList.add(new Location("St. Jacobs Farmer's Market", 5,
                            "Canada's largest year-round farmer's market.",
                            "https://www.tripadvisor.ca/Attraction_Review-g499298-d2402442-Reviews-St_Jacobs_Farmers_Market-St_Jacobs_Region_of_Waterloo_Ontario.html",
                            "https://goo.gl/maps/R3DuCxGMV9s",
                            R.drawable.stjacobs));
                    locationList.add(new Location("Nike Factory Store", 5,
                            "Nike shoes and clothing at the lowest prices you'll find anywhere.",
                            "https://www.google.ca/search?q=Nike+Factory+Store,+4326+King+St+E,+Kitchener,+ON+N2P+2G5&ludocid=8493271779053122037#lrd=0x882b8a42e3496bbb:0x75de29af0b4fb1f5,1",
                            "https://goo.gl/maps/WBxPoKa5To22",
                            R.drawable.nike));
                    break;
            }


            LocationArrayAdapter locationAdapter = new LocationArrayAdapter(getActivity(), locationList);
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            ListView listView = (ListView) rootView.findViewById(R.id.location_list);
            listView.setAdapter(locationAdapter);
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private String[] title = new String[]{"Restaurants", "Activities", "Attractions", "Shopping"};

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}
