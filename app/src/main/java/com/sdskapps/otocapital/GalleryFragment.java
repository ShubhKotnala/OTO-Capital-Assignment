package com.sdskapps.otocapital;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.sdskapps.otocapital.adapter.ImageAdapter;

import java.util.ArrayList;

import static android.support.v4.view.PagerAdapter.POSITION_NONE;

public class GalleryFragment extends Fragment {
    private ArrayList<String> images;
    private GridView gallery;

    public static Fragment getInstance() {
        return new GalleryFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gallery = (GridView) view.findViewById(R.id.galleryGridView);
        gallery.setAdapter(new ImageAdapter(getActivity()));

    }


    @Override
    public void setUserVisibleHint(boolean visible) {
        super.setUserVisibleHint(visible);
        if (visible) {

            if (getActivity() != null) {
                ((MainActivity) getActivity()).appBarLayout.setExpanded(true);
                ((MainActivity) getActivity()).removeMovieFragment();
            }
        }
    }

}
