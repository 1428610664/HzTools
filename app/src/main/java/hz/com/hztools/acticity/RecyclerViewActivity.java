package hz.com.hztools.acticity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import hz.com.hztools.Adapter.RecyclerViewAdapter;
import hz.com.hztools.R;
import hz.com.hztools.widget.HZRecyclerView;

/**
 * Created by pursuit on 2017/12/11.
 */

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerViewAdapter mAdapter;
    private HZRecyclerView mRecyclerView;
    private List<String> mData;
    private View mHeaderView;
    private View mFooterView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mData = new ArrayList<String>();
        for(int i = 0; i < 10 ;i++){
            mData.add("item_" + i);
        }
        mAdapter = new RecyclerViewAdapter(mData);
        mRecyclerView = (HZRecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mHeaderView = LayoutInflater.from(this).inflate(R.layout.layout_header,mRecyclerView,false);
        mFooterView = LayoutInflater.from(this).inflate(R.layout.layout_footer,mRecyclerView,false);
        mRecyclerView.addHeaderView(mHeaderView);
        mRecyclerView.addFooterView(mFooterView);
        mRecyclerView.setAdapter(mAdapter);

    }
}
