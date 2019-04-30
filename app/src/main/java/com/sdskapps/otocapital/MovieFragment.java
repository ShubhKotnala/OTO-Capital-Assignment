package com.sdskapps.otocapital;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sdskapps.otocapital.adapter.MovieAdapter;
import com.sdskapps.otocapital.model.MovieModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MovieFragment extends Fragment {

    RequestQueue requestQueue;
    RecyclerView movieRecycler;
    String url = "https://api.themoviedb.org/3/discover/movie?api_key=bcd9c5b6a75ffa08a347c71349fd3ba8&sort_by=popularity.desc";

    public static Fragment getInstance(){
        return new MovieFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        movieRecycler = (RecyclerView) view.findViewById(R.id.movieRecycler);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(),2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        movieRecycler.setLayoutManager(gridLayoutManager);
        final List<MovieModel> models = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            Log.d("Movie",obj.toString());
                            JSONArray array = obj.getJSONArray("results");
                            for(int i = 0; i<array.length();i++){
                                MovieModel model = new MovieModel();
                                JSONObject movieObject = array.getJSONObject(i);
                                model.setName(movieObject.getString("title"));
                                model.setBack_image(movieObject.getString("backdrop_path"));
                                model.setImage(movieObject.getString("poster_path"));
                                model.setRating(movieObject.getString("vote_average"));
                                model.setDesc(movieObject.getString("overview"));
                                models.add(i,model);
                            }
                            MovieAdapter adapter = new MovieAdapter(getActivity(),models);
                            movieRecycler.setAdapter(adapter);
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }

        @Override
        public void setUserVisibleHint(boolean visible) {
            super.setUserVisibleHint(visible);
            if (visible) {
                ((MainActivity)getActivity()).appBarLayout.setExpanded(true);
                ((MainActivity)getActivity()).removeMovieFragment();
            }
        }
}
