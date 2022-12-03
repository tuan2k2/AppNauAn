package com.example.cookpro.Adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cookpro.Fragment.*;
import com.bumptech.glide.Glide;
import com.example.cookpro.*;
import com.example.cookpro.model.*;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class foodAdapter extends FirebaseRecyclerAdapter<foodModel , foodAdapter.myviewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public foodAdapter(@NonNull FirebaseRecyclerOptions<foodModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull foodAdapter.myviewholder holder, int position, @NonNull foodModel model) {
        holder.tenmonan.setText(model.getTenmonan());
        holder.tacgia.setText(model.getTacgia());
        Glide.with(holder.anhmonan.getContext()).load(model.getAnhmonan()).into(holder.anhmonan);
        Glide.with(holder.anhtacgia.getContext()).load(model.getAnhtacgia()).into(holder.anhtacgia);
        holder.anhmonan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity=(AppCompatActivity)v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new chiTietMonAn_119(model.getAnhmonan(),model.getTenmonan(),model.getTacgia(),model.getAnhtacgia(), model.getTime(), model.getGthmonan() , model.getNgaydang() , model.getNguyenlieu() , model.getSonguoian() , model.getVideo())).addToBackStack(null).commit();
            }
        });

        holder.buttonUD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.anhmonan.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_mon_an))
                        .setExpanded(true, 1500)
                        .create();
                View view = dialogPlus.getHolderView();

              EditText  tenMonAnED = (EditText) view.findViewById(R.id.udTenMon);
                EditText  tacGiaEd = (EditText) view.findViewById(R.id.udTacGia);
                EditText khauPhanEd = (EditText) view.findViewById(R.id.udSoNguoiAn);
                EditText  timeEd = (EditText) view.findViewById(R.id.udTime);
                EditText danhMuc = (EditText) view.findViewById(R.id.udDanhMuc);
                EditText  nguyenLieu = (EditText) view.findViewById(R.id.udNguyenLieu);
                EditText CachLam = (EditText) view.findViewById(R.id.udCachLam);
                EditText anhMonan = (EditText) view.findViewById(R.id.udLinkAnh);
                EditText  anhTacGia = (EditText) view.findViewById(R.id.udAnhTacGia);
                EditText  GioiThieu = (EditText) view.findViewById(R.id.udGioiThieu);


                Button  Luu = (Button) view.findViewById(R.id.edupdate);

                tenMonAnED.setText(model.getTenmonan());
                tacGiaEd.setText(model.getTacgia());
                khauPhanEd.setText(model.getSonguoian());
                timeEd.setText(model.getTime());
                danhMuc.setText(model.getTendanhmuc());
                nguyenLieu.setText(model.getNguyenlieu());
                CachLam.setText(model.getVideo());
                anhMonan.setText(model.getAnhmonan());
                anhTacGia.setText(model.getAnhtacgia());
                GioiThieu.setText(model.getGthmonan());

                dialogPlus.show();



                Luu.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
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

                        FirebaseDatabase.getInstance().getReference().child("CookProManagement/monan")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.tenmonan.getContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull @org.jetbrains.annotations.NotNull Exception e) {
                                        Toast.makeText(holder.tenmonan.getContext(), "Data Updated Error", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });

            }


        });

        holder.buttonDL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.tenmonan.getContext());
                builder.setTitle("Are you Sure ?");
                builder.setMessage("Detele data can't be Undo");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("CookProManagement/monan")
                                .child(getRef(position).getKey()).removeValue();

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.tenmonan.getContext(), "Cancel", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.show();
            }
        });
    }

    @NonNull
    @Override
    public foodAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item,parent,false);
        return new foodAdapter.myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        ImageView anhtacgia , anhmonan;
        TextView tacgia , tenmonan;
        Button buttonUD , buttonDL;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            tacgia = (TextView) itemView.findViewById(R.id.tacgia);
            tenmonan = (TextView) itemView.findViewById(R.id.tenmonan);
            anhmonan = (ImageView) itemView.findViewById(R.id.anhmonan);
            anhtacgia = (ImageView) itemView.findViewById(R.id.anhtacgia);
            buttonUD = (Button) itemView.findViewById(R.id.buttonUD);
            buttonDL = (Button) itemView.findViewById(R.id.buttonDelete);
        }
    }
}
