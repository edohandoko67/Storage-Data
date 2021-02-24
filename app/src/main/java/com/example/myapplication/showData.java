package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class showData extends AppCompatActivity {

    private RecyclerView listMahasiswaView;
    private RecyclerviewAdapter recyclerviewAdapter;
    DatabaseReference mhsReference;
    ArrayList<UseHelpers> listMhs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdata);
        listMahasiswaView = (RecyclerView) findViewById(R.id.list_mahasiswa);
        listMahasiswaView.setHasFixedSize(true);
        listMahasiswaView.setLayoutManager(new LinearLayoutManager(this));


        mhsReference = FirebaseDatabase.getInstance().getReference().child("Mahasiswa");
        mhsReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    UseHelpers single = dataSnapshot.getValue(UseHelpers.class);
                    listMhs.add(single);
                }

                recyclerviewAdapter = new RecyclerviewAdapter(showData.this, listMhs);
                listMahasiswaView.setAdapter(recyclerviewAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}

