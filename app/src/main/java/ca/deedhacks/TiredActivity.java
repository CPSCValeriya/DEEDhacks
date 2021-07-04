package ca.deedhacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;


public class TiredActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_tired);

        Button walkBtn = findViewById(R.id.btn_walk);
        walkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TiredActivity.this, WalkActivity.class);
                startActivity(intent);
            }
        });



        Button yogaBtn = findViewById(R.id.yoga_btn_tasks);
        yogaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TiredActivity.this, YogaActivity.class);
                startActivity(intent);
            }
        });

        Button napBtn = findViewById(R.id.nap_btn_tasks);
        napBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TiredActivity.this, NapActivity.class);
                startActivity(intent);
            }
        });

    }

//comment
}