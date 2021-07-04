package ca.deedhacks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerTracker;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.Objects;

public class YogaActivity extends AppCompatActivity {

    YouTubePlayerTracker tracker;

    //https://github.com/PierfrancescoSoffritti/android-youtube-player
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_yoga);

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        tracker = new YouTubePlayerTracker();
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "9xZcnOjLNZ0";
                youTubePlayer.loadVideo(videoId, 0);

                YouTubePlayerListener listener = new YouTubePlayerListener() {
                    @Override
                    public void onReady(YouTubePlayer youTubePlayer) {

                    }

                    @Override
                    public void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState playerState) {

                        String ps = playerState.toString();

                        if (ps.equals("ENDED")){
                            User user = User.getInstance();
                            user.addPoints(20);
                        }

                    }

                    @Override
                    public void onPlaybackQualityChange(YouTubePlayer youTubePlayer, PlayerConstants.PlaybackQuality playbackQuality) {

                    }

                    @Override
                    public void onPlaybackRateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlaybackRate playbackRate) {

                    }

                    @Override
                    public void onError(YouTubePlayer youTubePlayer, PlayerConstants.PlayerError playerError) {

                    }

                    @Override
                    public void onCurrentSecond(YouTubePlayer youTubePlayer, float v) {

                    }

                    @Override
                    public void onVideoDuration(YouTubePlayer youTubePlayer, float v) {

                    }

                    @Override
                    public void onVideoLoadedFraction(YouTubePlayer youTubePlayer, float v) {

                    }

                    @Override
                    public void onVideoId(YouTubePlayer youTubePlayer, String s) {

                    }

                    @Override
                    public void onApiChange(YouTubePlayer youTubePlayer) {

                    }
                };

                youTubePlayer.addListener(listener);
            }
        });


    }


}
