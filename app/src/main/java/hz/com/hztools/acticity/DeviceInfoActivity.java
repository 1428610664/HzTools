package hz.com.hztools.acticity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import hz.com.hztools.R;
import hz.com.hztools.utils.DeviceTool;

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
        if (DeviceTool.isPhone(mContext)) {
            mTvDeviceIsPhone.setText("是");
        } else {
            mTvDeviceIsPhone.setText("否");
        }

        mTvDeviceSoftwarePhoneType.setText(DeviceTool.getPhoneType(this) + "");
        mTvDeviceDensity.setText(DeviceTool.getScreenDensity(mContext) + "");
        mTvDeviceManuFacturer.setText(DeviceTool.getUniqueSerialNumber() + "");
        mTvDeviceWidth.setText(DeviceTool.getScreenWidth(mContext) + " ");
        mTvDeviceHeight.setText(DeviceTool.getScreenHeight(mContext) + " ");
        mTvDeviceVersionName.setText(DeviceTool.getAppVersionName(mContext) + "");
        mTvDeviceVersionCode.setText(DeviceTool.getAppVersionNo(mContext) + "");
        mTvDeviceImei.setText(DeviceTool.getDeviceIdIMEI(mContext) + "");
        mTvDeviceImsi.setText(DeviceTool.getIMSI(mContext) + "");
        mTvDeviceSoftwareVersion.setText(DeviceTool.getDeviceSoftwareVersion(mContext) + "");
        mTvDeviceMac.setText(DeviceTool.getMacAddress(mContext));
        mTvDeviceSoftwareMccMnc.setText(DeviceTool.getNetworkOperator(mContext) + "");
        mTvDeviceSoftwareMccMncName.setText(DeviceTool.getNetworkOperatorName(mContext) + "");
        mTvDeviceSoftwareSimCountryIso.setText(DeviceTool.getNetworkCountryIso(mContext) + "");
        mTvDeviceSimOperator.setText(DeviceTool.getSimOperator(mContext) + "");
        mTvDeviceSimSerialNumber.setText(DeviceTool.getSimSerialNumber(mContext) + "");
        mTvDeviceSimState.setText(DeviceTool.getSimState(mContext) + "");
        mTvDeviceSimOperatorName.setText(DeviceTool.getSimOperatorName(mContext) + "");
        mTvDeviceSubscriberId.setText(DeviceTool.getSubscriberId(mContext) + "");
        mTvDeviceVoiceMailNumber.setText(DeviceTool.getVoiceMailNumber(mContext) + "");
        mTvDeviceAdnroidId.setText(DeviceTool.getAndroidId(mContext) + "");
        mTvDeviceBuildBrandModel.setText(DeviceTool.getBuildBrandModel() + "");
        mTvDeviceBuildManuFacturer.setText(DeviceTool.getBuildMANUFACTURER() + "");
        mTvDeviceBuildBrand.setText(DeviceTool.getBuildBrand() + "");
        mTvDeviceSerialNumber.setText(DeviceTool.getSerialNumber() + "");
        mTvDeviceIso.setText(DeviceTool.getNetworkCountryIso(mContext) + "");
        mTvDevicePhone.setText(DeviceTool.getLine1Number(mContext) + "");

    }
}
