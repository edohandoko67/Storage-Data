package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class app extends AppCompatActivity implements View.OnClickListener{

    private CardView cardview1, cardview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app);

        cardview1 = findViewById(R.id.cardview1);
        cardview2 = findViewById(R.id.cardview2);

        cardview1.setOnClickListener(this);
        cardview2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i ;

        switch (view.getId()){
            case R.id.cardview1:
                i = new Intent(this,MainActivity2.class);
                startActivity(i);
                break;
            case R.id.cardview2:
                i = new Intent(this,showData.class);
                startActivity(i);
                break;
        }
    }
}