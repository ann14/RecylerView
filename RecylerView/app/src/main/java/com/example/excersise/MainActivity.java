package com.example.excersise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler_view;
    private Adapter adapter;
    private ArrayList<String> dData = new ArrayList<>();
    private ArrayList<Boolean> checkdata = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            for(int i = 1; i <= 100; i++) {
                dData.add("項目" + i);
                checkdata.add(false);
            }
            recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
            recycler_view.setLayoutManager(new LinearLayoutManager(this));
            recycler_view.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            adapter = new Adapter(dData,checkdata);

            recycler_view.setAdapter(adapter);

        final Button nextpage=(Button)findViewById(R.id.buttonnext);

        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, nextpage.class);

                Intent intent1 = new Intent();
                intent1.setClass(MainActivity.this, nextpage.class);
                Bundle bundle = new Bundle();
                bundle.putInt("count",adapter.count);
                intent1.putExtras(bundle);
                startActivity(intent1);
            }
        });






    }
}
