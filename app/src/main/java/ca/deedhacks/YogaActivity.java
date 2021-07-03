package ca.deedhacks;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YogaActivity extends YouTubeBaseActivity {

    Button btn;
    YouTubePlayerView yt;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //YogaActivity.getSupportActionBar().hide();
        setContentView(R.layout.activity_yoga);

        btn = findViewById(R.id.yoga_play_btn);
        yt = findViewById(R.id.youtubeplayer);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("F47hdaNXwT4");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yt.initialize("AIzaSyBRVtM3udMb0ESi41MjzyqU2o3X-QQeogA",onInitializedListener);
            }
        });
    }


}