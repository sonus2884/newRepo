package com.example.user.newapplication.Fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.newapplication.R;

import java.util.ArrayList;
import java.util.List;

public class FeaturedFragment extends Fragment {


    private View view;

    private RecyclerView recyclerView;

    private List<String> movieList;
    private StoreAdapter mAdapter;

    public FeaturedFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.featured_fragment, container, false);


        mAdapter = new StoreAdapter(getActivity(), movieList);
        movieList = new ArrayList<>();

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(8), true));

        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        return view;

    }

    private int dpToPx(int dp) {

        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view);
            int column = position % spanCount;

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount;
                outRect.right = (column + 1) * spacing / spanCount;

                if (position < spanCount) {
                    outRect.top = spacing;
                }
                outRect.bottom = spacing;
            } else {
                outRect.left = column * spacing / spanCount;
                outRect.right = spacing - (column + 1) * spacing / spanCount;
                if (position >= spanCount) {
                    outRect.top = spacing;
                }
            }
        }
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
        public StoreAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.home_item_row, viewGroup, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull StoreAdapter.MyViewHolder holder, int position) {

            holder.songName.setText("Name");
            holder.songTitle.setText("Title");


        }

        @Override
        public int getItemCount() {

            return 6;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView songName;
            public TextView songTitle;
            public ImageView songImage;
            public ImageView radioIcon;

            public MyViewHolder(View view) {
                super(view);
                songName = view.findViewById(R.id.songName);
                songTitle = view.findViewById(R.id.songTitle);
                songImage = view.findViewById(R.id.songPic);
                radioIcon = view.findViewById(R.id.radioIcon);
            }

        }
    }
}
