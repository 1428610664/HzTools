package hz.com.hztools.acticity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import hz.com.hztools.R;

/**
 * Created by pursuit on 2017/12/13.
 */

public class IconfontActivity extends AppCompatActivity {

    private SeekBar sb_SeekBar;
    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iconfont);


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
}
