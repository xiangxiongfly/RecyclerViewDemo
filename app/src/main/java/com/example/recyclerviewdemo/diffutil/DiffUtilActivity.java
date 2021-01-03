package com.example.recyclerviewdemo.diffutil;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.R;

import java.util.ArrayList;
import java.util.Collection;

public class DiffUtilActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<User> mDatas = new ArrayList<>();
    private MyAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_diff);
        recyclerView = findViewById(R.id.recyclerView);
        initData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mAdapter = new MyAdapter(this, mDatas);
        recyclerView.setAdapter(mAdapter);
    }

    public void modifyData(View view) {
        ArrayList<User> newDatas = new ArrayList<>();
        for (User user : mDatas) {
            newDatas.add(user.clone());
        }
        newDatas.get(3).setAge(333333);
        newDatas.get(3).setAddress("6666666");
        newDatas.remove(0);
        newDatas.add(new User(18, "新姓名18", 18, "新地址18"));
        mAdapter.setDatas(newDatas);
    }

    private void initData() {
        for (int i = 0; i < 18; i++) {
            mDatas.add(new User(i, "姓名：name" + i, i, "Address：中国" + i));
        }
    }
}
