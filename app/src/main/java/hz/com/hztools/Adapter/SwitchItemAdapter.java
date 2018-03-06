package hz.com.hztools.Adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hz.com.hztools.R;
import hz.com.hztools.bean.SwitchItem;

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

public class SwitchItemAdapter extends RecyclerView.Adapter<SwitchItemAdapter.ItemViewHolder>{
    public static final int SPAN_COUNT_ONE = 1;
    public static final int SPAN_COUNT_THREE = 3;

    private static final int VIEW_TYPE_SMALL = 1;
    private static final int VIEW_TYPE_BIG = 2;

    private List<SwitchItem> mItems;
    private GridLayoutManager mLayoutManager;

    public SwitchItemAdapter(List<SwitchItem> items, GridLayoutManager layoutManager) {
        mItems = items;
        mLayoutManager = layoutManager;
    }

    @Override
    public int getItemViewType(int position) {
        int spanCount = mLayoutManager.getSpanCount();
        if (spanCount == SPAN_COUNT_ONE) {
            return VIEW_TYPE_BIG;
        } else {
            return VIEW_TYPE_SMALL;
        }
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_BIG) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_big, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_small, parent, false);
        }
        return new ItemViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        SwitchItem item = mItems.get(position % 4);
        holder.title.setText(item.getTitle());
        holder.iv.setImageResource(item.getImgResId());
        if (getItemViewType(position) == VIEW_TYPE_BIG) {
            holder.info.setText(item.getLikes() + " likes  ·  " + item.getComments() + " comments");
        }
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView title;
        TextView info;

        ItemViewHolder(View itemView, int viewType) {
            super(itemView);
            if (viewType == VIEW_TYPE_BIG) {
                iv = (ImageView) itemView.findViewById(R.id.image_big);
                title = (TextView) itemView.findViewById(R.id.title_big);
                info = (TextView) itemView.findViewById(R.id.tv_info);
            } else {
                iv = (ImageView) itemView.findViewById(R.id.image_small);
                title = (TextView) itemView.findViewById(R.id.title_small);
            }
        }
    }
}
