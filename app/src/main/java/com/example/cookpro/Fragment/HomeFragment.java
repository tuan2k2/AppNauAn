package com.example.cookpro.Fragment;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.cookpro.model.*;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;

import com.denzcoskun.imageslider.ImageSlider;
import com.example.cookpro.model.*;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cookpro.Adapter.*;
import com.example.cookpro.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    RecyclerView recyclerViewDanhMuc , foodRecyclerView , tipCookRecyclerView;
    danhMucAdapter danhMucAdapter;
    foodAdapter foodAdapter;
    tipCookAdapter tipCookAdapter;
    ImageSlider mainslider;

    private static final String USERS = "users";

    ImageView Avatar;
    String  email;
    TextView username ;
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
        // ánh xạ tiêu đề
        email = getActivity().getIntent().getStringExtra("email");

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = rootRef.child(USERS);
        Log.v("USERID", userRef.getKey());


        username = (TextView) view.findViewById(R.id.username) ;
        Avatar = (ImageView) view.findViewById(R.id.avtar) ;
        userRef.addValueEventListener(new ValueEventListener() {
            String fname, avatar;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot keyId: dataSnapshot.getChildren()) {
                    if (keyId.child("email").getValue().equals(email)) {
                        fname = keyId.child("fullname").getValue(String.class);
                        avatar = keyId.child("avatar").getValue(String.class);
                        break;
                    }
                }
                username.setText(fname);
                Glide.with(Avatar.getContext()).load(avatar).into(Avatar);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        // ánh xạ phần danh mục
        recyclerViewDanhMuc=(RecyclerView)view.findViewById(R.id.danhmuc);
        recyclerViewDanhMuc.setLayoutManager(new LinearLayoutManager(getContext() , RecyclerView.HORIZONTAL , false));

        FirebaseRecyclerOptions<danhMucModel> options =
                new FirebaseRecyclerOptions.Builder<danhMucModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("CookProManagement").child("DanhMuc"), danhMucModel.class)
                        .build();

        danhMucAdapter=new danhMucAdapter(options);
        recyclerViewDanhMuc.setAdapter(danhMucAdapter);
        // ánh xạ phần món ăn
        foodRecyclerView = (RecyclerView) view.findViewById(R.id.rv_food);
        foodRecyclerView.setLayoutManager(new LinearLayoutManager(getContext() , RecyclerView.HORIZONTAL , false));
        FirebaseRecyclerOptions<foodModel> optionsFood =
                new FirebaseRecyclerOptions.Builder<foodModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("CookProManagement/monan"), foodModel.class)
                        .build();
        foodAdapter = new foodAdapter(optionsFood);
        foodRecyclerView.setAdapter(foodAdapter);
        // slider hình ảnh
        mainslider = (ImageSlider) view.findViewById(R.id.slider);
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        List<SlideModel> slideModels = new ArrayList<>();
        FirebaseDatabase.getInstance().getReference().child("CookProManagement/slider").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    slideModels.add(new SlideModel(dataSnapshot.child("url").getValue().toString() , ScaleTypes.FIT));
                    mainslider.setImageList(slideModels,ScaleTypes.FIT);
                    mainslider.setItemClickListener(new ItemClickListener() {
                        @Override
                        public void onItemSelected(int i) {
                            Toast.makeText(getContext() , slideModels.get(i).getTitle().toString(),Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        // ánh xạ phần tipCook
        tipCookRecyclerView=(RecyclerView)view.findViewById(R.id.recycler_tipNauAn);
        tipCookRecyclerView.setLayoutManager(new LinearLayoutManager(getContext() , RecyclerView.HORIZONTAL , false));

        FirebaseRecyclerOptions<tipCook> optionsTipCook =
                new FirebaseRecyclerOptions.Builder<tipCook>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("CookProManagement").child("cacTipNauAn"), tipCook.class)
                        .build();

        tipCookAdapter =new tipCookAdapter(optionsTipCook);
        tipCookRecyclerView.setAdapter(tipCookAdapter);

       return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        danhMucAdapter.startListening();
        foodAdapter.startListening();
        tipCookAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        danhMucAdapter.stopListening();
        foodAdapter.stopListening();
        tipCookAdapter.stopListening();
    }
}