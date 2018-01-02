package hz.com.hztools.acticity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import cn.carbs.android.expandabletextview.library.ExpandableTextView;
import hz.com.hztools.R;

/**
 * Created by hz on 2018/1/2.
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

public class ExpandableTextViewActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTVComparison;
    private Button mBtnUpdateText;
    private Button mBtnToListView;

    private ExpandableTextView mETV;
    private CharSequence[] mPoems = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_textview);

        mPoems = getResources().getStringArray(R.array.poems);

        mTVComparison = (TextView) this.findViewById(R.id.tv_comparison);
        mBtnUpdateText = (Button) this.findViewById(R.id.button_update_text);
        mBtnToListView = (Button) this.findViewById(R.id.button_to_list_view);
        mETV = (ExpandableTextView) this.findViewById(R.id.etv);

        mBtnUpdateText.setOnClickListener(this);
        mBtnToListView.setOnClickListener(this);

        // 测试添加OnClickListener的情况，功能正常。添加外部的onClick事件后，原来的点击toggle功能自动屏蔽，
        // 点击尾部的ClickableSpan仍然有效
        mETV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (mETV.getExpandState()) {
                    case ExpandableTextView.STATE_SHRINK:
                        Toast.makeText(getApplicationContext(), "ExpandableTextView clicked, STATE_SHRINK",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case ExpandableTextView.STATE_EXPAND:
                        Toast.makeText(getApplicationContext(), "ExpandableTextView clicked, STATE_EXPAND",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        //mETV.setText(mPoems[0]);//在ExpandableTextView在创建完成之前改变文字，功能正常
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_to_list_view:
                gotoCheckInListView();
                break;
            case R.id.button_update_text:
                updateText();
                break;
        }
    }

    private void gotoCheckInListView() {
        //Intent intent = new Intent(ActivityMain.this, ActivityListView.class);
        //startActivity(intent);
    }

    private Random mRandom = new Random();
    private int prevRandomInt = -1;
    private int currRandomInt = -1;

    private void updateText() {
        currRandomInt = mRandom.nextInt(mPoems.length);
        while (prevRandomInt == currRandomInt) {
            currRandomInt = mRandom.nextInt(mPoems.length);
        }
        prevRandomInt = currRandomInt;
        CharSequence newCS = mPoems[currRandomInt];

        mTVComparison.setText(newCS);//作为对比示例
        mETV.setText(newCS);//效果显示
    }
}
