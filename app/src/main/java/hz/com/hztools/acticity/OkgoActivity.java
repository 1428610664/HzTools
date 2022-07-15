package hz.com.hztools.acticity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import hz.com.hztools.R;
import hz.com.hztools.bean.ServerModel;
import hz.com.hztools.callback.DialogCallback;
import hz.com.hztools.callback.JsonCallback;
import hz.com.hztools.callback.StringDialogCallback;
import hz.com.hztools.model.LzyResponse;
import hz.com.hztools.utils.ColorUtil;
import hz.com.hztools.utils.Convert;
import hz.com.hztools.utils.PhoneUtil;
import hz.com.hztools.widget.HZIndentTextView;
import okhttp3.Call;
import okhttp3.Headers;

/**
 * Created by pursuit on 2017/12/11.
 */

public class OkgoActivity extends AppCompatActivity {

    private String BaseUrl = "http://112.124.22.238:8081";
    private ImagePicker imagePicker;
    private int IMAGE_PICKER = 99;  // 图片选择结果码

    private HZIndentTextView requestStatus;
    private HZIndentTextView requestHeader;
    private HZIndentTextView responseData;
    private HZIndentTextView responseHeader;
    private NumberProgressBar mNumberbar;
    private TextView selPath;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okgo);

        requestStatus = (HZIndentTextView) findViewById(R.id.requestStatus);
        requestHeader = (HZIndentTextView) findViewById(R.id.requestHeader);
        responseData = (HZIndentTextView) findViewById(R.id.responseData);
        responseHeader = (HZIndentTextView) findViewById(R.id.responseHeader);
        requestStatus.setIndentBackground(ColorUtil.createRoundRectShape(PhoneUtil.dip2px(getApplicationContext(), 14), Color.RED));
        requestHeader.setIndentBackground(ColorUtil.createRoundRectShape(PhoneUtil.dip2px(getApplicationContext(), 14), Color.RED));
        responseData.setIndentBackground(ColorUtil.createRoundRectShape(PhoneUtil.dip2px(getApplicationContext(), 14), Color.RED));
        responseHeader.setIndentBackground(ColorUtil.createRoundRectShape(PhoneUtil.dip2px(getApplicationContext(), 14), Color.RED));
        requestStatus.setIndentText("请求状态");
        requestHeader.setIndentText("请求头");
        responseData.setIndentText("相应数据");
        responseHeader.setIndentText("相应头");

        mNumberbar = (NumberProgressBar) findViewById(R.id.numberbar);
        selPath = (TextView) findViewById(R.id.selPath);
        mNumberbar.setMax(10000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null && requestCode == IMAGE_PICKER) {
                updateImg((List<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS));
            } else {
                Toast.makeText(this, "没有选择", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void get(View v) {
        mNumberbar.setVisibility(View.GONE);
        selPath.setVisibility(View.GONE);
        OkGo.<String>get(BaseUrl + "/course_api/banner/query?type=1")
                .execute(new StringDialogCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        handleResponse(response);
                    }

                    @Override
                    public void onError(Response<String> response) {
                        handleError(response);
                    }
                });
    }

    public void post(View v) {
        mNumberbar.setVisibility(View.GONE);
        selPath.setVisibility(View.GONE);
        String logoUrl = "http://server.jeasonlzy.com/OkHttpUtils/method";
        OkGo.<String>post(logoUrl)
                .params("userName", "xxxx")
                .params("password", "xxxx")
                .isMultipart(true)
                .execute(new DialogCallback<String>(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        handleResponse(response);
                    }

                    @Override
                    public void onError(Response<String> response) {
                        handleError(response);
                    }
                });
    }

    public void update(View v) {
        selPath.setText("");
        mNumberbar.setVisibility(View.VISIBLE);
        selPath.setVisibility(View.VISIBLE);
        mNumberbar.setProgress(0);

        imagePicker = ImagePicker.getInstance();
        imagePicker.setMultiMode(false);   // 设置单选
        imagePicker.setCrop(false);        // 设置单选图片裁剪
        //imagePicker.setSelectLimit(9);  // 设置选择图片数量
        Intent intent = new Intent(this, ImageGridActivity.class);
        startActivityForResult(intent, IMAGE_PICKER);
    }

    private void updateImg(List<ImageItem> imgs){
        ArrayList<File> files = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        if (imgs != null && imgs.size() > 0) {
            for (int i = 0; i < imgs.size(); i++) {
                files.add(new File(imgs.get(i).path));
                sb.append(imgs.get(i).path + ",");
            }
            selPath.setText(sb.toString());
        }

        OkGo.<LzyResponse<ServerModel>>post("http://xxxx.com/OkHttpUtils/upload")//
                .tag(this)//
                .headers("header1", "headerValue1")//
                .headers("header2", "headerValue2")//
                .params("param1", "paramValue1")//
                .params("param2", "paramValue2")//
//                .params("file1",new File("文件路径"))   //这种方式为一个key，对应一个文件
//                .params("file2",new File("文件路径"))
//                .params("file3",new File("文件路径"))
                .addFileParams("file", files)
                .execute(new JsonCallback<LzyResponse<ServerModel>>() {
                    @Override
                    public void onSuccess(Response<LzyResponse<ServerModel>> response) {
                        handleResponse(response);
                    }

                    @Override
                    public void onError(Response<LzyResponse<ServerModel>> response) {
                        handleError(response);
                    }

                    @Override
                    public void uploadProgress(Progress progress) {
                        mNumberbar.setProgress((int) (progress.fraction * 10000));
                    }
                });
    }

    public void downloader(View v) {
        selPath.setText("正在下载...");
        mNumberbar.setVisibility(View.VISIBLE);
        selPath.setVisibility(View.VISIBLE);
        OkGo.<File>get("https://acwx.fsc.cntaiping.com:8003/TPAudit/apk/01.apk")
                .tag(this)
                .execute(new FileCallback("updateAPk.apk") {
                    @Override
                    public void onStart(Request<File, ? extends Request> request) {
                        super.onStart(request);

                    }

                    @Override
                    public void onSuccess(Response<File> response) {
                        handleResponse(response);
                        File f = response.body();
                        try {
                            String path = f.getCanonicalPath();
                            selPath.setText( "下载完成：" +path);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Response<File> response) {
                        handleError(response);
                    }

                    @Override
                    public void downloadProgress(Progress progress) {
                        mNumberbar.setProgress((int) (progress.fraction * 10000));
                    }
                });
    }


    protected <T> void handleResponse(T data) {
        Response<T> response = new Response<>();
        response.setBody(data);
        handleResponse(response);
    }

    protected <T> void handleResponse(Response<T> response) {
        StringBuilder sb;
        Call call = response.getRawCall();
        if (call != null) {
            requestStatus.setText("请求成功  请求方式：" + call.request().method() + "\n" + "url：" + call.request().url());

            Headers requestHeadersString = call.request().headers();
            Set<String> requestNames = requestHeadersString.names();
            sb = new StringBuilder();
            for (String name : requestNames) {
                sb.append(name).append(" ： ").append(requestHeadersString.get(name)).append("\n");
            }
            requestHeader.setText(sb.toString().substring(0, sb.toString().length() - 1));
        } else {
            requestStatus.setText("--");
            requestHeader.setText("--");
        }
        T body = response.body();
        if (body == null) {
            responseData.setText("--");
        } else {
            if (body instanceof String) {
                responseData.setText((String) body);
            } else if (body instanceof List) {
                sb = new StringBuilder();
                List list = (List) body;
                for (Object obj : list) {
                    sb.append(obj.toString()).append("\n");
                }
                responseData.setText(sb.toString());
            } else if (body instanceof Set) {
                sb = new StringBuilder();
                Set set = (Set) body;
                for (Object obj : set) {
                    sb.append(obj.toString()).append("\n");
                }
                responseData.setText(sb.toString());
            } else if (body instanceof Map) {
                sb = new StringBuilder();
                Map map = (Map) body;
                Set keySet = map.keySet();
                for (Object key : keySet) {
                    sb.append(key.toString()).append(" ： ").append(map.get(key)).append("\n");
                }
                responseData.setText(sb.toString());
            } else if (body instanceof File) {
                File file = (File) body;
                responseData.setText("数据内容即为文件内容\n下载文件路径：" + file.getAbsolutePath());
            } else if (body instanceof Bitmap) {
                responseData.setText("图片的内容即为数据");
            } else {
                responseData.setText(Convert.formatJson(body));
            }
        }

        okhttp3.Response rawResponse = response.getRawResponse();
        if (rawResponse != null) {
            Headers responseHeadersString = rawResponse.headers();
            Set<String> names = responseHeadersString.names();
            sb = new StringBuilder();
            sb.append("url ： ").append(rawResponse.request().url()).append("\n");
            sb.append("stateCode ： ").append(rawResponse.code()).append("\n");
            for (String name : names) {
                sb.append(name).append(" ： ").append(responseHeadersString.get(name)).append("\n");
            }
            responseHeader.setText(sb.toString());
        } else {
            responseHeader.setText("--");
        }
    }

    protected <T> void handleError() {
        Response<T> response = new Response<>();
        handleResponse(response);
    }

    protected <T> void handleError(Response<T> response) {
        if (response == null) return;
        if (response.getException() != null) response.getException().printStackTrace();
        StringBuilder sb;
        Call call = response.getRawCall();
        if (call != null) {
            requestStatus.setText("请求失败  请求方式：" + call.request().method() + "\n" + "url：" + call.request().url());

            Headers requestHeadersString = call.request().headers();
            Set<String> requestNames = requestHeadersString.names();
            sb = new StringBuilder();
            for (String name : requestNames) {
                sb.append(name).append(" ： ").append(requestHeadersString.get(name)).append("\n");
            }
            requestHeader.setText(sb.toString());
        } else {
            requestStatus.setText("--");
            requestHeader.setText("--");
        }

        responseData.setText("--");
        okhttp3.Response rawResponse = response.getRawResponse();
        if (rawResponse != null) {
            Headers responseHeadersString = rawResponse.headers();
            Set<String> names = responseHeadersString.names();
            sb = new StringBuilder();
            sb.append("stateCode ： ").append(rawResponse.code()).append("\n");
            for (String name : names) {
                sb.append(name).append(" ： ").append(responseHeadersString.get(name)).append("\n");
            }
            responseHeader.setText(sb.toString());
        } else {
            responseHeader.setText("--");
        }
    }

}
