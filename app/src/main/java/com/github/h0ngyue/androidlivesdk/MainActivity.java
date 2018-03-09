package com.github.h0ngyue.androidlivesdk;

import com.yolo.livesdk.widget.publish_3.BeautySurfaceView;
import com.yolo.livesdk.widget.publish_controller.BeautyPublishController;
import com.yolo.livesdk.widget.publish_controller.BeautyPublisherCallback;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    BeautySurfaceView mBeautyPreview;

    private BeautyPublishController mBeautyPublishController;

    String mRtmpUrl = YOLO_PUBLISH_URL_PILI;

    /**
     * 推流地址
     */
    static final String YOLO_PUBLISH_URL_PILI
            = "rtmp://192.168.1.106/live/demo";

    private Button mBtnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPreviewPublisher();
    }

    private void initPreviewPublisher() {
        // 现在这个没存pref,就是每场都默认开启麦克的
        mBeautyPreview = (BeautySurfaceView) findViewById(R.id.mBeautySurfaceView);
        mBtnPlay = (Button) findViewById(R.id.mBtnPlay);
        mBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PlayActivity.class));
                finish();
            }
        });
        mBeautyPublishController = mBeautyPreview.getController();
        mBeautyPublishController.audioOn(true);
        boolean initFrontCamera = true;
        boolean initUseBeauty = true;
        boolean initMirror = true;
        boolean portrait = true;
        mBeautyPublishController
                .initPrefs(initFrontCamera, initUseBeauty, initMirror,
                        portrait);

        findViewById(R.id.mBtnBeauty).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mBeautyPublishController.switchUseBeauty();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        startPublish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPublish();
    }

    private void stopPublish() {
        mBeautyPublishController.stopPublish();
    }

    private void startPublish() {
        mBeautyPublishController
                .startPublish(MainActivity.this, mRtmpUrl, mBeautyPublisherCallback);
    }

    BeautyPublisherCallback mBeautyPublisherCallback = new BeautyPublisherCallback() {
        @Override
        public void onOpenCameraFail() {

        }

        @Override
        public void onCameraAccessFail() {

        }

        @Override
        public void onLiveStarted() {

        }

        @Override
        public void onInitPublishFail() {

        }

        @Override
        public void onStartPublishFail() {

        }

        @Override
        public void onSendError() {

        }

        @Override
        public void onSendErrorResume() {

        }

        @Override
        public void onPublishCpuIntence() {

        }

        @Override
        public void onRePublishError() {

        }

        @Override
        public void onFrame(byte[] yuvData, int width, int height, long timestampMs) {

        }
    };
}
