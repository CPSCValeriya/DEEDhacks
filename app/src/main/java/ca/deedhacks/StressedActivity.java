package ca.deedhacks;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.View;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.widget.TextView;

import java.util.Random;

public class StressedActivity extends AppCompatActivity {

    MediaPlayer music;
    TextView SongName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stressed);

        music = MediaPlayer.create(
                this, R.raw.sound1);


    }

    public void musicplay(View v)
    {
        music.start();
    }

    // Pausing the music
    public void musicpause(View v)
    {
        music.pause();
    }

    // Stoping the music
    public void musicstop(View v)
    {
        music.stop();
        music = MediaPlayer.create(
                this, R.raw.sound1);
    }




}