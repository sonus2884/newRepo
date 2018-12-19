package com.example.user.newapplication.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.newapplication.R;
import com.example.user.newapplication.ViewPagerAdapter;

public class RadioFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private View view;

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

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewpager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.AddFragment(new FeaturedFragment(), "FEATURED");
        adapter.AddFragment(new ArtistFragment(), "ARTIST");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

}
