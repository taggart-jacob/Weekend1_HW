package com.example.weekend1_hw;

import android.support.annotation.RawRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.media.*;


public class media extends AppCompatActivity {

    MediaPlayer media;
    SeekBar mediaSeekBar;
    int seekValue = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        //creates new mediaplayer object
        media = new MediaPlayer();
        //sets seekbar to UI seek bar
        mediaSeekBar = findViewById(R.id.mediaSeekBar);
        media = MediaPlayer.create(this, R.raw.phish_tw_rep);
        mediaSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekbar, int progress, boolean which) {
                seekValue = progress;

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekbar) {
                media.seekTo(seekValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar o) {

            }
        });
        SeekThread skThread = new SeekThread();
        skThread.start();
    }

    public void PlayMedia(View v) {
        try {
            //String filename = "android.resource://" + this.getPackageName() + "/raw/phish_tw_rep.mp3";
            media = new MediaPlayer();
            //media.setDataSource(getResources().openRawResourceFd(@RawRes ));

            media.prepare();
            media.start();
            mediaSeekBar.setMax(media.getDuration());
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void PauseMedia(View v) {
        if (media.isPlaying()) {
            media.pause();
        }
    }

    public void StopMedia(View v) {
        if (media.isPlaying()) {
            media.release();
            media = null;
        }
    }


    class SeekThread extends Thread {
        public void run() {

            while (true) {
                try {

                    Thread.sleep(1000);
                } catch (Exception e) {

                    e.printStackTrace();

                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (media != null) {
                            mediaSeekBar.setProgress(media.getCurrentPosition());
                        }
                    }
                });

            }
        }
    }
}
