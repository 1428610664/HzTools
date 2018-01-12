package hz.com.hztools.acticity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;

import hz.com.hztools.R;
import hz.com.hztools.utils.PhoneUtil;

/**
 * Created by pursuit on 2017/12/13.
 */

public class IconfontActivity extends AppCompatActivity {

    private SeekBar sb_SeekBar;
    private TextView tv,android,ios;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iconfont);

        android = (TextView) findViewById(R.id.android);
        ios = (TextView) findViewById(R.id.ios);

        setIconDrawable(android, MaterialDesignIconic.Icon.gmi_android);
        setIconDrawable(ios, MaterialDesignIconic.Icon.gmi_apple);
        //setIconDrawable(ios, FontAwesome.Icon.faw_location_arrow);

        Typeface iconfont = Typeface.createFromAsset(getAssets(), "iconfont/iconfont.ttf");
        tv = (TextView) findViewById(R.id.tv_iconfont);
        tv.setTypeface(iconfont);

        sb_SeekBar = (SeekBar) findViewById(R.id.sb_SeekBar);
        sb_SeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv.setTextSize(24 + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void setIconDrawable(TextView view, IIcon icon) {
        view.setCompoundDrawablesWithIntrinsicBounds(new IconicsDrawable(this)
                        .icon(icon)
                        .color(getResources().getColor(R.color.primary))
                        .sizeDp(16),
                null, null, null);
        view.setCompoundDrawablePadding(PhoneUtil.dip2px(this, 10));
    }

}
