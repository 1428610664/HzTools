package hz.com.hztools.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;

import java.util.Date;

/**
 * Created by pursuit on 2017/12/10.
 */

public class PhoneUtil {

    public static int TAB_BOTTOM_TYPE = 0;
    public static int TAB_TOP_TYPE = 0;
    private static boolean deviceDataInited = false;
    private static float displayMetricsDensity;
    private static int displayMetricsWidthPixels;
    private static int displayMetricsHeightPixels;
    private static int SCREEN_WIDTH_PX_CACHE = -1;
    private static int SCREEN_HEIGHT_PX_CACHE = -1;

    public static void initDeviceData(Context context) {
        DisplayMetrics displayMetrics = null;
        if (context.getResources() != null && (displayMetrics = context.getResources().getDisplayMetrics()) != null) {
            displayMetricsDensity = displayMetrics.density;
            displayMetricsWidthPixels = displayMetrics.widthPixels;
            displayMetricsHeightPixels = displayMetrics.heightPixels;
        }
        deviceDataInited = true;
    }

    public static int sp2px(Context context, float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, context.getResources().getDisplayMetrics());
    }


    public static int dip2px(Context context, float dipValue) {
        if (!deviceDataInited) {
            initDeviceData(context);
        }

        return (int) (dipValue * displayMetricsDensity + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        if (!deviceDataInited) {
            initDeviceData(context);
        }

        return (int) (pxValue / displayMetricsDensity + 0.5f);
    }

    public static int getScreenWidthPx(Context context) {
        if (SCREEN_WIDTH_PX_CACHE < 0) {
            Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
            SCREEN_WIDTH_PX_CACHE = display.getWidth();
        }

        return SCREEN_WIDTH_PX_CACHE;
    }

    public static int getScreenHeightPx(Context context) {
        if (SCREEN_HEIGHT_PX_CACHE < 0) {
            Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
            SCREEN_HEIGHT_PX_CACHE = display.getHeight();
        }

        return SCREEN_HEIGHT_PX_CACHE;
    }

    /**
     * 以友好的方式显示时间
     * @param time
     * @return
     */
    public static String getFriendlyTime(Date time) {
        //获取time距离当前的秒数
        int ct = (int)((System.currentTimeMillis() - time.getTime())/1000);
        if(ct == 0) {
            return "刚刚";
        }
        if(ct > 0 && ct < 60) {
            return ct + "秒前";
        }
        if(ct >= 60 && ct < 3600) {
            return Math.max(ct / 60,1) + "分钟前";
        }
        if(ct >= 3600 && ct < 86400)
            return ct / 3600 + "小时前";
        if(ct >= 86400 && ct < 2592000){ //86400 * 30
            int day = ct / 86400 ;
            return day + "天前";
        }
        if(ct >= 2592000 && ct < 31104000) { //86400 * 30
            return ct / 2592000 + "月前";
        }
        return ct / 31104000 + "年前";
    }

}
