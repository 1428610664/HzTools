package hz.com.hztools.acticity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.List;

import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import hz.com.hztools.R;

/**
 * Created by pursuit on 2017/11/28.
 */

public class ListViewRefreshActivity extends AppCompatActivity implements BGARefreshLayout.BGARefreshLayoutDelegate {

    private BGARefreshLayout mRefreshLayout;
    private ListView mDataLv;
//    private NormalAdapterViewAdapter mAdapter;
    private int mNewPageNumber = 0;
    private int mMorePageNumber = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_refresh);

        mRefreshLayout = (BGARefreshLayout) findViewById(R.id.refreshLayout);
        mDataLv = (ListView) findViewById(R.id.data);

        initRefreshLayout();
    }

    private void initRefreshLayout() {

    }


    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {

    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }


    class MyAdapter extends BaseAdapter{

        private List<String> stuList;
        private LayoutInflater inflater;
        public MyAdapter() {}

        public MyAdapter(List<String> stuList,Context context) {
            this.stuList = stuList;
            this.inflater=LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return stuList.size();
        }

        @Override
        public String getItem(int position) {
            return stuList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            

            return null;
        }
    }
}
