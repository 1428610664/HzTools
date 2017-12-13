package hz.com.hztools.acticity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import hz.com.hztools.R;
import hz.com.hztools.utils.ColorUtil;
import hz.com.hztools.utils.PhoneUtil;
import hz.com.hztools.widget.HZIndentTextView;

/**
 * Created by pursuit on 2017/12/11.
 */

public class OkgoActivity extends AppCompatActivity {

    private String BaseUrl = "http://112.124.22.238:8081";
    private HZIndentTextView mIndentView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okgo);

        mIndentView = (HZIndentTextView) findViewById(R.id.textView);
        mIndentView.setIndentBackground(ColorUtil.createRoundRectShape(PhoneUtil.dip2px(getApplicationContext(),14), Color.RED));
    }

    public void get(View v){
        OkGo.<String>get(BaseUrl + "/course_api/banner/query?type=1")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        mIndentView.setIndentText("Get请求");
                        mIndentView.setText(response.body());
                    }

                    @Override
                    public void onError(Response<String> response) {
                        Log.v("hz", "失败："+response.message());
                        Toast.makeText(OkgoActivity.this, "请求失败：Get", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void post(View v){
        String logoUrl= "http://116.236.245.202:8011/TPAudit/pub/login";

        OkGo.<String>post(logoUrl)
                .params("userName", "tt1")
                .params("password", "&x2qa1k-DxM2?n7a?3")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        mIndentView.setIndentText("Post请求");
                        Log.v("hz", "onSuccess："+response.body());
                        mIndentView.setText(response.body());
                    }

                    @Override
                    public void onError(Response<String> response) {
                        Log.v("hz", "失败："+response.message());
                        Toast.makeText(OkgoActivity.this, "请求失败：Post", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void update(View v){

    }

    public void downloader(View v){

    }

}
