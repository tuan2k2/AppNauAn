package com.example.cookpro.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.os.StrictMode;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import com.example.cookpro.model.*;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.example.cookpro.Adapter.*;
import com.example.cookpro.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    RecyclerView recyclerViewDanhMuc , foodRecyclerView;
    danhMucAdapter danhMucAdapter;
    foodAdapter foodAdapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        recyclerViewDanhMuc=(RecyclerView)view.findViewById(R.id.danhmuc);
        recyclerViewDanhMuc.setLayoutManager(new LinearLayoutManager(getContext() , RecyclerView.HORIZONTAL , false));

        FirebaseRecyclerOptions<danhMucModel> options =
                new FirebaseRecyclerOptions.Builder<danhMucModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("CookProManagement").child("DanhMuc"), danhMucModel.class)
                        .build();

        danhMucAdapter=new danhMucAdapter(options);
        recyclerViewDanhMuc.setAdapter(danhMucAdapter);

        foodRecyclerView = (RecyclerView) view.findViewById(R.id.rv_food);
        foodRecyclerView.setLayoutManager(new LinearLayoutManager(getContext() , RecyclerView.HORIZONTAL , false));
        FirebaseRecyclerOptions<foodModel> optionsFood =
                new FirebaseRecyclerOptions.Builder<foodModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("CookProManagement/monan"), foodModel.class)
                        .build();
        foodAdapter = new foodAdapter(optionsFood);
        foodRecyclerView.setAdapter(foodAdapter);

       return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        danhMucAdapter.startListening();
        foodAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        danhMucAdapter.stopListening();
        foodAdapter.stopListening();
    }
}