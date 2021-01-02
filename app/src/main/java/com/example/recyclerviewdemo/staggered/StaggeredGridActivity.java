package com.example.recyclerviewdemo.staggered;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.bean.Fruit;

import java.util.ArrayList;
import java.util.Random;

public class StaggeredGridActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Fruit> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);
        recyclerView = findViewById(R.id.recyclerView);
        initDatas();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        FruitAdapter mAdapter = new FruitAdapter(this, mDatas);
        recyclerView.setAdapter(mAdapter);
    }

    private void initDatas() {
        for (int i = 0; i < 3; i++) {
            mDatas.add(new Fruit("苹果 " + i, R.drawable.apple_pic, getRandomDesc("苹果描述")));
            mDatas.add(new Fruit("香蕉 " + i, R.drawable.banana_pic, getRandomDesc("香蕉描述")));
            mDatas.add(new Fruit("樱桃 " + i, R.drawable.cherry_pic, getRandomDesc("樱桃描述")));
            mDatas.add(new Fruit("葡萄 " + i, R.drawable.grape_pic, getRandomDesc("葡萄描述")));
            mDatas.add(new Fruit("芒果 " + i, R.drawable.mango_pic, getRandomDesc("芒果描述")));
            mDatas.add(new Fruit("橘子 " + i, R.drawable.orange_pic, getRandomDesc("橘子描述")));
            mDatas.add(new Fruit("梨 " + i, R.drawable.pear_pic, getRandomDesc("梨描述")));
            mDatas.add(new Fruit("菠萝 " + i, R.drawable.pineapple_pic, getRandomDesc("菠萝描述")));
            mDatas.add(new Fruit("草莓 " + i, R.drawable.strawberry_pic, getRandomDesc("草莓描述")));
            mDatas.add(new Fruit("西瓜 " + i, R.drawable.watermelon_pic, getRandomDesc("西瓜描述")));
        }
    }

    private String getRandomDesc(String desc) {
        Random random = new Random();
        int length = random.nextInt(10) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(desc);
        }
        return builder.toString();
    }
}
