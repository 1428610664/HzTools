package hz.com.hztools.acticity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jiang.android.indicatordialog.Utils;

import hz.com.hztools.R;
import hz.com.hztools.widget.RecycleViewDivider;

/**
 * Created by hz on 2018/1/23.
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

public class RollingRecyclerview extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayout llSearch;
    private HomeAdapter adapter;
    private int height = 640;// 滑动开始变色的高,真实项目中此高度是由广告轮播或其他首页view高度决定
    private int overallXScroll = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rolling_recyclerview);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        llSearch = (LinearLayout) findViewById(R.id.ll_search);
        LinearLayoutManager manager = new LinearLayoutManager(RollingRecyclerview.this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new RecycleViewDivider(
                RollingRecyclerview.this, LinearLayoutManager.HORIZONTAL, Utils.dip2px(RollingRecyclerview.this, 0.5f), ContextCompat.getColor(RollingRecyclerview.this, R.color.line_color)));
        recyclerView.setLayoutManager(manager);

        adapter = new HomeAdapter(this);

        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                overallXScroll = overallXScroll + dy;// 累加y值 解决滑动一半y值为0
                if (overallXScroll <= 0) {   //设置标题的背景颜色
                    llSearch.setBackgroundColor(Color.argb((int) 0, 235, 79, 56));
                } else if (overallXScroll > 0 && overallXScroll <= height) { //滑动距离小于banner图的高度时，设置背景和字体颜色颜色透明度渐变
                    float scale = (float) overallXScroll / height;
                    float alpha = (255 * scale);
                    llSearch.setBackgroundColor(Color.argb((int) alpha, 235, 79, 56));
                } else {
                    llSearch.setBackgroundColor(Color.argb((int) 255, 235, 79, 56));
                }
            }
        });

    }


    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.DefaultViewHolder> {
        private Context mContext;

        public HomeAdapter(Context mContext) {
            super();
            this.mContext = mContext;
        }

        @Override
        public int getItemCount() {
            return 20;
        }

        @Override
        public DefaultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View root = LayoutInflater.from(mContext).inflate(R.layout.item_sign, parent, false);
            return new DefaultViewHolder(root);
        }

        @Override
        public void onBindViewHolder(final DefaultViewHolder holder, final int position) {

        }

        class DefaultViewHolder extends RecyclerView.ViewHolder {

            public DefaultViewHolder(View itemView) {
                super(itemView);
            }
        }
    }

}
