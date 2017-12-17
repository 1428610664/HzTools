package hz.com.hztools.acticity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import hz.com.hztools.R;
import hz.com.hztools.widget.LoadingAndRetryManager;
import hz.com.hztools.widget.OnLoadingAndRetryListener;

/**
 * Created by pursuit on 2017/12/14.
 */

public class LoaddingActivity extends AppCompatActivity {

    LoadingAndRetryManager mLoadingAndRetryManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadding);

        mLoadingAndRetryManager = LoadingAndRetryManager.generate(this, new OnLoadingAndRetryListener() {
            @Override
            public void setRetryEvent(View retryView) {
                LoaddingActivity.this.setRetryEvent(retryView);
            }
        });
        loadData();
    }

    public void retry(View v){
        loadData();
    }

    private void loadData() {
        mLoadingAndRetryManager.showLoading();

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                double v = Math.random();
                if (v > 0.8) {
                    mLoadingAndRetryManager.showContent();
                } else if (v > 0.4) {
                    mLoadingAndRetryManager.showRetry();
                } else {
                    mLoadingAndRetryManager.showEmpty();
                }
            }
        }.start();

    }

    public void setRetryEvent(View retryView) {
        View view = retryView.findViewById(R.id.id_btn_retry);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoaddingActivity.this, "retry event invoked", Toast.LENGTH_SHORT).show();
                loadData();
            }
        });
    }
}
