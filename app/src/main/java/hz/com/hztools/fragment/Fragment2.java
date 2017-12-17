package hz.com.hztools.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hz.com.hztools.Adapter.RecyclerViewAdapter;
import hz.com.hztools.Application.HzApplication;
import hz.com.hztools.R;

/**
 * Created by pursuit on 2017/12/16.
 */

public class Fragment2 extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private List<String> mData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layour_fragment_item, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        initRecyclerView();
        return view;
    }

    private void initRecyclerView() {
        mData = new ArrayList<String>();
        for(int i = 0; i < 20 ;i++){
            mData.add("item_" + i);
        }
        mAdapter = new RecyclerViewAdapter(mData);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(HzApplication.getContext()));
        mRecyclerView.setAdapter(mAdapter);
    }
}
