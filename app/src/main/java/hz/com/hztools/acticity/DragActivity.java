package hz.com.hztools.acticity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.nineoldandroids.view.ViewHelper;

import hz.com.hztools.R;
import hz.com.hztools.acticity.Base.BaseActivity;
import hz.com.hztools.widget.DragLayout;

/**
 * Created by pursuit on 2017/12/2.
 */

public class DragActivity extends BaseActivity {

    private DragLayout drag_layout;
    private ImageView top_bar_icon;
    private ListView lv_left_main;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag);

        setStatusBar();
        initView();
        initListener();

    }

    private void initView() {
        drag_layout = (DragLayout) findViewById(R.id.drag_layout);
        top_bar_icon = (ImageView) findViewById(R.id.top_bar_icon);
        lv_left_main=(ListView)findViewById(R.id.lv_left_main);
    }

    private void initListener() {
        drag_layout.setDragListener(new CustomDragListener());
        top_bar_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drag_layout.open();
            }
        });
    }

    class CustomDragListener implements DragLayout.DragListener{

        /**
         * 界面打开
         */
        @Override
        public void onOpen() {

        }

        /**
         * 界面关闭
         */
        @Override
        public void onClose() {

        }

        /**
         * 界面进行滑动
         * @param percent
         */
        @Override
        public void onDrag(float percent) {
            ViewHelper.setAlpha(top_bar_icon,1-percent);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if(drag_layout.getStatus() == DragLayout.Status.Open){
                drag_layout.close();
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
