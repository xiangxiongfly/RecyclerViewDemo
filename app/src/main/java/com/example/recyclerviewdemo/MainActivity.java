package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.recyclerviewdemo.grid.RvGridActivity;
import com.example.recyclerviewdemo.linear.RvLinearActivity;
import com.example.recyclerviewdemo.staggered.StaggeredGridActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickLinear(View view) {
        startActivity(new Intent(this, RvLinearActivity.class));
    }

    public void clickGrid(View view) {
        startActivity(new Intent(this, RvGridActivity.class));
    }

    public void clickStaggeredGrid(View view) {
        startActivity(new Intent(this, StaggeredGridActivity.class));
    }
}