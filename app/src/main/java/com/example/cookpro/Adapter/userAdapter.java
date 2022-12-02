//package com.example.cookpro.Adapter;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.example.cookpro.model.*;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.example.cookpro.*;
//public class userAdapter extends FirebaseRecyclerAdapter<userModel , userAdapter.viewhodel> {
//    /**
//     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
//     * {@link FirebaseRecyclerOptions} for configuration options.
//     *
//     * @param options
//     */
//    public userAdapter(@NonNull FirebaseRecyclerOptions<userModel> options) {
//        super(options);
//    }
//
//    @Override
//    protected void onBindViewHolder(@NonNull viewhodel holder, int position, @NonNull userModel model) {
//       holder.login.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//                if ()
//           }
//       });
//    }
//
//    @NonNull
//    @Override
//    public viewhodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tip_cook,parent,false);
//        return new userAdapter.viewhodel(view);
//    }
//
//    public class viewhodel extends RecyclerView.ViewHolder {
//        Button login;
//        public viewhodel(@NonNull View itemView) {
//            super(itemView);
//          login = (Button) itemView.findViewById(R.id.dn);
//        }
//    }
//}
