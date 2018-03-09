package com.github.h0ngyue.androidlivesdk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yolo.livesdk.widget.publish_3.BeautySurfaceView;
import com.yolo.livesdk.widget.publish_controller.BeautyPublishController;
import com.yolo.livesdk.widget.watch.YoloWatchView;

public class PlayActivity extends AppCompatActivity {

    private YoloWatchView mWatchView;

    static final String YOLO_PLAY_URL_PILI
            = "rtmp://192.168.1.106/live/demo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        initView();
    }

    private void initView() {
        mWatchView = (YoloWatchView) findViewById(R.id.mWatchView);

        mWatchView.init(YOLO_PLAY_URL_PILI);
        mWatchView.start();

    }
}
