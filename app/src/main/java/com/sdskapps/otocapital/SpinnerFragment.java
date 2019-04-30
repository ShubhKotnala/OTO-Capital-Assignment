package com.sdskapps.otocapital;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SpinnerFragment extends Fragment {

    private Spinner numberSpinner, multiplesSpinner;


    public static Fragment getInstance(){

        return new SpinnerFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_spinner,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        numberSpinner = (Spinner) view.findViewById(R.id.numberSpinner);
        multiplesSpinner = (Spinner) view.findViewById(R.id.multiplesSpinner);

        numberSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int number = Integer.parseInt(numberSpinner.getSelectedItem().toString());

                List<String> multiplesList = new ArrayList<String>();
                multiplesList.add(String.valueOf(number));
                multiplesList.add(String.valueOf(number*2));
                multiplesList.add(String.valueOf(number*3));
                multiplesList.add(String.valueOf(number*4));
                multiplesList.add(String.valueOf(number*5));
                ArrayAdapter<String> multiplesAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_spinner_item,multiplesList);
                multiplesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                multiplesAdapter.notifyDataSetChanged();
                multiplesSpinner.setAdapter(multiplesAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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
