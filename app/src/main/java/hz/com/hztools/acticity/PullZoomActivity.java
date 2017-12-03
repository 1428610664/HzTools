package hz.com.hztools.acticity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ecloud.pulltozoomview.PullToZoomListViewEx;
import com.jiang.android.indicatordialog.IndicatorBuilder;
import com.jiang.android.indicatordialog.IndicatorDialog;

import java.util.ArrayList;
import java.util.List;

import hz.com.hztools.Base.BaseAdapter;
import hz.com.hztools.Base.BaseViewHolder;
import hz.com.hztools.R;

/**
 * Created by pursuit on 2017/12/2.
 */

public class PullZoomActivity extends AppCompatActivity implements View.OnClickListener {

    private PullToZoomListViewEx listView;
    private IndicatorDialog dialog;

    private List<String> mLists = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_zoom);

        ImageButton back = (ImageButton) findViewById(R.id.bt_back);
        ImageButton menu = (ImageButton) findViewById(R.id.bt_menu);
        back.setOnClickListener(this);
        menu.setOnClickListener(this);

        listView = (PullToZoomListViewEx) findViewById(R.id.listview);
        iniPullZoom();

    }

    private void iniPullZoom() {
        String[] adapterData = new String[]{"Activity", "Service", "Content Provider", "Intent", "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient",
                "DDMS", "Android Studio", "Fragment", "Loader", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient"};

        listView.setAdapter(new ArrayAdapter<String>(PullZoomActivity.this, android.R.layout.simple_list_item_1, adapterData));
        listView.getPullRootView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("zhuwenwu", "position = " + position);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(PullZoomActivity.this, "点击："+ position, Toast.LENGTH_SHORT).show();
            }
        });

        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        AbsListView.LayoutParams localObject = new AbsListView.LayoutParams(mScreenWidth, (int) (9.0F * (mScreenWidth / 16.0F)));
        listView.setHeaderLayoutParams(localObject);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bt_back:
                finish();
                break;
            case R.id.bt_menu:
                showMene(v, 0.9f, IndicatorBuilder.GRAVITY_RIGHT);
                break;
        }

    }
    private void showMene(View v, float v1, int gravityLeft) {
        mLists.clear();
        mLists.add("Normal");
        mLists.add("Parallax");
        mLists.add("Show Head");
        mLists.add("Hide Head");
        mLists.add("Disable Zoom");
        mLists.add("Enable Zoom");

        dialog = new IndicatorBuilder(this)
                .width(300)
                .height(600)
                .ArrowDirection(IndicatorBuilder.RIGHT)
                .bgColor(Color.WHITE)
                .ArrowDirection(IndicatorBuilder.TOP)
                .gravity(gravityLeft)
                .ArrowRectage(v1)
                .radius(18)
                .layoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false))
                .adapter(new BaseAdapter() {
                    @Override
                    public void onBindView(BaseViewHolder holder, int position) {
                        TextView tv = holder.getView(R.id.item_add);
                        tv.setText(mLists.get(position));
                        if (position == mLists.size() - 1) {
                            holder.setVisibility(R.id.item_line, BaseViewHolder.GONE);
                        } else {
                            holder.setVisibility(R.id.item_line, BaseViewHolder.VISIBLE);
                        }
                    }

                    @Override
                    public int getLayoutID(int position) {
                        return R.layout.item;
                    }

                    @Override
                    public boolean clickable() {
                        return true;
                    }

                    @Override
                    public void onItemClick(View v, int position) {
                        switch (position){
                            case 0:
                                listView.setParallax(false);
                                break;
                            case 1:
                                listView.setParallax(true);
                                break;
                            case 2:
                                listView.setHideHeader(false);
                                break;
                            case 3:
                                listView.setHideHeader(true);
                                break;
                            case 4:
                                listView.setZoomEnabled(false);
                                break;
                            case 5:
                                listView.setZoomEnabled(true);
                                break;
                        }
                        dialog.dismiss();
                    }

                    @Override
                    public int getItemCount() {
                        return mLists.size();
                    }
                }).create();

        dialog.setCanceledOnTouchOutside(true);
        dialog.show(v);


    }
}
