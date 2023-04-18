package com.learnandroid.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;



public class SearchActivity extends AppCompatActivity {


    FloatingActionButton searchtohome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchtohome =(FloatingActionButton )findViewById(R.id.home3);

        // get Data from SQLite
        final DBHelper myDb = new DBHelper(this);
		/*
		 * for insert statement
		myDb.InsertData("1","Picture 1", "pic_a.png");
		myDb.InsertData("2","Picture 2", "pic_b.png");
		myDb.InsertData("3","Picture 3", "pic_c.png");
		myDb.InsertData("4","Picture 4", "pic_d.png");
		myDb.InsertData("5","Picture 5", "pic_e.png");
		myDb.InsertData("6","Picture 6", "pic_f.png");
		myDb.InsertData("7","Picture 7", "pic_g.png");
		myDb.InsertData("8","Picture 8", "pic_h.png");
		myDb.InsertData("9","Picture 9", "pic_i.png");
		*/
        final String[] myData = myDb.SelectAllData();

        // autoCompleteTextView1
        final AutoCompleteTextView autoCom = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, myData);

        autoCom.setAdapter(adapter);

        // button1
        final Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(SearchActivity.this,
                        String.valueOf("Your Input : " + autoCom.getText().toString()),
                        Toast.LENGTH_SHORT).show();
            }
        });
        searchtohome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view)
            {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }

        });


    }

}