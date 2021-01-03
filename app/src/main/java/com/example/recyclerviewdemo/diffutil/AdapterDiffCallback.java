package com.example.recyclerviewdemo.diffutil;

import androidx.recyclerview.widget.DiffUtil;

import java.util.ArrayList;

public class AdapterDiffCallback extends DiffUtil.Callback {
    private ArrayList<User> mOldList;
    private ArrayList<User> mNewList;

    public AdapterDiffCallback(ArrayList<User> oldList, ArrayList<User> newList) {
        mOldList = oldList;
        mNewList = newList;
    }

    @Override
    public int getOldListSize() {
        return mOldList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewList.size();
    }

    /**
     * 判断是否同一个item
     */
    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldList.get(oldItemPosition).getId() == mNewList.get(newItemPosition).getId();
    }

    /**
     * 比较两个item的内容是否相同
     */
    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        String oldName = mOldList.get(oldItemPosition).getName();
        String oldAddress = mOldList.get(oldItemPosition).getAddress();
        int oldAge = mOldList.get(oldItemPosition).getAge();

        String newName = mNewList.get(newItemPosition).getName();
        String newAddress = mNewList.get(newItemPosition).getAddress();
        int newAge = mNewList.get(newItemPosition).getAge();

        return oldAddress.equals(newAddress) && oldName.equals(newName) && oldAge == newAge;
    }
}
