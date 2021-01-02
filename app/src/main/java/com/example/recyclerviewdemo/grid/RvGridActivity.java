package com.example.recyclerviewdemo.grid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.bean.Fruit;
import com.example.recyclerviewdemo.divider.GridItemDecoration;
import com.example.recyclerviewdemo.grid.FruitAdapter;

import java.util.ArrayList;

public class RvGridActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Fruit> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);
        recyclerView = findViewById(R.id.recyclerView);
        initDatas();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new GridItemDecoration(this));
        recyclerView.setHasFixedSize(true);
        FruitAdapter mAdapter = new FruitAdapter(this, mDatas);
        recyclerView.setAdapter(mAdapter);
    }

    private void initDatas() {
        for (int i = 0; i < 3; i++) {
            mDatas.add(new Fruit("苹果 " + i, R.drawable.apple_pic));
            mDatas.add(new Fruit("香蕉 " + i, R.drawable.banana_pic));
            mDatas.add(new Fruit("樱桃 " + i, R.drawable.cherry_pic));
            mDatas.add(new Fruit("葡萄 " + i, R.drawable.grape_pic));
            mDatas.add(new Fruit("芒果 " + i, R.drawable.mango_pic));
            mDatas.add(new Fruit("橘子 " + i, R.drawable.orange_pic));
            mDatas.add(new Fruit("梨 " + i, R.drawable.pear_pic));
            mDatas.add(new Fruit("菠萝 " + i, R.drawable.pineapple_pic));
            mDatas.add(new Fruit("草莓 " + i, R.drawable.strawberry_pic));
            mDatas.add(new Fruit("西瓜 " + i, R.drawable.watermelon_pic));
        }
    }
}
