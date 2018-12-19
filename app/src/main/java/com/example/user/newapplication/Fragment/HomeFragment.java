package com.example.user.newapplication.Fragment;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.newapplication.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;

    private List<String> movieList;
    private StoreAdapter mAdapter;

    public HomeFragment() {


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.home_fragment, container, false);

        mAdapter = new StoreAdapter(getActivity(), movieList);
        movieList = new ArrayList<>();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView = view.findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        return view;
    }


    class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {

        private Context context;
        private List<String> movieList;

        public StoreAdapter(Context context, List<String> movieList) {
            this.context = context;
            this.movieList = movieList;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.home_item_row, viewGroup, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            holder.songName.setText("Name");
            holder.songTitle.setText("Title");



        }

        @Override
        public int getItemCount() {

            return 4;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView songName;
            public TextView songTitle;
            public ImageView songImage;


            public MyViewHolder(View view) {
                super(view);
                songName = view.findViewById(R.id.songName);
                songTitle = view.findViewById(R.id.songTitle);
                songImage = view.findViewById(R.id.songPic);

            }

        }
    }
}
