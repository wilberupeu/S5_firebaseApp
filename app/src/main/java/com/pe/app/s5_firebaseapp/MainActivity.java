package com.pe.app.s5_firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String userId="0002",name="usuario2";
        mDatabase= FirebaseDatabase.getInstance().getReference();
        mDatabase.child("users").child(userId).child("name").setValue(name);

        mDatabase.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
                  for (DataSnapshot data:snapshot.getChildren() ){
                      data.getValue();
                  }
                
            }
            @Override
            public void onCancelled( DatabaseError error) {

            }
        });


    }


}