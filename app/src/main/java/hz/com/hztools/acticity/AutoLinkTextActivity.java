package hz.com.hztools.acticity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import hz.com.hztools.R;
import hz.com.hztools.widget.AutoLinkStyleTextView;

/**
 * Created by hz on 2017/12/25.
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

public class AutoLinkTextActivity extends AppCompatActivity {

    private AutoLinkStyleTextView autoLinkStyleTextView, tvStartImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_link_text);

        autoLinkStyleTextView = (AutoLinkStyleTextView) findViewById(R.id.tv);
        autoLinkStyleTextView.setOnClickCallBack(new AutoLinkStyleTextView.ClickCallBack() {
            @Override
            public void onClick(int position) {
                if (position == 0) {
                    Toast.makeText(AutoLinkTextActivity.this, "购买须知", Toast.LENGTH_SHORT).show();
                } else if (position == 1) {
                    Toast.makeText(AutoLinkTextActivity.this, "用户条款", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvStartImage = (AutoLinkStyleTextView) findViewById(R.id.tv_start_image);
        tvStartImage.setStartImageText(tvStartImage.getText());

    }
}
