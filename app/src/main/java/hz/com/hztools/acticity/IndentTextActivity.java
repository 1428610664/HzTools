package hz.com.hztools.acticity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import hz.com.hztools.R;
import hz.com.hztools.utils.ColorUtil;
import hz.com.hztools.utils.PhoneUtil;
import hz.com.hztools.widget.HZIndentTextView;

/**
 * Created by pursuit on 2017/12/10.
 */

public class IndentTextActivity extends AppCompatActivity {

    private HZIndentTextView mIndentView;
    private HZIndentTextView mIndentView2;
    private HZIndentTextView mIndentView3;
    private HZIndentTextView mIndentView4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indent_text_view);

        mIndentView = (HZIndentTextView) findViewById(R.id.indentview);
        mIndentView.setIndentText("投资理财");
        mIndentView.setText("如何处理好投资的产品，管理好自己的财产？");
        mIndentView.setIndentBackground(ColorUtil.createRoundRectShape(PhoneUtil.dip2px(getApplicationContext(),16), Color.RED));


        mIndentView2 = (HZIndentTextView) findViewById(R.id.indentview2);
        mIndentView2.setIndentText("明星");
        mIndentView2.setText("我最喜欢科比了，看着他退役，好伤心，好难过，学习他的优点");
        mIndentView2.setIndentBackground(ColorUtil.createRoundRectShape(PhoneUtil.dip2px(getApplicationContext(),16),Color.BLUE));

        mIndentView3 = (HZIndentTextView) findViewById(R.id.indentview3);
        mIndentView3.setIndentText("星座");
        mIndentView3.setText("我是双子座，大家觉得双子座的如何，各抒己见吧");
        mIndentView3.setIndentBackground(ColorUtil.createRoundRectShape(PhoneUtil.dip2px(getApplicationContext(),16),Color.MAGENTA));

        mIndentView4 = (HZIndentTextView) findViewById(R.id.indentview4);
        mIndentView4.setIndentText("今晚打老虎");
        mIndentView4.setText("谷歌发布全新Android Studio 2.0，模拟器3倍速！支持Instant Run ！");
        mIndentView4.setIndentBackground(ColorUtil.createRoundRectShape(PhoneUtil.dip2px(getApplicationContext(),16),Color.MAGENTA));
    }
}
