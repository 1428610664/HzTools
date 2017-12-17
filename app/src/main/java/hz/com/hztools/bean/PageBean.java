package hz.com.hztools.bean;

import android.support.v4.app.Fragment;

/**
 * Created by pursuit on 2017/12/16.
 */

public class PageBean {

    private String title;

    private Fragment mFragment;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Fragment getFragment() {
        return mFragment;
    }

    public void setFragment(Fragment fragment) {
        mFragment = fragment;
    }
}
