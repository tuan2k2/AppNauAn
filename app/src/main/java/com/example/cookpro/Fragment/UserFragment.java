package com.example.cookpro.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.cookpro.*;
import androidx.fragment.app.Fragment;
import com.example.cookpro.*;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cookpro.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.checkerframework.checker.units.qual.A;

import java.util.Map;

import javax.xml.namespace.QName;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserFragment extends Fragment {

    private TextView Name, Email , Quequan, nguoiTheodoi ;
    private ImageView Avatar , ImgBia;
    private final String TAG = this.getClass().getName().toUpperCase();
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private Map<String, String> userMap;
    private String email;
    private String userid;
    private static final String USERS = "users";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserFragment newInstance(String param1, String param2) {
        UserFragment fragment = new UserFragment();
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
        View view=inflater.inflate(R.layout.fragment_user, container, false);

        email = getActivity().getIntent().getStringExtra("email");

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = rootRef.child(USERS);
        Log.v("USERID", userRef.getKey());

        Name = view.findViewById(R.id.name);
        Email = view.findViewById(R.id.mail);
        Quequan = view.findViewById(R.id.quequan);
        nguoiTheodoi = view.findViewById(R.id.folow);
        Avatar = view.findViewById(R.id.imgAvatar);
        ImgBia = view.findViewById(R.id.anhbia);

        // Read from the database
        userRef.addValueEventListener(new ValueEventListener() {
            String fname, mail, quequan, nguoitheodoi, avatar , Anhbia;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot keyId: dataSnapshot.getChildren()) {
                    if (keyId.child("email").getValue().equals(email)) {
                        fname = keyId.child("fullname").getValue(String.class);
                        mail = keyId.child("email").getValue(String.class);
                        quequan = keyId.child("quequan").getValue(String.class);
                        nguoitheodoi = keyId.child("nguoitheodoi").getValue(String.class);
                        avatar = keyId.child("avatar").getValue(String.class);
                        Anhbia = keyId.child("anhbia").getValue(String.class);
                        break;
                    }
                }
                Name.setText(fname);
                Email.setText(email);
                Quequan.setText(quequan);
                nguoiTheodoi.setText(nguoitheodoi);
                Glide.with(Avatar.getContext()).load(avatar).into(Avatar);
                Glide.with(ImgBia.getContext()).load(Anhbia).into(ImgBia);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        return view;
    }
}