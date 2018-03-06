package hz.com.hztools.acticity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import hz.com.hztools.Adapter.SwitchItemAdapter;
import hz.com.hztools.R;
import hz.com.hztools.bean.SwitchItem;

import static hz.com.hztools.Adapter.SwitchItemAdapter.SPAN_COUNT_ONE;
import static hz.com.hztools.Adapter.SwitchItemAdapter.SPAN_COUNT_THREE;

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

public class LayoutSwitchActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SwitchItemAdapter itemAdapter;
    private GridLayoutManager gridLayoutManager;
    private List<SwitchItem> items;

    private ImageView switchLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_switch);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        switchLayout = (ImageView) findViewById(R.id.switchLayout);

        initItemsData();

        gridLayoutManager = new GridLayoutManager(this, SPAN_COUNT_ONE);
        itemAdapter = new SwitchItemAdapter(items, gridLayoutManager);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);

    }

    private void initItemsData() {
        items = new ArrayList<>(4);
        items.add(new SwitchItem(R.drawable.img1, "Image 1", 20, 33));
        items.add(new SwitchItem(R.drawable.img2, "Image 2", 10, 54));
        items.add(new SwitchItem(R.drawable.img3, "Image 3", 27, 20));
        items.add(new SwitchItem(R.drawable.img4, "Image 4", 45, 67));
    }

    public void switchLayout(View v){
        switchLayout();
        switchIcon(switchLayout);
    }

    private void switchLayout() {
        if (gridLayoutManager.getSpanCount() == SPAN_COUNT_ONE) {
            gridLayoutManager.setSpanCount(SPAN_COUNT_THREE);
        } else {
            gridLayoutManager.setSpanCount(SPAN_COUNT_ONE);
        }
        itemAdapter.notifyItemRangeChanged(0, itemAdapter.getItemCount());
    }

    private void switchIcon(ImageView item) {
        if (gridLayoutManager.getSpanCount() == SPAN_COUNT_THREE) {
            item.setImageResource(R.drawable.ic_span_1);
        } else {
            item.setImageResource(R.drawable.ic_span_3);
        }
    }


}
