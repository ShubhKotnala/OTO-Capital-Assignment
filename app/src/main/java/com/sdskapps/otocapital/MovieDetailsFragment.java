package com.sdskapps.otocapital;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.transition.ChangeBounds;
import android.support.transition.Transition;
import android.support.transition.TransitionManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetailsFragment extends Fragment {

    boolean show = false;
    ConstraintLayout layout;
    ImageView moviePoster;
    TextView title,rating,desc;
    String image = "";

    public static Fragment getInstance(){
        return new MovieDetailsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie_details,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // layout = (ConstraintLayout) view.findViewById(R.id.movieLayoutSimple);
        moviePoster = (ImageView) view.findViewById(R.id.backgroundImage);
        title = (TextView) view.findViewById(R.id.txtTitle);
        desc = (TextView) view.findViewById(R.id.txtDescription);
        rating = (TextView) view.findViewById(R.id.txtRating);
        image = ((MainActivity)getActivity()).image;

        desc.setText(((MainActivity)getActivity()).desc);
        rating.setText(((MainActivity)getActivity()).rating);
        title.setText(((MainActivity)getActivity()).title);
        Glide.with(getContext()).load("https://image.tmdb.org/t/p/w500" + image).into(moviePoster);

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
          //  ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
            ((MainActivity)getActivity()).appBarLayout.setExpanded(false);
        }
    }
}
