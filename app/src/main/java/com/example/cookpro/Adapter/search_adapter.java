package com.example.cookpro.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cookpro.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookpro.Fragment.chiTietMonAn_119;
import com.example.cookpro.model.*;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class search_adapter extends FirebaseRecyclerAdapter<foodModel ,search_adapter.viewHoder > {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */

    public search_adapter(@NonNull FirebaseRecyclerOptions<foodModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewHoder holder, int position, @NonNull foodModel model) {
        holder.tenMonAn.setText(model.getTenmonan());
        holder.time.setText(model.getTime());
        holder.soNguoiAn.setText(model.getSonguoian());
        holder.Gth.setText(model.getGthmonan());
        Glide.with(holder.imgAnh.getContext()).load(model.getAnhmonan()).into(holder.imgAnh);
        holder.imgAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity=(AppCompatActivity)v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new chiTietMonAn_119(model.getAnhmonan(),model.getTenmonan(),model.getTacgia(),model.getAnhtacgia(), model.getTime(), model.getGthmonan() , model.getNgaydang() , model.getNguyenlieu() , model.getSonguoian() , model.getVideo())).addToBackStack(null).commit();

            }
        });
    }
    @NonNull
    @Override
    public viewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cacmon_search,parent,false);
        return new viewHoder(view);
    }

    public class viewHoder extends RecyclerView.ViewHolder {
        TextView tenMonAn , time , soNguoiAn , Gth ;
        ImageView imgAnh;
        public viewHoder(@NonNull View itemView) {
            super(itemView);
            tenMonAn = itemView.findViewById(R.id.nameMonAn_search);
            time = itemView.findViewById(R.id.thoiGianLam_search);
            soNguoiAn = itemView.findViewById(R.id.soNguoiAn_search);
            Gth = itemView.findViewById(R.id.gthieumonan_search);
            imgAnh = itemView.findViewById(R.id.imgmonan_search);
        }
    }
}
