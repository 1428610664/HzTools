package hz.com.hztools.acticity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bm.library.PhotoView;

import hz.com.hztools.R;

/**
 * Created by pursuit on 2017/12/6.
 */

public class PhonViewActivity extends AppCompatActivity {

    private ViewPager mPager;
    private TextView mNum;

    private int[] imgsId = new int[]{R.mipmap.slider1, R.mipmap.slider2, R.mipmap.slider3, R.mipmap.slider4};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photoview);

        init();

    }

    private void init() {
        mPager = (ViewPager) findViewById(R.id.pager);
        mNum = (TextView) findViewById(R.id.tv_num);
        mNum.setText("1/" + imgsId.length);

        mPager.setPageMargin((int) (getResources().getDisplayMetrics().density * 15));
        mPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imgsId.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                PhotoView view = new PhotoView(PhonViewActivity.this);
                view.enable();
                view.setScaleType(ImageView.ScaleType.FIT_CENTER);
                view.setImageResource(imgsId[position]);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });

        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mNum.setText( ( position + 1 ) + "/" + imgsId.length);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
