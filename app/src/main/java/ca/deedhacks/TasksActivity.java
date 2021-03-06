package ca.deedhacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_tasks);

        Button tiredBtn = findViewById(R.id.tired_btn_tasks);
        tiredBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TasksActivity.this, TiredActivity.class);
                startActivity(intent);
            }
        });

        Button StressedBtn = findViewById(R.id.stressed_btn_tasks);
        StressedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TasksActivity.this, StressedActivity.class);
                startActivity(intent);
            }
        });

        Button upsetBtn = findViewById(R.id.upset_btn_tasks);
        upsetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TasksActivity.this, UpsetActivity.class);
                startActivity(intent);
            }
        });
    }
}