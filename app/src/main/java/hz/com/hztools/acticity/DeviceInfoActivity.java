package hz.com.hztools.acticity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import hz.com.hztools.R;
import hz.com.hztools.utils.RxDeviceTool;

/**
 * Created by hz on 2017/12/27.
 * GitHub：https://github.com/1428610664
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG            #
 * #                                                   #
 */

public class DeviceInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_info);

        initView();

    }

    private void initView() {

        TextView mTvDeviceIsPhone = (TextView) findViewById(R.id.tv_device_is_phone);
        TextView mTvDeviceSoftwarePhoneType = (TextView) findViewById(R.id.tv_device_software_phone_type);
        TextView mTvDeviceDensity = (TextView) findViewById(R.id.tv_device_density);
        TextView mTvDeviceManuFacturer = (TextView) findViewById(R.id.tv_device_manu_facturer);
        TextView mTvDeviceWidth = (TextView) findViewById(R.id.tv_device_width);
        TextView mTvDeviceHeight = (TextView) findViewById(R.id.tv_device_height);
        TextView mTvDeviceVersionName = (TextView) findViewById(R.id.tv_device_version_name);
        TextView mTvDeviceVersionCode = (TextView) findViewById(R.id.tv_device_version_code);
        TextView mTvDeviceImei = (TextView) findViewById(R.id.tv_device_imei);
        TextView mTvDeviceImsi = (TextView) findViewById(R.id.tv_device_imsi);
        TextView mTvDeviceSoftwareVersion = (TextView) findViewById(R.id.tv_device_software_version);
        TextView mTvDeviceMac = (TextView) findViewById(R.id.tv_device_mac);
        TextView mTvDeviceSoftwareMccMnc = (TextView) findViewById(R.id.tv_device_software_mcc_mnc);
        TextView mTvDeviceSoftwareMccMncName = (TextView) findViewById(R.id.tv_device_software_mcc_mnc_name);
        TextView mTvDeviceSoftwareSimCountryIso = (TextView) findViewById(R.id.tv_device_software_sim_country_iso);
        TextView mTvDeviceSimOperator = (TextView) findViewById(R.id.tv_device_sim_operator);
        TextView mTvDeviceSimSerialNumber = (TextView) findViewById(R.id.tv_device_sim_serial_number);
        TextView mTvDeviceSimState = (TextView) findViewById(R.id.tv_device_sim_state);
        TextView mTvDeviceSimOperatorName = (TextView) findViewById(R.id.tv_device_sim_operator_name);
        TextView mTvDeviceSubscriberId = (TextView) findViewById(R.id.tv_device_subscriber_id);
        TextView mTvDeviceVoiceMailNumber = (TextView) findViewById(R.id.tv_device_voice_mail_number);
        TextView mTvDeviceAdnroidId = (TextView) findViewById(R.id.tv_device_adnroid_id);
        TextView mTvDeviceBuildBrandModel = (TextView) findViewById(R.id.tv_device_build_brand_model);
        TextView mTvDeviceBuildManuFacturer = (TextView) findViewById(R.id.tv_device_build_manu_facturer);
        TextView mTvDeviceBuildBrand = (TextView) findViewById(R.id.tv_device_build_brand);
        TextView mTvDeviceSerialNumber = (TextView) findViewById(R.id.tv_device_serial_number);
        TextView mTvDeviceIso = (TextView) findViewById(R.id.tv_device_iso);
        TextView mTvDevicePhone = (TextView) findViewById(R.id.tv_device_phone);

        Context mContext = this;
        if (RxDeviceTool.isPhone(mContext)) {
            mTvDeviceIsPhone.setText("是");
        } else {
            mTvDeviceIsPhone.setText("否");
        }

        mTvDeviceSoftwarePhoneType.setText(RxDeviceTool.getPhoneType(this) + "");
        mTvDeviceDensity.setText(RxDeviceTool.getScreenDensity(mContext) + "");
        mTvDeviceManuFacturer.setText(RxDeviceTool.getUniqueSerialNumber() + "");
        mTvDeviceWidth.setText(RxDeviceTool.getScreenWidth(mContext) + " ");
        mTvDeviceHeight.setText(RxDeviceTool.getScreenHeight(mContext) + " ");
        mTvDeviceVersionName.setText(RxDeviceTool.getAppVersionName(mContext) + "");
        mTvDeviceVersionCode.setText(RxDeviceTool.getAppVersionNo(mContext) + "");
        mTvDeviceImei.setText(RxDeviceTool.getDeviceIdIMEI(mContext) + "");
        mTvDeviceImsi.setText(RxDeviceTool.getIMSI(mContext) + "");
        mTvDeviceSoftwareVersion.setText(RxDeviceTool.getDeviceSoftwareVersion(mContext) + "");
        mTvDeviceMac.setText(RxDeviceTool.getMacAddress(mContext));
        mTvDeviceSoftwareMccMnc.setText(RxDeviceTool.getNetworkOperator(mContext) + "");
        mTvDeviceSoftwareMccMncName.setText(RxDeviceTool.getNetworkOperatorName(mContext) + "");
        mTvDeviceSoftwareSimCountryIso.setText(RxDeviceTool.getNetworkCountryIso(mContext) + "");
        mTvDeviceSimOperator.setText(RxDeviceTool.getSimOperator(mContext) + "");
        mTvDeviceSimSerialNumber.setText(RxDeviceTool.getSimSerialNumber(mContext) + "");
        mTvDeviceSimState.setText(RxDeviceTool.getSimState(mContext) + "");
        mTvDeviceSimOperatorName.setText(RxDeviceTool.getSimOperatorName(mContext) + "");
        mTvDeviceSubscriberId.setText(RxDeviceTool.getSubscriberId(mContext) + "");
        mTvDeviceVoiceMailNumber.setText(RxDeviceTool.getVoiceMailNumber(mContext) + "");
        mTvDeviceAdnroidId.setText(RxDeviceTool.getAndroidId(mContext) + "");
        mTvDeviceBuildBrandModel.setText(RxDeviceTool.getBuildBrandModel() + "");
        mTvDeviceBuildManuFacturer.setText(RxDeviceTool.getBuildMANUFACTURER() + "");
        mTvDeviceBuildBrand.setText(RxDeviceTool.getBuildBrand() + "");
        mTvDeviceSerialNumber.setText(RxDeviceTool.getSerialNumber() + "");
        mTvDeviceIso.setText(RxDeviceTool.getNetworkCountryIso(mContext) + "");
        mTvDevicePhone.setText(RxDeviceTool.getLine1Number(mContext) + "");

    }
}
