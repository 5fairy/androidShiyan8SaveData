package com.example.shiyan8savedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddBookActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_book_layout);
        dbHelper = new MyDatabaseHelper(this,"BookStore.db",null,2);
        //获取对象
        EditText bookName = (EditText) findViewById(R.id.add_bookName);
        EditText bookAuthor = (EditText) findViewById(R.id.add_bookAuthor);
        EditText bookPrice = (EditText) findViewById(R.id.add_bookPrice);
        EditText bookPages = (EditText) findViewById(R.id.add_bookPages);
        EditText category_id = (EditText) findViewById(R.id.add_Category_id);
        Button addBook = (Button) findViewById(R.id.add_book);
        //为 addBook 按钮设添加监听事件
        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取 EditText 中用户填写的数据
                String name = bookName.getText().toString();
                String author = bookAuthor.getText().toString();
                Double price = Double.parseDouble(bookPrice.getText().toString());
                Integer pages = Integer.parseInt(bookPages.getText().toString());
                Integer categoryId = Integer.parseInt(category_id.getText().toString());
                //System.out.println(name+"\n"+author+"\n"+price+"\n"+pages+"\n"+categoryId);
                //获取 SQLiteDatabase 及 ContentValues 对象
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //向 Book 表添加数据
                values.put("name",name);
                values.put("author",author);
                values.put("price",price);
                values.put("pages",pages);
                values.put("category_id",categoryId);
                db.insert("Book",null,values);
                values.clear();
                Toast.makeText(AddBookActivity.this,"Add Book succeeded",Toast.LENGTH_SHORT).show();
                //清空 EditText
                bookName.setText("");
                bookAuthor.setText("");
                bookPrice.setText("");
                bookPages.setText("");
                category_id.setText("");
            }
        });
    }
}