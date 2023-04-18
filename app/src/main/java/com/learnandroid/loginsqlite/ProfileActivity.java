package com.learnandroid.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProfileActivity extends AppCompatActivity {

//προσπάθεια να κάνω το floating button να δουλεύει και τελικά δουλεύει
    //δήλωση του button
    FloatingActionButton home1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

         home1 =(FloatingActionButton) findViewById(R.id.home1);

        home1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view)
            {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            }

        });

//  παλιότερη έκδοση με button απλό
//   Button home;
//    @Override
//   protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_profile);
//
//        home = (Button) findViewById(R.id.home1);
//
//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//                startActivity(intent);
//            }
//        });
//    }


    }
}