package com.example.cookpro.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.example.cookpro.model.*;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.example.cookpro.*;
public class userAdapter extends FirebaseRecyclerAdapter<userModel , userAdapter.viewhodel> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public userAdapter(@NonNull FirebaseRecyclerOptions<userModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewhodel holder, int position, @NonNull userModel model) {
        holder.tenMonAn.setText(model.getTenmonan());
        holder.time.setText(model.getTime());
        holder.soNguoiAn.setText(model.getSonguoian());
        holder.gthMonAn.setText(model.getGioithieu());
        Glide.with(holder.anhmonan.getContext()).load(model.getAnhmonan()).into(holder.anhmonan);
    }

    @NonNull
    @Override
    public viewhodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cacmon_search,parent,false);
        return new userAdapter.viewhodel(view);
    }

    public class viewhodel extends RecyclerView.ViewHolder {
        TextView tenMonAn , time , soNguoiAn , gthMonAn;
        ImageView anhmonan;
        public viewhodel(@NonNull View itemView) {
            super(itemView);
        }
    }
}
