package ca.deedhacks;

import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.concurrent.TimeUnit;

public class YogaActivity extends YouTubeBaseActivity {

    YouTubePlayerView yt;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    YouTubePlayer video ;
    long videoTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //YogaActivity.getSupportActionBar().hide();
        setContentView(R.layout.activity_yoga);

        yt = findViewById(R.id.youtubeplayer);

        videoTime = 0;

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {

            private MyPlayerStateChangeListener myPlayerStateChangeListener;
            private MyPlaybackEventListener myPlaybackEventListener;


            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                myPlayerStateChangeListener = new MyPlayerStateChangeListener();
                myPlaybackEventListener = new MyPlaybackEventListener();

                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                youTubePlayer.loadVideo("F47hdaNXwT4");
                video = youTubePlayer;

                youTubePlayer.setPlayerStateChangeListener(myPlayerStateChangeListener);
                youTubePlayer.setPlaybackEventListener(myPlaybackEventListener);
            }//end success

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }

            final class MyPlayerStateChangeListener implements YouTubePlayer.PlayerStateChangeListener {

                private void updateLog(String prompt){
                };

                @Override
                public void onAdStarted() {
                    updateLog("onAdStarted()");
                }

                @Override
                public void onError(
                        com.google.android.youtube.player.YouTubePlayer.ErrorReason arg0) {
                    updateLog("onError(): " + arg0.toString());
                }

                @Override
                public void onLoaded(String arg0) {
                    updateLog("onLoaded(): " + arg0);
                }

                @Override
                public void onLoading() {
                    updateLog("onLoading()");
                }

                @Override
                public void onVideoEnded() {
                    System.out.println("VIDEO ENDED ALERT");
                    User user = User.getInstance();
                    user.addPoints(16);
                    System.out.println("NUM POINTS = "  + user.getNumPoints());

                }

                @Override
                public void onVideoStarted() {
                    updateLog("onVideoStarted()");
                }

            }

            final class MyPlaybackEventListener implements YouTubePlayer.PlaybackEventListener {

                private void updateLog(String prompt){
                };

                @Override
                public void onBuffering(boolean arg0) {
                    updateLog("onBuffering(): " + String.valueOf(arg0));
                }

                @Override
                public void onPaused() {
                    updateLog("onPaused()");
                }

                @Override
                public void onPlaying() {
                    System.out.println("PLAYING");
                }

                @Override
                public void onSeekTo(int arg0) {
                    updateLog("onSeekTo(): " + String.valueOf(arg0));
                }

                @Override
                public void onStopped() {
                    System.out.println("STOPPED");
                }

            }

            //end
        };

        yt.initialize("AIzaSyBRVtM3udMb0ESi41MjzyqU2o3X-QQeogA",onInitializedListener);

    }




}