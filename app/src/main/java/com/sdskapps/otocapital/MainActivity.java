package com.sdskapps.otocapital;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sdskapps.otocapital.adapter.MainPagerAdapter;

public class MainActivity extends AppCompatActivity {

    public   ViewPager container;
    private TabLayout tabLayout;
    public   MainPagerAdapter adapter;
    public AppBarLayout appBarLayout;
    public String title,rating,desc,image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.animate();
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.mainTabLayout);
        container  = (ViewPager)  findViewById(R.id.container);
        adapter = new MainPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new GalleryFragment(),"GALLERY",0);
        adapter.addFragment(new SpinnerFragment(),"Spinner",1);
        adapter.addFragment(new MovieFragment(),"Movie",2);
        container.setAdapter(adapter);

        tabLayout.setupWithViewPager(container);


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

    public void addMovieFragment(){
        if(adapter.getCount() == 3){
        adapter.addFragment(new MovieDetailsFragment(),"Details",3);
        adapter.notifyDataSetChanged();}

    }
    public void removeMovieFragment(){
        if(adapter.getCount()==4) {

            adapter.removeFragment(3);
        }
    }

    public void setMovieData(String title, String rating, String desc,String image){
        this.title = title;
        this.rating = rating;
        this.desc = desc;
        this.image = image;
    }



}
