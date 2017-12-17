package hz.com.hztools.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by pursuit on 2017/12/16.
 */

public class MyPagerAdaper extends FragmentPagerAdapter {

    private List<Fragment> mList;
    private List<String> mTitle;

    public MyPagerAdaper(FragmentManager fm, List<Fragment> list, List<String> title) {
        super(fm);
        mList = list;
        mTitle = title;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
