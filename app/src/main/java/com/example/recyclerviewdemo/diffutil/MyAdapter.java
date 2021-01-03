package com.example.recyclerviewdemo.diffutil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<User> mDatas;
    private Context mContext;
    private final LayoutInflater inflater;

    public MyAdapter(Context context, ArrayList<User> datas) {
        this.mDatas = datas;
        this.mContext = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(ArrayList<User> datas) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new AdapterDiffCallback(mDatas, datas), true);
        diffResult.dispatchUpdatesTo(this);
        //更新数据源，必须放在dispatchUpdatesTo之后
        mDatas = datas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(inflater.inflate(R.layout.item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = mDatas.get(position);
        holder.name.setText(user.getName());
        holder.age.setText(String.valueOf(user.getAge()));
        holder.address.setText(user.getAddress());
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView age;
        TextView address;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
            address = itemView.findViewById(R.id.address);
        }
    }

}
