package hz.com.hztools.acticity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import hz.com.hztools.R;
import hz.com.hztools.acticity.Base.BaseActivity;

public class MainActivity extends BaseActivity {

    private long firstTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStatusBar();
        LinearLayout linear_bar = (LinearLayout) findViewById(R.id.bar_layout);
        linear_bar.setBackgroundResource(R.color.colorPrimary);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_IndicatorDialog:
                openActivity(IndicatorDialogActicity.class);
                break;
            case R.id.bt_slider:
                openActivity(SliderActivity.class);
                break;
            case R.id.bt_picker:
                openActivity(PickerActivity.class);
                break;
            case R.id.bt_dialogs:
                openActivity(DialogsActivity.class);
                break;
            case R.id.bt_imagepicker:
                openActivity(ImaPickerActivity.class);
                break;
            case R.id.bt_indicator:
                openActivity(IndicatorActivity.class);
                break;
            case R.id.bt_code:
                openActivity(ZxingCodeActivity.class);
                break;
            case R.id.bt_refresh:
                openActivity(ZxingCodeActivity.class);
                break;
            case R.id.bt_dragView:
                openActivity(DragActivity.class);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = secondTime;
                return true;
            } else {
                System.exit(0);
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
