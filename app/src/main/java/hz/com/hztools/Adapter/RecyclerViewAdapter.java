package hz.com.hztools.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import hz.com.hztools.Application.HzApplication;
import hz.com.hztools.R;

/**
 * Created by pursuit on 2017/12/11.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    public List<String> mData;
    public RecyclerViewAdapter(List<String> data){
        mData = data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTextView.setText(mData.get(position));
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HzApplication.getContext(), "点击：" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ViewHolder(View view){
            super(view);
            mTextView = (TextView) view.findViewById(R.id.tvCity);
        }
    }
}