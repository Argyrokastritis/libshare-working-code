package com.learnandroid.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TradeActivity extends AppCompatActivity {
    Button trade;
    EditText book,author;
    FloatingActionButton home_trade;
    DBHelper DB;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade);

        book = (EditText) findViewById(R.id.bookText);
        author = (EditText) findViewById(R.id.authText);
        trade = (Button) findViewById(R.id.trade_button);
        home_trade =(FloatingActionButton )findViewById(R.id.home_trade);
        DB = new DBHelper(this);

        trade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String books = book.getText().toString();
                String auth = author.getText().toString();
                Boolean insert = DB.insertBook(books, auth);
                if (insert == true) {
                    Toast.makeText(TradeActivity.this, "Book added succesfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), TradeListActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(TradeActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
            home_trade.setOnClickListener(new View.OnClickListener()
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