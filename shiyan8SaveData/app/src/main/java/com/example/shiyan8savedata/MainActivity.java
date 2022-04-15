package com.example.shiyan8savedata;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public MyDatabaseHelper dbHelper;
    private List<Book> bookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //构造MyDatabaseHelper对象
        dbHelper = new MyDatabaseHelper(this,"BookStore.db",null,2);

        //新建 createDatabase 按钮
        Button createDatabase = (Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //调用 MyDatabaseHelper 中的 getWritableDatabase 创建或打开一个现有数据库
                dbHelper.getWritableDatabase();
            }
        });

        //新建 addData 按钮
        Button addData = (Button) findViewById(R.id.add_category);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //开始组装第一条数据
                values.put("category_name","经济类");
                values.put("category_code","1");
                db.insert("Category",null,values);  //插入第一条数据
                values.clear();
                //开始组装第二条数据
                values.put("category_name","互联网类");
                values.put("category_code","2");
                db.insert("Category",null,values);  //插入第二条数据
                values.clear();
                Toast.makeText(MainActivity.this,"Add data succeeded",Toast.LENGTH_SHORT).show();
            }
        });

        //新建 AddBookActivity 按钮
        Button addBookActivity = (Button) findViewById(R.id.add_bookActivity);
        addBookActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddBookActivity.class);
                startActivity(intent);
            }
        });

        //新建 SelectBookList 按钮
        Button selectBookList = (Button) findViewById(R.id.select_bookList);
        selectBookList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                //查询Book中所有的数据
                Cursor cursor = db.query("Book",null,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do{
                        @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                        @SuppressLint("Range") int cId = cursor.getInt(cursor.getColumnIndex("category_id"));
                        @SuppressLint("Range") double price = cursor.getDouble(cursor.getColumnIndex("price"));
                       //初始化图书数据
                        Book book = new Book(name,price,cId);
                        bookList.add(book);
                    }while(cursor.moveToNext());
                }
                //用 ListView 显示图书条目信息
                BookAdapter adapter = new BookAdapter(MainActivity.this,R.layout.book_item_layout,bookList);
                ListView listView = (ListView) findViewById(R.id.list_view);
                listView.setAdapter(adapter);
            }
        });
    }
}