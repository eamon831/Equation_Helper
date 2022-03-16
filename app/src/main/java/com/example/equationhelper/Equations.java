package com.example.equationhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.equationhelper.database.User;

import java.util.List;

public class Equations extends AppCompatActivity {

    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equations);
        t=findViewById(R.id.name);
        User u=getIntent().getParcelableExtra("item");
        t.setText(u.firstName);
    }

}