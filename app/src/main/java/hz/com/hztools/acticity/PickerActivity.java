package hz.com.hztools.acticity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import hz.com.hztools.R;
import hz.com.hztools.city.CityUtil;
import hz.com.hztools.city.model.Province;

/**
 * Created by pursuit on 2017/11/27.
 */

public class PickerActivity extends AppCompatActivity implements View.OnClickListener {

    private TimePickerView mPvTime;
    private OptionsPickerView mPvOptions;

    private ArrayList<Province> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);

        Button timer = (Button) findViewById(R.id.bt_timer);
        timer.setOnClickListener(this);

        Button city = (Button) findViewById(R.id.bt_city);
        city.setOnClickListener(this);

        initCityPicker();
        initTimerPicker();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_timer:
                mPvTime.show();
                break;
            case R.id.bt_city:
                mPvOptions.show();
                break;
        }
    }

    private void initCityPicker() {
        CityUtil c = CityUtil.getInstance();
        options1Items = c.getOpt1();
        options2Items = c.getOpt2();
        options3Items = c.getOpt3();

        mPvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                String tx = options1Items.get(options1).getPickerViewText()+
                        options2Items.get(options1).get(options2)+
                        options3Items.get(options1).get(options2).get(options3);
                Toast.makeText(PickerActivity.this, tx, Toast.LENGTH_SHORT).show();
            }
        })
                .setTitleText("城市选择")
                .setSubmitColor(Color.WHITE)
                .setCancelColor(Color.WHITE)
                .setTitleColor(Color.WHITE)
                .setTitleBgColor(0xFFeb4f38)
                .setSubCalSize(14)
                .build();
        //mPvOptions.setPicker(options1Items);//一级选择器
        //mPvOptions.setPicker(options1Items, options2Items);//二级选择器
        mPvOptions.setPicker(options1Items, options2Items,options3Items);//三级选择器
    }

    private void initTimerPicker() {
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(2010, 0, 1);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2025, 11, 31);

        mPvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                Toast.makeText(PickerActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
            }
        })
                .setType(new boolean[]{true, true, true, false, false, false})  // 是否显示：年月日时分秒
                .setLabel("", "", "", "", "", "")   // 显示Label文字：年月日时分秒
                .setDate(selectedDate)              // 设置系统时间
                .setRangDate(startDate, endDate)    // 设置开始结束时间
                .setSubmitColor(Color.WHITE)        // 设置确定文字颜色
                .setCancelColor(Color.WHITE)        // 设置取消文字颜色
                .setTitleBgColor(0xFFeb4f38)        // 设置头部背景色
                .setSubCalSize(14)                  // 设置确定、取消文字大小
                .build();
    }

    private String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

}
