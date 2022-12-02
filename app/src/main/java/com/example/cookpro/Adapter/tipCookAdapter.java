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
import  com.example.cookpro.model.*;
import com.example.cookpro.*;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class tipCookAdapter extends FirebaseRecyclerAdapter<tipCook , tipCookAdapter.viewHodel > {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public tipCookAdapter(@NonNull FirebaseRecyclerOptions<tipCook> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewHodel holder, int position, @NonNull tipCook model) {
        holder.cauHoi.setText(model.getCauhoi());
        holder.traLoi.setText(model.getTraloi());
        Glide.with(holder.imgTipCook.getContext()).load(model.getImgtipcook()).into(holder.imgTipCook);
    }

    @NonNull
    @Override
    public viewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tip_cook,parent,false);
        return new tipCookAdapter.viewHodel(view);
    }

    public class viewHodel extends RecyclerView.ViewHolder {
        TextView cauHoi , traLoi ;
        ImageView imgTipCook;
        public viewHodel(@NonNull View itemView) {
            super(itemView);
            cauHoi = (TextView) itemView.findViewById(R.id.cauhoi);
            traLoi = (TextView) itemView.findViewById(R.id.traloi);
            imgTipCook = (ImageView) itemView.findViewById(R.id.imgTipCook);
        }
    }
}
