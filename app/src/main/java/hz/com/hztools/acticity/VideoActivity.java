package hz.com.hztools.acticity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.io.File;

import hz.com.hztools.R;
import hz.com.recordlib.RecordVideoActivity;

/**
 * Created by hz on 2017/12/27.
 * GitHub：https://github.com/1428610664
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG            #
 * #                                                   #
 */

public class VideoActivity extends AppCompatActivity {

    String videoPath;
    public static final int TAKE_DATA = 200;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        File path = new File(Environment.getExternalStorageDirectory(), "dalong");
        if (!path.exists()) {
            path.mkdirs();
        }
        videoPath = path.getAbsolutePath() + File.separator + System.currentTimeMillis() + ".mp4";

    }

    /**
     * 录制
     *
     * @param view
     */
    public void doRecording(View view) {
        Intent intent = new Intent(this, RecordVideoActivity.class);
        intent.putExtra(RecordVideoActivity.RECORD_VIDEO_PATH, videoPath);
        startActivityForResult(intent, TAKE_DATA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAKE_DATA:
                if (resultCode == RecordVideoActivity.TAKE_VIDEO_CODE) {
                    String videoPath = data.getStringExtra(RecordVideoActivity.TAKE_VIDEO_PATH);
                    Toast.makeText(this, "视频路径：" + videoPath, Toast.LENGTH_SHORT).show();
                } else if (resultCode == RecordVideoActivity.TAKE_PHOTO_CODE) {
                    String photoPath = data.getStringExtra(RecordVideoActivity.TAKE_PHOTO_PATH);
                    Toast.makeText(this, "图片路径：" + photoPath, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}
