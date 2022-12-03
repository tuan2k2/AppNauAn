package com.example.cookpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.cookpro.model.*;
import de.hdodenhof.circleimageview.CircleImageView;

public class SignUp_1 extends AppCompatActivity {
    private EditText Email, Pass, Fullname, Quequan , songuoitheodoi , linkanh , linkAnhBia;
    private Button signUp;
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private static final String USERS = "users";
    private String TAG = "SignUp_1";
    private String email;
    private String pass;
    private String fullname;
    private String quequan;
    private String nguoitheodoi;
    private String avatar;
    private String anhbia;
    private userModel user;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_1);

        Email =(EditText) findViewById(R.id.edmail);
        Pass = (EditText) findViewById(R.id.edpass);
        Fullname =(EditText)  findViewById(R.id.txtFullName);
        Quequan = (EditText)  findViewById(R.id.txtquequan);
        songuoitheodoi = (EditText)  findViewById(R.id.txtSoNguoiDk);
        linkanh =  (EditText)  findViewById(R.id.linkavatar);
        linkAnhBia = (EditText) findViewById(R.id.linkAnhBia);
        signUp = (Button) findViewById(R.id.dangki);
        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference(USERS);
        mAuth = FirebaseAuth.getInstance();
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Email.getText().toString() != null && Pass.getText().toString() != null) {
                    email = Email.getText().toString();
                    pass = Pass.getText().toString();
                    fullname = Fullname.getText().toString();
                    quequan = Quequan.getText().toString();
                    nguoitheodoi = songuoitheodoi.getText().toString();
                    avatar = linkanh.getText().toString();
                    anhbia = linkAnhBia.getText().toString();
                    user = new userModel(email, pass, fullname, quequan, nguoitheodoi, avatar , anhbia);
                    registerUser();
                }
            }
        });
    }

    private void registerUser() {
        if (email.equals("") || pass.equals("") || fullname.equals("") || quequan.equals("") ||nguoitheodoi.equals("") || avatar.equals("") || anhbia.equals("")){
            Toast.makeText(SignUp_1.this, "Vui lòng nhập đầy đủ thông tin",
                    Toast.LENGTH_SHORT).show();
        }else {
            mAuth.createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI(user);
                                startActivity(new Intent(getApplicationContext() , Sign_in.class));
                                Toast.makeText(SignUp_1.this, "Đăng kí thành công",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(SignUp_1.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }

    }

    public void updateUI(FirebaseUser currentUser) {
        String keyid = mDatabase.push().getKey();
        mDatabase.child(keyid).setValue(user); //adding user info to database

    }
}