package hz.com.hztools.acticity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.wx.goodview.GoodView;

import hz.com.hztools.R;

/**
 * Created by hz on 2018/1/24.
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

public class GoodViewActivity extends AppCompatActivity {

    GoodView mGoodView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodview);

        mGoodView = new GoodView(this);

    }

    public void good(View view) {
        ((ImageView) view).setImageResource(R.mipmap.good_checked);
        mGoodView.setText("+1");
        mGoodView.show(view);
    }

    public void good2(View view) {
        ((ImageView) view).setImageResource(R.mipmap.good_checked);
        mGoodView.setImage(getResources().getDrawable(R.mipmap.good_checked));
        mGoodView.show(view);
    }

    public void collection(View view) {
        ((ImageView) view).setImageResource(R.mipmap.collection_checked);
        mGoodView.setTextInfo("收藏成功", Color.parseColor("#f66467"), 12);
        mGoodView.show(view);
    }

    public void bookmark(View view) {
        ((ImageView) view).setImageResource(R.mipmap.bookmark_checked);
        mGoodView.setTextInfo("收藏成功", Color.parseColor("#ff941A"), 12);
        mGoodView.show(view);
    }

    public void reset(View view) {
        ((ImageView) findViewById(R.id.good)).setImageResource(R.mipmap.good);
        ((ImageView) findViewById(R.id.good2)).setImageResource(R.mipmap.good);
        ((ImageView) findViewById(R.id.collection)).setImageResource(R.mipmap.collection);
        ((ImageView) findViewById(R.id.bookmark)).setImageResource(R.mipmap.bookmark);
        mGoodView.reset();
    }

}
