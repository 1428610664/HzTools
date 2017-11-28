package hz.com.hztools.acticity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;

import java.util.List;

import hz.com.hztools.R;

/**
 * Created by pursuit on 2017/11/27.
 */

public class ImaPickerActivity extends AppCompatActivity {

    private ImagePicker imagePicker;
    private int IMAGE_PICKER = 99;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_picker);


        Button imgPicker = (Button) findViewById(R.id.bt_img_picker);
        imgPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPic();
            }
        });

    }

    private void selectPic() {
        // 已在HzApplication.java配置初始化
        imagePicker = ImagePicker.getInstance();
        imagePicker.setMultiMode(false);   // 设置单选
        //imagePicker.setSelectLimit(9);  // 设置选择图片数量
        Intent intent = new Intent(this, ImageGridActivity.class);
        startActivityForResult(intent, IMAGE_PICKER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null && requestCode == IMAGE_PICKER) {
                List<ImageItem> imgs = (List<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                Toast.makeText(this, "选择："+imgs.size(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "没有选择", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
