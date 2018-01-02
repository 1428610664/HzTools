package hz.com.hztools.acticity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hz.com.hztools.R;

/**
 * Created by hz on 2017/12/28.
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

public class GetResourceActivity extends AppCompatActivity {

    Button getImage;
    Button getVideo;
    Button getAudio;
    TextView myTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_resource);


        myTextView = (TextView) this.findViewById(R.id.myTextView);

        getAudio = ((Button) this.findViewById(R.id.getAudio));
        getAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] projection = {MediaStore.Audio.Media._ID,
                        MediaStore.Audio.Media.DISPLAY_NAME,
                        MediaStore.Audio.Media.DATA,
                        MediaStore.Audio.Media.SIZE};
                String orderBy = MediaStore.Audio.Media.DISPLAY_NAME;
                Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                getContentProvider(uri, projection, orderBy);
            }
        });
                getVideo = ((Button) this.findViewById(R.id.getVideo));
        getVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] projection = {MediaStore.Video.Media._ID,
                        MediaStore.Video.Media.DISPLAY_NAME,
                        MediaStore.Video.Media.DATA,
                        MediaStore.Video.Media.SIZE};

                String orderBy = MediaStore.Video.Media.DISPLAY_NAME;
                Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                getContentProvider(uri, projection, orderBy);
            }
        });

        getImage = ((Button) this.findViewById(R.id.getImage));
        getImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] projection = {MediaStore.Images.Media._ID,
                        MediaStore.Images.Media.DISPLAY_NAME,
                        MediaStore.Images.Media.DATA,
                        MediaStore.Images.Media.SIZE};
                String orderBy = MediaStore.Images.Media.DISPLAY_NAME;
                Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                getContentProvider(uri, projection, orderBy);
            }
        });
    }

    /**
     * 获取ContentProvider
     *
     * @param projection
     * @param orderBy
     */
    public void getContentProvider(Uri uri, String[] projection, String orderBy) {
        List<HashMap<String, String>> listImage = new ArrayList<HashMap<String, String>>();
        Cursor cursor = getContentResolver().query(uri, projection, null, null, orderBy);
        if (null == cursor) {
            return;
        }
        while (cursor.moveToNext()) {
            HashMap<String, String> map = new HashMap<String, String>();
            for (int i = 0; i < projection.length; i++) {
                map.put(projection[i], cursor.getString(i));
                System.out.println(projection[i] + ":::::::" + cursor.getString(i) + "\n");
            }
            listImage.add(map);
        }
        Toast.makeText(this, "数量：" + listImage.size(), Toast.LENGTH_SHORT).show();
        myTextView.setText(listImage.toString());
    }
}
