//package com.example.cookpro.Adapter;
//
//import android.os.Build;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.bumptech.glide.Glide;
//import com.example.cookpro.*;
//import com.example.cookpro.model.*;
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.RequiresApi;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
//public class foodAdapter extends FirebaseRecyclerAdapter<foodModel , foodAdapter.myviewholder> {
//    /**
//     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
//     * {@link FirebaseRecyclerOptions} for configuration options.
//     *
//     * @param options
//     */
//    public foodAdapter(@NonNull FirebaseRecyclerOptions<foodModel> options) {
//        super(options);
//    }
//
//    @Override
//    protected void onBindViewHolder(@NonNull foodAdapter.myviewholder holder, int position, @NonNull foodModel model) {
//        holder.tenmonan.setText(model.getTenmonan());
//        holder.tacgia.setText(model.getTacgia());
//        Glide.with(holder.anhmonan.getContext()).load(model.getAnhmonan()).into(holder.anhmonan);
//        Glide.with(holder.anhtacgia.getContext()).load(model.getAnhtacgia()).into(holder.anhtacgia);
//    }
//
//    @NonNull
//    @Override
//    public foodAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item,parent,false);
//        return new foodAdapter.myviewholder(view);
//    }
//
//    public class myviewholder extends RecyclerView.ViewHolder{
//        ImageView anhtacgia , anhmonan;
//        TextView tacgia , tenmonan;
//        public myviewholder(@NonNull View itemView) {
//            super(itemView);
//            tacgia = (TextView) itemView.findViewById(R.id.tacgia);
//            tenmonan = (TextView) itemView.findViewById(R.id.tenmonan);
//            anhmonan = (ImageView) itemView.findViewById(R.id.anhmonan);
//            anhtacgia = (ImageView) itemView.findViewById(R.id.anhtacgia);
//        }
//    }
//}
