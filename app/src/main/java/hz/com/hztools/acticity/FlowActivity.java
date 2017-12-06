package hz.com.hztools.acticity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import hz.com.hztools.R;
import hz.com.hztools.widget.FlowLayout;
import me.gujun.android.taggroup.TagGroup;

/**
 * Created by pursuit on 2017/12/5.
 */

public class FlowActivity extends AppCompatActivity {

    private String[] mVals = new String[]
            {"Hello", "Android", "Weclome Hi ", "Button", "TextView", "Hello",
                    "Android", "Weclome", "Button ImageView", "TextView", "Helloworld",
                    "Android", "Weclome Hello", "Button Text", "TextView"};

    private FlowLayout mFlowLayout;

    private TagGroup mBeautyTagGroup;
    private TagGroup mBeautyInverseTagGroup;

    private TagGroup.OnTagClickListener mTagClickListener = new TagGroup.OnTagClickListener() {
        @Override
        public void onTagClick(String tag) {
            Toast.makeText(FlowActivity.this, tag, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);

        mFlowLayout = (FlowLayout) findViewById(R.id.id_flowlayout);
        initData();

        mBeautyTagGroup = (TagGroup) findViewById(R.id.tag_group_beauty);
        mBeautyInverseTagGroup = (TagGroup) findViewById(R.id.tag_group_beauty_inverse);
        mBeautyTagGroup.setTags(mVals);
        mBeautyInverseTagGroup.setTags(mVals);
        mBeautyTagGroup.setOnTagClickListener(mTagClickListener);
        mBeautyInverseTagGroup.setOnTagClickListener(mTagClickListener);

    }

    private void initData() {
        LayoutInflater mInflater = LayoutInflater.from(this);
        for (int i = 0; i < mVals.length; i++) {
            TextView tv = (TextView) mInflater.inflate(R.layout.item_tv, mFlowLayout, false);
            tv.setText(mVals[i]);
            final int finalI = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(FlowActivity.this, "点击："+ mVals[finalI], Toast.LENGTH_SHORT).show();
                }
            });
            mFlowLayout.addView(tv);
        }
    }
}
