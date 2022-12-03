package com.example.cookpro.Adapter;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cookpro.*;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.example.cookpro.model.*;
public class danhMucAdapter extends FirebaseRecyclerAdapter< danhMucModel , danhMucAdapter.myviewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public danhMucAdapter(@NonNull FirebaseRecyclerOptions<danhMucModel> options) {
        super(options);
    }
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull danhMucModel model) {
        holder.tenDanhMuc.setText(model.getTendanhmuc());
        Glide.with(holder.imgDanhMuc.getContext()).load(model.getAnhdanhmuc()).into(holder.imgDanhMuc);
        holder.imgDanhMuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.danhmuc_items,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        ImageView imgDanhMuc;
        TextView tenDanhMuc;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            imgDanhMuc = (ImageView) itemView.findViewById(R.id.imgDanhMuc);
            tenDanhMuc = (TextView) itemView.findViewById(R.id.tvDanhMuc);
        }
    }


}
