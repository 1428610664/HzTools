package hz.com.hztools.acticity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hz.com.hzruntext.RunTextView;
import hz.com.hzruntext.TextViewVertical;
import hz.com.hzruntext.TextViewVerticalMore;
import hz.com.hztools.R;

/**
 * Created by hz on 2018/1/15.
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

public class RunTextViewActivity extends AppCompatActivity {

    private RunTextView mTvRuntitle;
    private TextViewVertical mRxVText;
    private TextViewVerticalMore mUpview1;

    private ArrayList<String> titleList = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_textview);

        initView();

    }

    private void initView() {

        mRxVText = (TextViewVertical) findViewById(R.id.text);
        mUpview1 = (TextViewVerticalMore) findViewById(R.id.upview1);

        titleList.add("你是天上最受宠的一架钢琴");
        titleList.add("我是丑人脸上的鼻涕");
        titleList.add("你发出完美的声音");
        titleList.add("我被默默揩去");
        titleList.add("你冷酷外表下藏着诗情画意");
        titleList.add("我已经够胖还吃东西");
        titleList.add("你踏着七彩祥云离去");
        titleList.add("我被留在这里");
        mRxVText.setTextList(titleList);
        mRxVText.setText(26, 5, 0xff766156);//设置属性
        mRxVText.setTextStillTime(3000);//设置停留时长间隔
        mRxVText.setAnimTime(300);//设置进入和退出的时间间隔
        mRxVText.setOnItemClickListener(new TextViewVertical.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(RunTextViewActivity.this, "点击了 : " + titleList.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        List<View> views = new ArrayList<>();
        setUPMarqueeView(views, 11);
        mUpview1.setViews(views);
    }

    private void setUPMarqueeView(List<View> views, int size) {
        for (int i = 0; i < size; i = i + 2) {
            final int position = i;
            //设置滚动的单个布局
            LinearLayout moreView = (LinearLayout) LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_view, null);
            //初始化布局的控件
            TextView tv1 = (TextView) moreView.findViewById(R.id.tv1);
            TextView tv2 = (TextView) moreView.findViewById(R.id.tv2);

            /**
             * 设置监听
             */
            moreView.findViewById(R.id.rl).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(RunTextViewActivity.this, "1：点击" + position, Toast.LENGTH_SHORT).show();
                }
            });
            /**
             * 设置监听
             */
            moreView.findViewById(R.id.rl2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(RunTextViewActivity.this, "2：点击" + position, Toast.LENGTH_SHORT).show();
                }
            });
            //进行对控件赋值
            tv1.setText("五一欢乐与您共享，ＸＸ节能高清惊喜大促销。");
            if (size > i + 1) {
                //因为淘宝那儿是两条数据，但是当数据是奇数时就不需要赋值第二个，所以加了一个判断，还应该把第二个布局给隐藏掉
                tv2.setText("五一充值送机，你准备好了吗？");
            } else {
                moreView.findViewById(R.id.rl2).setVisibility(View.GONE);
            }

            //添加到循环滚动数组里面去
            views.add(moreView);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRxVText.startAutoScroll();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mRxVText.stopAutoScroll();
    }

}
