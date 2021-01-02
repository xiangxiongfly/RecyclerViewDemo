package com.example.recyclerviewdemo.linear;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.bean.Fruit;

import java.util.ArrayList;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private final Context mContext;
    private final ArrayList<Fruit> mDatas;
    private final LayoutInflater layoutInflater;

    public FruitAdapter(Context context, ArrayList<Fruit> datas) {
        mContext = context;
        mDatas = datas;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_linear_fruit, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Toast.makeText(mContext, "你点击了itemView-" + position, Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Toast.makeText(mContext, mDatas.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                if (mOnItemClickListener != null)
                    mOnItemClickListener.onItemChange(position);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit = mDatas.get(position);
        holder.name.setText(fruit.getName());
        holder.img.setImageResource(fruit.getImg());
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            img = itemView.findViewById(R.id.img);
        }
    }

    public interface OnItemClickListener {
        void onItemChange(int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
}
