package ca.deedhacks;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.SystemClock;
import android.os.Bundle;

import android.widget.Chronometer;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WalkActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk);




    }
    /* implements View.OnClickListener,Chronometer.OnChronometerTickListener
    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        chronometer = (Chronometer) findViewById(R.id.chronometer);
        Button btn_start = (Button) findViewById(R.id.starter);
        Button btn_stop = (Button) findViewById(R.id.stopper);


        chronometer.setOnChronometerTickListener(this);
        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.starter:
                chronometer.start();// timer start
                break;
            case R.id.stopper:
                chronometer.stop();// stop timer
                break;
        }
    }

    @Override
    public void onChronometerTick(Chronometer chronometer) {

        String time = chronometer.getText().toString();
        if (time.equals("00:00")) {
            Toast.makeText(WalkActivity.this, "times up", Toast.LENGTH_SHORT).show();

        }
    }*/
}