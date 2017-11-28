package hz.com.hztools.city;

import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;

import hz.com.hztools.city.model.Province;

/**
 * Created by pursuit on 2017/11/18.
 */
public class CityUtil {

    private ArrayList<Province> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();

    private static CityUtil mCityUtil = null;

    private CityUtil(){
        initJsonData();
    }

    public static CityUtil getInstance(){
        if(mCityUtil == null){
            synchronized (CityUtil.class) {
                if (mCityUtil == null) {
                    mCityUtil = new CityUtil();
                }
            }
        }
        return  mCityUtil;
    }

    public ArrayList<Province> getOpt1(){
        return options1Items;
    }
    public ArrayList<ArrayList<String>> getOpt2(){
        return options2Items;
    }
    public ArrayList<ArrayList<ArrayList<String>>> getOpt3(){
        return options3Items;
    }

    private void initJsonData() {
        String JsonData  = new GetProvinceUtil().getJson("province.json");
        ArrayList<Province> jsonBean = parseData(JsonData);
        options1Items = jsonBean;
        for (int i=0;i<jsonBean.size();i++){//遍历省份
            ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）
            for (int c=0; c<jsonBean.get(i).getCityList().size(); c++){//遍历该省份的所有城市
                String CityName = jsonBean.get(i).getCityList().get(c).getName();
                CityList.add(CityName);//添加城市
                ArrayList<String> City_AreaList = new ArrayList<>();
                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (jsonBean.get(i).getCityList().get(c).getArea() == null
                        ||jsonBean.get(i).getCityList().get(c).getArea().size()==0) {
                    City_AreaList.add("");
                }else {
                    for (int d=0; d < jsonBean.get(i).getCityList().get(c).getArea().size(); d++) {//该城市对应地区所有数据
                        String AreaName = jsonBean.get(i).getCityList().get(c).getArea().get(d);
                        City_AreaList.add(AreaName);//添加该城市所有地区数据
                    }
                }
                Province_AreaList.add(City_AreaList);//添加该省所有地区数据
            }

            options2Items.add(CityList);
            options3Items.add(Province_AreaList);
        }
    }

    public ArrayList<Province> parseData(String result) {//Gson 解析
        ArrayList<Province> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                Province entity = gson.fromJson(data.optJSONObject(i).toString(), Province.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }
}
