package com.example.recyclerviewdemo.linear;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.bean.Fruit;
import com.example.recyclerviewdemo.divider.LinearItemDecoration;

import java.util.ArrayList;

public class RvLinearActivity extends AppCompatActivity implements FruitAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private ArrayList<Fruit> mDatas = new ArrayList<>();
    private FruitAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);
        recyclerView = findViewById(R.id.recyclerView);
        initDatas();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
//        LinearItemDecoration linearItemDecoration = new LinearItemDecoration(this, LinearLayoutManager.VERTICAL, Color.BLACK, 1);
        LinearItemDecoration linearItemDecoration = new LinearItemDecoration(this, LinearLayoutManager.VERTICAL, R.drawable.shap_divider);
        recyclerView.addItemDecoration(linearItemDecoration);
        recyclerView.setHasFixedSize(true);
        mAdapter = new FruitAdapter(this, mDatas);
        mAdapter.setOnItemClickListener(this);
        recyclerView.setItemAnimator(null);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                //添加一个数据
                mDatas.add(0, new Fruit("新数据", R.mipmap.ic_launcher));
                mAdapter.notifyItemInserted(0);
                recyclerView.scrollToPosition(0);
                break;
            case R.id.delete:
                //删除一个数据
                mDatas.remove(0);
                mAdapter.notifyItemRemoved(0);
                break;
            case R.id.addAll:
                //批量增加前2个数据
                mDatas.add(0, new Fruit("新数据A", R.mipmap.ic_launcher));
                mDatas.add(1, new Fruit("新数据B", R.mipmap.ic_launcher));
                mAdapter.notifyItemRangeInserted(0, 2);
                recyclerView.scrollToPosition(0);
                break;
            case R.id.deleteAll:
                mDatas.remove(0);
                mDatas.remove(0);
                mAdapter.notifyItemRangeRemoved(0, 2);
                break;
            case R.id.changeAll:
                //批量修改前3个数据
                for (int i = 0; i < 3; i++) {
                    mDatas.get(i).setName("批量修改");
                }
                mAdapter.notifyItemRangeChanged(0, 3);
                break;
            case R.id.refresh:
                for (Fruit fruit : mDatas) {
                    fruit.setName("全部刷新了");
                }
                mAdapter.notifyDataSetChanged();
                break;
        }
        return true;
    }

    @Override
    public void onItemChange(int position) {
        mDatas.get(position).setName("修改");
        mAdapter.notifyItemChanged(position);
    }
}