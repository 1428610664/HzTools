package hz.com.hztools.acticity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tapadoo.alerter.Alerter;
import com.zaaach.citypicker.CityPickerActivity;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;

import hz.com.hztools.R;
import hz.com.hztools.acticity.Base.BaseActivity;
import hz.com.hztools.expandableText.ExpandableTextActivity;
import hz.com.hztools.rick.RickTextActivity;
import hz.com.hztools.utils.AppCleanMgr;
import hz.com.hztools.utils.WebUtils;
import me.leolin.shortcutbadger.ShortcutBadger;

public class MainActivity extends BaseActivity {

    private static final int REQUEST_CODE_PICK_CITY = 233;
    private long firstTime = 0;
    private TextView mClearStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStatusBar();
        LinearLayout linear_bar = (LinearLayout) findViewById(R.id.bar_layout);
        // LinearLayout.LayoutParams.WRAP_CONTENT
        linear_bar.setBackgroundResource(R.color.colorPrimary);

        // 设置logo数字
        initShortcutBadger();

        //Log.v("hz--------", "================安全码SHA1===：" + getCertificateSHA1Fingerprint(this));

        String size = AppCleanMgr.getAppClearSize(this);
        mClearStorage = (TextView) findViewById(R.id.tb_clearStorage);
        mClearStorage.setText("清除缓存：" + size);
    }

    private void initShortcutBadger() {
        ShortcutBadger.applyCount(this, 99);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_IndicatorDialog:
                openActivity(IndicatorDialogActicity.class);
                break;
            case R.id.bt_slider:
                openActivity(SliderActivity.class);
                break;
            case R.id.bt_picker:
                openActivity(PickerActivity.class);
                break;
            case R.id.bt_dialogs:
                openActivity(DialogsActivity.class);
                break;
            case R.id.bt_imagepicker:
                openActivity(ImaPickerActivity.class);
                break;
            case R.id.bt_indicator:
                openActivity(IndicatorActivity.class);
                break;
            case R.id.bt_code:
                openActivity(ZxingCodeActivity.class);
                break;
            case R.id.bt_refresh:
                openActivity(SmartRefreshActivity.class);
                break;
            case R.id.bt_refresh2:
                openActivity(SmartRefreshActivity2.class);
                break;
            case R.id.bt_dragView:
                openActivity(DragActivity.class);
                break;
            case R.id.bt_pullZoom:
                openActivity(PullZoomActivity.class);
                break;
            case R.id.bt_dialogplus:
                openActivity(DialogplusActivity.class);
                break;
            case R.id.bt_tags:
                openActivity(FlowActivity.class);
                break;
            case R.id.bt_photoView:
                openActivity(PhonViewActivity.class);
                break;
            case R.id.bt_edittext:
                openActivity(EditTextActivity.class);
                break;
            case R.id.bt_autoText:
                openActivity(AutofitTextViewActivity.class);
                break;
            case R.id.bt_wechat:
                openActivity(WeChatActivity.class);
                break;
            case R.id.bt_swipeMenu:
                openActivity(SwipeDelMenuActivity.class);
                break;
            case R.id.bt_danmu:
                openActivity(DanmuActivity.class);
                break;
            case R.id.bt_indexText:
                openActivity(IndentTextActivity.class);
                break;
            case R.id.bt_recycler:
                openActivity(RecyclerViewActivity.class);
                break;
            case R.id.bt_okgo:
                openActivity(OkgoActivity.class);
                break;
            case R.id.bt_autolayout:
                openActivity(AutoLayoutActivity.class);
                break;
            case R.id.bt_iconfont:
                openActivity(IconfontActivity.class);
                break;
            case R.id.bt_loadding:
                openActivity(LoaddingActivity.class);
                break;
            case R.id.bt_viewpager:
                openActivity(ViewpagerActivity.class);
                break;
            case R.id.bt_numberprogressbar:
                openActivity(NumberProgressbarActivity.class);
                break;
            case R.id.bt_jsbridge:
                openActivity(JsbridgeActivity.class);
                break;
            case R.id.bt_animation:
                openActivity(AnimationActivity.class);
                break;
            case R.id.bt_AutoLinkText:
                openActivity(AutoLinkTextActivity.class);
                break;
            case R.id.bt_ninegrid:
                openActivity(NinegridActivity.class);
                break;
            case R.id.bt_filterView:
                openActivity(FilterViewActivity.class);
                break;
            case R.id.bt_scroll:
                openActivity(ScrollingActivity.class);
                break;
            case R.id.bt_video:
                openActivity(VideoActivity.class);
                break;
            case R.id.tb_NodeProgress:
                openActivity(NodeProgressActivity.class);
                break;
            case R.id.tb_deviceIndo:
                openActivity(DeviceInfoActivity.class);
                break;
            case R.id.tb_login:
                openActivity(LoginActivity.class);
                break;
            case R.id.tb_addpic:
                openActivity(AddPicViewActivity.class);
                break;
            case R.id.tb_getResource:
                openActivity(GetResourceActivity.class);
                break;
            case R.id.tb_RickText:
                openActivity(RickTextActivity.class);
                break;
            case R.id.tb_ExpandableTextView:
                openActivity(ExpandableTextViewActivity.class);
                break;
            case R.id.tb_ExpandableText:
                openActivity(ExpandableTextActivity.class);
                break;
            case R.id.tb_horizontalListView:
                openActivity(HorizontalListViewActivity.class);
                break;
            case R.id.tb_clearStorage:
                clearStorage();
                break;
            case R.id.tb_miClock:
                openActivity(MiClockActivity.class);
                break;
            case R.id.tb_BabushkaText:
                openActivity(BabushkaTextActivity.class);
                break;
            case R.id.tb_DatePicker:
                openActivity(DatePickerActivity.class);
                break;
            case R.id.tb_runTextView:
                openActivity(RunTextViewActivity.class);
                break;
            case R.id.tb_hzTitle:
                openActivity(HzTitleActivity.class);
                break;
            case R.id.tb_imageBrowser:
                openActivity(ImageBrowserActivity.class);
                break;
            case R.id.tb_rolling:
                openActivity(RollingRecyclerview.class);
                break;
            case R.id.tb_SelCity:
                startActivityForResult(new Intent(MainActivity.this, CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);
                break;
            case R.id.tb_goodview:
                openActivity(GoodViewActivity.class);
                break;
            case R.id.tb_XRichText:
                openActivity(XRichTextActivity.class);
                break;
            case R.id.tb_FinestWebView:
                WebUtils.openInternal(this, "https://github.com/1428610664");
                break;
        }
    }

    private void clearStorage() {
        /*// 清除本应用内部缓存数据
        AppCleanMgr.cleanInternalCache(this);
        // 清除本应用外部缓存数据
        AppCleanMgr.cleanExternalCache(this);
       // 清除本应用所有数据库
        AppCleanMgr.cleanDatabases(this);
        // 清除本应用SharedPreference
        AppCleanMgr.cleanSharedPreference(this);*/
        // cleanDatabaseByName  ： 根据名字清除本应用数据库
        // cleanFiles           ： 清除本应用files文件
        // 清除本应用所有的数据
        AppCleanMgr.cleanApplicationData(this);

        String size = AppCleanMgr.getAppClearSize(this);
        mClearStorage.setText("清除缓存：" + size);
    }

    public void alert(View v) {
        Alerter.create(this)
                .setTitle("Alert Title")
                .setText("Alert text...")
                .setDuration(2000)
                .setIcon(R.drawable.ic_notifications)
                .setBackgroundColorRes(R.color.primary)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (Alerter.isShowing()) {
                            Alerter.hide();
                        }
                        Toast.makeText(getApplication(), "OnClick Called", Toast.LENGTH_LONG).show();
                    }
                })
                .show();
        /*Alerter.isShowing();
        Alerter.hide();*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK) {
            if (data != null) {
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                Toast.makeText(this, "当前选择：" + city, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = secondTime;
                return true;
            } else {
                System.exit(0);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    public static PackageInfo getPackageInfo(Context context) {
        PackageInfo info = null;
        try {
            String packageName = context.getPackageName();
            info = context.getPackageManager().getPackageInfo(packageName,
                    PackageManager.GET_ACTIVITIES);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return info;
    }

    public static boolean isIntentSafe(Activity activity, Uri uri) {
        Intent mapCall = new Intent(Intent.ACTION_VIEW, uri);
        PackageManager packageManager = activity.getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(mapCall, 0);
        return activities.size() > 0;
    }

    public void openAppStore(View v) {
        Uri uri = Uri.parse(String.format("market://details?id=%s", getPackageInfo(this).packageName));
        if (isIntentSafe(this, uri)) {
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            // 没有安装市场
            Toast.makeText(this, "无法打开应用市场", Toast.LENGTH_SHORT).show();
        }
    }


    //这个是获取SHA1的方法
    public static String getCertificateSHA1Fingerprint(Context context) {
        //获取包管理器
        PackageManager pm = context.getPackageManager();
        //获取当前要获取SHA1值的包名，也可以用其他的包名，但需要注意，
        //在用其他包名的前提是，此方法传递的参数Context应该是对应包的上下文。
        String packageName = context.getPackageName();
        //返回包括在包中的签名信息
        int flags = PackageManager.GET_SIGNATURES;
        PackageInfo packageInfo = null;
        try {
            //获得包的所有内容信息类
            packageInfo = pm.getPackageInfo(packageName, flags);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        //签名信息
        Signature[] signatures = packageInfo.signatures;
        byte[] cert = signatures[0].toByteArray();
        //将签名转换为字节数组流
        InputStream input = new ByteArrayInputStream(cert);
        //证书工厂类，这个类实现了出厂合格证算法的功能
        CertificateFactory cf = null;
        try {
            cf = CertificateFactory.getInstance("X509");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //X509证书，X.509是一种非常通用的证书格式
        X509Certificate c = null;
        try {
            c = (X509Certificate) cf.generateCertificate(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String hexString = null;
        try {
            //加密算法的类，这里的参数可以使MD4,MD5等加密算法
            MessageDigest md = MessageDigest.getInstance("SHA1");
            //获得公钥
            byte[] publicKey = md.digest(c.getEncoded());
            //字节到十六进制的格式转换
            hexString = byte2HexFormatted(publicKey);
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (CertificateEncodingException e) {
            e.printStackTrace();
        }
        return hexString;
    }

    //这里是将获取到得编码进行16进制转换
    private static String byte2HexFormatted(byte[] arr) {
        StringBuilder str = new StringBuilder(arr.length * 2);
        for (int i = 0; i < arr.length; i++) {
            String h = Integer.toHexString(arr[i]);
            int l = h.length();
            if (l == 1)
                h = "0" + h;
            if (l > 2)
                h = h.substring(l - 2, l);
            str.append(h.toUpperCase());
            if (i < (arr.length - 1))
                str.append(':');
        }
        return str.toString();
    }
}
