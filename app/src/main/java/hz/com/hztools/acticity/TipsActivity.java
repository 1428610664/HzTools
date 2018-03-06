package hz.com.hztools.acticity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tomergoldst.tooltips.ToolTip;
import com.tomergoldst.tooltips.ToolTipsManager;

import hz.com.hztools.R;

/**
 * Created by hz on 2018/3/6.
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

public class TipsActivity extends AppCompatActivity implements
        ToolTipsManager.TipListener,
        View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String TIP_TEXT = "Tip";

    ToolTipsManager mToolTipsManager;
    RelativeLayout mRootLayout;
    RelativeLayout mParentLayout;
    TextInputEditText mEditText;
    TextView mTextView;

    /*Button mAboveBtn;
    Button mBelowBtn;
    Button mLeftToBtn;
    Button mRightToBtn;*/

    RadioButton mAlignRight;
    RadioButton mAlignLeft;
    RadioButton mAlignCenter;

    @ToolTip.Align
    int mAlign = ToolTip.ALIGN_CENTER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        mRootLayout = (RelativeLayout) findViewById(R.id.root_layout);
        mParentLayout = (RelativeLayout) findViewById(R.id.parent_layout);
        mTextView = (TextView) findViewById(R.id.text_view);

        mToolTipsManager = new ToolTipsManager(this);

        findViewById(R.id.button_above).setOnClickListener(this);
        findViewById(R.id.button_below).setOnClickListener(this);
        findViewById(R.id.button_left_to).setOnClickListener(this);
        findViewById(R.id.button_right_to).setOnClickListener(this);

        /*mAboveBtn.setOnClickListener(this);
        mBelowBtn.setOnClickListener(this);
        mLeftToBtn.setOnClickListener(this);
        mRightToBtn.setOnClickListener(this);
        mTextView.setOnClickListener(this);*/

        mAlignCenter = (RadioButton) findViewById(R.id.button_align_center);
        mAlignLeft = (RadioButton) findViewById(R.id.button_align_left);
        mAlignRight = (RadioButton) findViewById(R.id.button_align_right);

        mAlignCenter.setOnClickListener(this);
        mAlignLeft.setOnClickListener(this);
        mAlignRight.setOnClickListener(this);

        mAlignCenter.setChecked(true);

        mEditText = (TextInputEditText) findViewById(R.id.text_input_edit_text);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        ToolTip.Builder builder = new ToolTip.Builder(this, mTextView, mRootLayout, TIP_TEXT, ToolTip.POSITION_ABOVE);
        builder.setAlign(mAlign);
        mToolTipsManager.show(builder.build());
    }

    @Override
    public void onTipDismissed(View view, int anchorViewId, boolean byUser) {
        Log.d(TAG, "tip near anchor view " + anchorViewId + " dismissed");

        if (anchorViewId == R.id.text_view) {
            // Do something when a tip near view with id "R.id.text_view" has been dismissed
        }
    }

    @Override
    public void onClick(View view) {
        String text = TextUtils.isEmpty(mEditText.getText()) ? TIP_TEXT : mEditText.getText().toString();
        ToolTip.Builder builder;

        switch (view.getId()) {
            case R.id.button_above:
                mToolTipsManager.findAndDismiss(mTextView);
                builder = new ToolTip.Builder(this, mTextView, mRootLayout, text, ToolTip.POSITION_ABOVE);
                builder.setAlign(mAlign);
                mToolTipsManager.show(builder.build());
                break;
            case R.id.button_below:
                mToolTipsManager.findAndDismiss(mTextView);
                builder = new ToolTip.Builder(this, mTextView, mRootLayout, text, ToolTip.POSITION_BELOW);
                builder.setAlign(mAlign);
                builder.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                mToolTipsManager.show(builder.build());
                break;
            case R.id.button_left_to:
                mToolTipsManager.findAndDismiss(mTextView);
                builder = new ToolTip.Builder(this, mTextView, mRootLayout, text, ToolTip.POSITION_LEFT_TO);
                builder.setBackgroundColor(getResources().getColor(R.color.test_spacing1));
                builder.setTextColor(getResources().getColor(R.color.grey_hex_ba));
                builder.setGravity(ToolTip.GRAVITY_CENTER);
                builder.setTextSize(12);
                mToolTipsManager.show(builder.build());
                break;
            case R.id.button_right_to:
                mToolTipsManager.findAndDismiss(mTextView);
                builder = new ToolTip.Builder(this, mTextView, mRootLayout, text, ToolTip.POSITION_RIGHT_TO);
                builder.setBackgroundColor(getResources().getColor(R.color.primary));
                builder.setTextColor(getResources().getColor(android.R.color.white));
                mToolTipsManager.show(builder.build());
                break;
            case R.id.button_align_center:
                mAlign = ToolTip.ALIGN_CENTER;
                break;
            case R.id.button_align_left:
                mAlign = ToolTip.ALIGN_LEFT;
                break;
            case R.id.button_align_right:
                mAlign = ToolTip.ALIGN_RIGHT;
                break;
            case R.id.text_view:
                mToolTipsManager.dismissAll();
                break;
        }
    }
}
