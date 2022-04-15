package com.example.shiyan8savedata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    private int resourceId;

    public BookAdapter(Context context, int resource, List<Book> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Book book = getItem(position);  //获取当前项的 Book 实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView bookName = (TextView) view.findViewById(R.id.list_view_bookName);
        TextView bookCategory = (TextView) view.findViewById(R.id.list_view_bookCategory);
        TextView bookPrice = (TextView) view.findViewById(R.id.list_view_bookPrice);
        bookName.setText(book.getbName());
        bookCategory.setText("" +book.getCategoryId());
        bookPrice.setText("" +book.getbPrice());
        return view;
    }
}
