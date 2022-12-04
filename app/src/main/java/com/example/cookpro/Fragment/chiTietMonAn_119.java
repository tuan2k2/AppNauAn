package com.example.cookpro.Fragment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.cookpro.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link chiTietMonAn_119#newInstance} factory method to
 * create an instance of this fragment.
 */
public class chiTietMonAn_119 extends Fragment {

    TextView tenmonann , tg , sna , gth , nd , tacgiaa1 , tacgiaa2 , nguyenlieuu;

    ImageView anhbia , anhtacgiaa ;

    Button update , dalete;

    VideoView videoView;
    ProgressBar progressbar;
    String anhmonan ,  tenmonan , tacgia, anhtacgia , time , gthmonan , ngaydang ,nguyenlieu ,songuoian ,video;

    public chiTietMonAn_119(String anhmonan, String tenmonan, String tacgia, String anhtacgia, String time, String gthmonan, String ngaydang, String nguyenlieu, String songuoian, String video) {
        this.anhmonan = anhmonan;
        this.tenmonan = tenmonan;
        this.tacgia = tacgia;
        this.anhtacgia = anhtacgia;
        this.time = time;
        this.gthmonan = gthmonan;
        this.ngaydang = ngaydang;
        this.nguyenlieu = nguyenlieu;
        this.songuoian = songuoian;
        this.video = video;
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public chiTietMonAn_119() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment chiTietMonAn_119.
     */
    // TODO: Rename and change types and number of parameters
    public static chiTietMonAn_119 newInstance(String param1, String param2) {
        chiTietMonAn_119 fragment = new chiTietMonAn_119();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    private String mParam1;
    private String mParam2;
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

        View itemView = inflater.inflate(R.layout.fragment_chi_tiet_mon_an_119, container, false);
        tenmonann = itemView.findViewById(R.id.tenmonCT);
        tg = (TextView) itemView.findViewById(R.id.time);
        sna = (TextView) itemView.findViewById(R.id.songuoi);
        gth =(TextView) itemView.findViewById(R.id.Gth);
        nd = (TextView)itemView.findViewById(R.id.thoigiandang);
        tacgiaa1 = (TextView)itemView.findViewById(R.id.tacgiaCt);
        tacgiaa2 =(TextView) itemView.findViewById(R.id.textView19);
        nguyenlieuu = (TextView) itemView.findViewById(R.id.nlieu);
        anhbia = itemView.findViewById(R.id.abia);
        anhtacgiaa = itemView.findViewById(R.id.tvvvv);
        videoView =  itemView.findViewById(R.id.videoView2);
        progressbar = itemView.findViewById(R.id.Progressbar);
        tenmonann.setText(tenmonan);
        tg.setText(time);
        sna.setText(songuoian);
        gth.setText(gthmonan);
        nd.setText(ngaydang);
        tacgiaa1.setText(tacgia);
        tacgiaa2.setText(tacgia);
        nguyenlieuu.setText(nguyenlieu);
        Glide.with(getContext()).load(anhmonan).into(anhbia);
        Glide.with(getContext()).load(anhtacgia).into(anhtacgiaa);
        videoView.setVideoPath(video);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                progressbar.setVisibility(View.GONE);
                mp.start();
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
        return itemView;
    }
}