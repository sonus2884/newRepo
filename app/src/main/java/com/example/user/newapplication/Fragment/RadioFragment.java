package com.example.user.newapplication.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.newapplication.R;
import com.example.user.newapplication.ViewPagerAdapter;

public class RadioFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private View view;
    private ViewPagerAdapter adapter;

    public RadioFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.radio_fragment, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        getActivity().setTitle("Radio");

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewpager);

        adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.AddFragment(new FeaturedFragment(), "FEATURED");
        adapter.AddFragment(new ArtistFragment(), "ARTIST");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

}
