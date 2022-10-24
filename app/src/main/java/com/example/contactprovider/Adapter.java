package com.example.contactprovider;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    private List<Item> itemList;
    private LayoutInflater layoutInflater;
    private Activity activity;
    public Adapter(Activity activity, List<Item> itemList){
        this.activity=activity;
        this.itemList=itemList;
    }
    @Override
    public int getCount(){
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= activity.getLayoutInflater();
        view = inflater.inflate(R.layout.layout_item,null);
        TextView itemNameView = (TextView) view.findViewById(R.id.textView_itemName);
        TextView infoView = (TextView) view.findViewById(R.id.textView_info);

        Item item =itemList.get(i);

        itemNameView.setText(item.getItemName());
        infoView.setText(item.getItemInfo());



        return view;
    }



}
