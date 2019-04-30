package com.sdskapps.otocapital.adapter;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sdskapps.otocapital.MainActivity;
import com.sdskapps.otocapital.MovieDetailsFragment;
import com.sdskapps.otocapital.R;
import com.sdskapps.otocapital.model.MovieModel;
import com.sdskapps.otocapital.MainActivity;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    Context context;
    List<MovieModel> model;

    public MovieAdapter(){
        //TODO default constructor
    }
    public MovieAdapter(Context context, List<MovieModel> model){
        this.context = context;
        this.model =model;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_single_layout,viewGroup,false);
        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder( MovieViewHolder viewHolder, int i) {
        viewHolder.movieName.setText(model.get(i).getName());
        viewHolder.movieName.setSelected(true);
        final String title = model.get(i).getName();
        final String rating = model.get(i).getRating();
        final String desc = model.get(i).getDesc();
        final String posterImage = model.get(i).getImage();

        final MovieViewHolder holder =viewHolder;
        viewHolder.movieImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)context).setMovieData(title,rating,desc,posterImage);
                ((MainActivity)context).addMovieFragment();
                ((MainActivity)context).adapter.notifyDataSetChanged();
                ((MainActivity)context).container.setCurrentItem(3,true);

            }
        });
        Glide.with(context).load("https://image.tmdb.org/t/p/w500"+model.get(i).getBack_image()).placeholder(R.mipmap.ic_launcher).into(viewHolder.movieImage);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        TextView movieName;
        ImageView movieImage;
        public MovieViewHolder(View itemView){
            super(itemView);
            movieName = (TextView) itemView.findViewById(R.id.txtSingleMovieName);
            movieImage = (ImageView) itemView.findViewById(R.id.imgSingleMovieImage);

        }
    }



}
