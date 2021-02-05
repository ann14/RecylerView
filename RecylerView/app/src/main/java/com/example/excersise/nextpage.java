package com.example.excersise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class nextpage extends AppCompatActivity {
    //public int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nextpage);
        Button bclean=(Button) findViewById(R.id.buttonclean);
        TextView txt=(TextView) findViewById(R.id.choice);

        bclean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent();
                intent.setClass(nextpage.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Button back=(Button) findViewById(R.id.buttonback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nextpage.this.finish();
            }
        });

        Bundle bundle = getIntent().getExtras();
        int count=bundle.getInt("count");

        txt.setText("您選擇了"+count+"個項目");

    }

}
