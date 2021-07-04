package ca.deedhacks;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.SystemClock;
import android.os.Bundle;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Chronometer;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class WalkActivity extends AppCompatActivity{

    TextView timerText;
    Button stopStartButton;

    boolean ifTimer = false;// if timer started

    Timer timer;
    TimerTask timerTask;
    Double time = 0.0;
    private  WebView wb;

    //https://stackoverflow.com/questions/33389037/how-to-open-any-website-in-android-application-in-android-studio
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk);

        timerText = (TextView) findViewById(R.id.text_timer);
        stopStartButton = (Button) findViewById(R.id.btn_start);

        timer = new Timer();

        wb=(WebView)findViewById(R.id.web_view);
        WebSettings webSettings=wb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wb.loadUrl("https://www.alltrails.com/");


    }

    public void resetTapped(View view){

        AlertDialog.Builder resetAlert = new AlertDialog.Builder(this);
        resetAlert.setTitle("Reset");
        resetAlert.setMessage("Reset The Timer?");
        resetAlert.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(timerTask != null){
                    timerTask.cancel();
                    time = 0.0;
                    ifTimer = false;
                    timerText.setText(formatTime(0,0,0));
                    stopStartButton.setText("START");
                }

            }
        });

        resetAlert.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //cancel reset
            }
        });

        resetAlert.show();

    }

    public void startStopTapped(View view){

        if(ifTimer == false){
           ifTimer = true;
           stopStartButton.setText("STOP");

           startTimer();
        }
        else{
            ifTimer = false;
            stopStartButton.setText("START");

            timerTask.cancel();
        }
    }

    private void startTimer() {

        timerTask = new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        time++;
                        timerText.setText(getTimerText());
                    }
                });

                
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    private String getTimerText() {
        
        int rounded = (int)Math.round(time);
       
        int sec = ((rounded % 86400) % 3600) % 60;
        int min = ((rounded % 86400) % 3600) / 60;
        int hr = ((rounded % 86400) / 3600);
        
        return formatTime(sec, min, hr);
    }

    private String formatTime(int sec, int min, int hr) {

        return String.format("%02d", hr) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec);
    }

}