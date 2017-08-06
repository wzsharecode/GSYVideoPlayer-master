package com.example.gsyvideoplayer.utils;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;

import com.example.gsyvideoplayer.DetailPlayer;
import com.example.gsyvideoplayer.ListVideo2Activity;
import com.example.gsyvideoplayer.ListVideoActivity;
import com.example.gsyvideoplayer.PlayActivity;
import com.example.gsyvideoplayer.R;

/**
 * Created by shuyu on 2016/11/11.
 */

public class JumpUtils {

    /**
     * 跳转到视频播放
     *
     * @param activity
     * @param view
     */
    public static void goToVideoPlayer(Activity activity, View view) {
        Intent intent = new Intent(activity, PlayActivity.class);
        intent.putExtra(PlayActivity.TRANSITION, true);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Pair pair = new Pair<>(view, PlayActivity.IMG_TRANSITION);
            ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity, pair);
            ActivityCompat.startActivity(activity, intent, activityOptions.toBundle());
        } else {
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
        }
    }

    /**
     * 跳转到视频列表
     *
     * @param activity
     */
    public static void goToVideoPlayer(Activity activity) {
        Intent intent = new Intent(activity, ListVideoActivity.class);
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(activity);
        ActivityCompat.startActivity(activity, intent, activityOptions.toBundle());
    }

    /**
     * 跳转到视频列表2
     *
     * @param activity
     */
    public static void goToVideoPlayer2(Activity activity) {
        Intent intent = new Intent(activity, ListVideo2Activity.class);
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(activity);
        ActivityCompat.startActivity(activity, intent, activityOptions.toBundle());
    }

    /**
     * 跳转到详情播放
     *
     * @param activity
     */
    public static void goToDetailPlayer(Activity activity) {
        Intent intent = new Intent(activity, DetailPlayer.class);
        activity.startActivity(intent);
    }
}
