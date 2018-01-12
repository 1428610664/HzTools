package hz.com.hztools.acticity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import hz.com.hztools.R;
import hz.com.hztools.acticity.Base.BaseActivity;
import hz.com.hztools.widget.CustomVideoView;

/**
 * Created by pursuit on 2017/12/1.
 */

public class WelcomeActivity extends BaseActivity {

    private TextView downTime;
    private Button welcome_button;
    private CustomVideoView welcome_videoview;

    private CountDownTimer mTimer;
    private int count = 5;

    private boolean isClose = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        openActivity(MainActivity.class);
        finish();
        /*
        downTime = (TextView) findViewById(R.id.downTime);
        downTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClose = true;
                openActivity(MainActivity.class);
                finish();
            }
        });

        initVideo();
        /* CountDownTimer方式进行倒计时进入 */
        //initDownTime();

        /* handle方式倒计时进入
        handler.sendEmptyMessageDelayed(0, 1000); */
    }

    private void initDownTime() {
        mTimer = new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                downTime.setText("倒计时：" + (millisUntilFinished / 1000) + "s");
            }
            @Override
            public void onFinish() {
                openActivity(MainActivity.class);
                finish();
            }
        }.start();
    }

    private int getCount() {
        count--;
        if (count == 0) {
            if(!isClose){
                openActivity(MainActivity.class);
                finish();
            }
        }
        return count;
    }

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (msg.what == 0) {
                downTime.setText("跳过：" + getCount() + "s");
                handler.sendEmptyMessageDelayed(0, 1000);
            }
        };
    };

    private void initVideo() {
        welcome_button = (Button) this.findViewById(R.id.welcome_button);
        welcome_videoview = (CustomVideoView) this.findViewById(R.id.welcome_videoview);
        welcome_videoview.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.kr36));
        welcome_videoview.start();
        welcome_videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                welcome_videoview.start();
            }
        });

        welcome_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (welcome_videoview.isPlaying()) {
                    welcome_videoview.stopPlayback();
                    welcome_videoview = null;
                }
                //mTimer.cancel();
                openActivity(MainActivity.class);
                WelcomeActivity.this.finish();
            }
        });
    }

    private String getAppVersionName(Context context) {
        String versionName = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(this.getPackageName(), 0);
            versionName = packageInfo.versionName;
            if (TextUtils.isEmpty(versionName)) {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionName;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isClose = true;
    }
}
