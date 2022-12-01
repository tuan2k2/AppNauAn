//package com.example.cookpro.Adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import com.example.cookpro.*;
//import com.example.cookpro.model.*;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
//public class titleAdapter extends RecyclerView.Adapter<titleAdapter.viewHodel> {
//    private Context context;
//    private List<titleModel> titleModels;
//    public titleAdapter(Context mContext){
//        this.context = mContext;
//    }
//    public void setData(List<titleModel> list){
//        this.titleModels = list;
//        notifyDataSetChanged();
//    }
//    @NonNull
//    @Override
//    public viewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//      //  View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title ,parent ,false);
//     //   return new viewHodel(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull viewHodel holder, int position) {
//            titleModel titleModel = titleModels.get(position);
//            if (titleModel == null){
//                return;
//            }
//        LinearLayoutManager linearLayout = new LinearLayoutManager(context , RecyclerView.HORIZONTAL , false);
//            holder.rcvTitle.setLayoutManager(linearLayout);
//            holder.titleText.setText(titleModel.getNameTitle());
//            foodAdapter foodAdapter = new foodAdapter();
//            foodAdapter.setData(titleModel.getFoodModelList());
//        holder.rcvTitle.setAdapter(foodAdapter);
//    }
//
//    @Override
//    public int getItemCount() {
//        if(titleModels != null){
//            return titleModels.size();
//        }
//        return 0;
//    }
//
//    public class viewHodel extends RecyclerView.ViewHolder {
//
//        TextView titleText;
//        RecyclerView rcvTitle;
//        public viewHodel(@NonNull View itemView) {
//            super(itemView);
////            titleText = (TextView) itemView.findViewById(R.id.tv_title);
////            rcvTitle = (RecyclerView) itemView.findViewById(R.id.rcv_title);
//
//        }
//    }
//}
