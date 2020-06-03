package com.example.frndszone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsActivity extends AppCompatActivity  {
    private CircleImageView profileimg;
    private static final int PICK_IMAGE=1;
    Uri imageuri;
    ImageButton btn_next;
    EditText first,last;
    String phonenumber,firstname,lastname;
    //Firebase declarations
    FirebaseAuth mAuth;
    DatabaseReference reference;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        phonenumber=getIntent().getStringExtra("phonenumber");
        assert phonenumber != null;
        Log.v("phoneNumber-2",phonenumber);
        setContentView(R.layout.activity_details);

        profileimg=(CircleImageView)findViewById(R.id.profile_img);
        btn_next=(ImageButton)findViewById(R.id.nxtbutton);
        first=(EditText)findViewById(R.id.first_name);
        last=(EditText)findViewById(R.id.last_name);
        mAuth=FirebaseAuth.getInstance();


        profileimg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent gallery=new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(gallery,"Select Picture"),PICK_IMAGE );
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser firebaseUser=mAuth.getCurrentUser();
                String userid=firebaseUser.getUid();
                reference= FirebaseDatabase.getInstance().getReference("Users").child(userid);
                HashMap<String,String> hashMap=new HashMap<>();
                hashMap.put("phoneno",phonenumber);
                hashMap.put("firstname",first.getText().toString());
                hashMap.put("lastname",last.getText().toString());
                //hashMap.put("imageUri","default");
                reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Intent intent=new Intent(DetailsActivity.this,WelcomeActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });



            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE&&resultCode==RESULT_OK){
            imageuri=data.getData();
            try {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),imageuri);
                profileimg.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}