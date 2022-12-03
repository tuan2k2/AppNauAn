package com.example.cookpro.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cookpro.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddFragment extends Fragment {
    EditText tenMonAnED , tacGiaEd , khauPhanEd , timeEd , danhMuc , nguyenLieu , CachLam , anhMonan , anhTacGia , GioiThieu;
    Button Luu;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddFragment newInstance(String param1, String param2) {
        AddFragment fragment = new AddFragment();
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
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_add, container, false);
        tenMonAnED = (EditText) view.findViewById(R.id.addTenMon);
        tacGiaEd = (EditText) view.findViewById(R.id.addTacGia);
        khauPhanEd = (EditText) view.findViewById(R.id.addSoNguoiAn);
        timeEd = (EditText) view.findViewById(R.id.addTime);
        danhMuc = (EditText) view.findViewById(R.id.addDanhMuc);
        nguyenLieu = (EditText) view.findViewById(R.id.addNguyenLieu);
        CachLam = (EditText) view.findViewById(R.id.addCachLam);
        anhMonan = (EditText) view.findViewById(R.id.addLinkAnh);
        anhTacGia = (EditText) view.findViewById(R.id.addAnhTacGia);
        GioiThieu = (EditText) view.findViewById(R.id.addGioiThieu);
        Luu = (Button) view.findViewById(R.id.addLuu);
        Luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tenMonAnED.getText().toString().equals("") || tacGiaEd.getText().toString().equals("")
                        || khauPhanEd.getText().toString().equals("") ||timeEd.getText().toString().equals("") ||
                        danhMuc.getText().toString().equals("")  || nguyenLieu.getText().toString().equals("")
                        || CachLam.getText().toString().equals("") || anhMonan.getText().toString().equals("") ||
                        anhTacGia.getText().toString().equals("") || GioiThieu.getText().toString().equals("") ){
                    Toast.makeText(getActivity(), "Bạn Vui Lòng Nhập Đầy Đủ Thông Tin ", Toast.LENGTH_SHORT).show();
                }
                else  {
                    add();
                }

            }
        });

        return view;
    }



    private void add() {
        Map<String ,Object> map = new HashMap<>();
        map.put("tenmonan",tenMonAnED.getText().toString());
        map.put("tacgia",tacGiaEd.getText().toString());
        map.put("songuoian",khauPhanEd.getText().toString());
        map.put("time",timeEd.getText().toString());
        map.put("tendanhmuc",danhMuc.getText().toString());
        map.put("nguyenlieu",nguyenLieu.getText().toString());
        map.put("video",CachLam.getText().toString());
        map.put("anhmonan",anhMonan.getText().toString());
        map.put("anhtacgia",anhTacGia.getText().toString());
        map.put("gthmonan",GioiThieu.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("CookProManagement/monan").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getActivity(), "Add Successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(getActivity(), "Đã xảy ra lỗi", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}