package hz.com.hztools.city;

import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import hz.com.hztools.Application.HzApplication;

/**
 * Created by pursuit on 2017/11/18.
 */

public class GetProvinceUtil {

    /**
     * 获取Assets省市区数据
     * @param fileName
     * @return
     */
    public String getJson(String fileName) {

        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = HzApplication.getContext().getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
