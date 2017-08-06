package com.example.gsyvideoplayer;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.Window;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.gsyvideoplayer.adapter.ListNormalAdapter;
import com.shuyu.gsyvideoplayer.GSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListVideoActivity extends AppCompatActivity {

    @BindView(R.id.video_list)
    ListView videoList;
    @BindView(R.id.activity_list_video)
    RelativeLayout activityListVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 设置一个exit transition
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setEnterTransition(new Explode());
            getWindow().setExitTransition(new Explode());
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_video);
        ButterKnife.bind(this);

        ListNormalAdapter listNormalAdapter = new ListNormalAdapter(this);
        videoList.setAdapter(listNormalAdapter);

    }

    @Override
    public void onBackPressed() {
        if (StandardGSYVideoPlayer.backFromWindowFull(this)) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoPlayer.releaseAllVideos();
    }
}
