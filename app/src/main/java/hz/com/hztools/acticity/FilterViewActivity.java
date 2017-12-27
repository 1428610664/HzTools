package hz.com.hztools.acticity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import hz.com.hztools.R;
import hz.com.hztools.filterView.FilterData;
import hz.com.hztools.filterView.FilterView;

/**
 * Created by hz on 2017/12/27.
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

public class FilterViewActivity extends AppCompatActivity implements FilterView.OnFilterItemClickListener {

    private FilterView mFilterView;
    private TextView mTextView;
    private FilterData mData;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_view);

        mFilterView = (FilterView) findViewById(R.id.filterView);
        mTextView = (TextView) findViewById(R.id.textView);

        initData();
    }

    private void initData() {
        mData = new FilterData();
        mData.setDateData(Arrays.asList("今天","前7天","后7天"));
        mData.setTypeData(Arrays.asList("全部订单","自由健","公开体验课"));
        mData.setPayData(Arrays.asList("未消费","已消费","已过期"));
        mFilterView.setFilterData(mData);
        mFilterView.setOnFilterItemClickListener(this);
    }

    @Override
    public void onFilterItemClick(String content) {
        Toast.makeText(this, "点击：" + content, Toast.LENGTH_SHORT).show();
    }
}
