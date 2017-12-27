package hz.com.hztools.acticity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import hz.com.hztools.NodeProgressView.LogisticsData;
import hz.com.hztools.NodeProgressView.NodeProgressAdapter;
import hz.com.hztools.NodeProgressView.NodeProgressView;
import hz.com.hztools.R;

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

public class NodeProgressActivity extends AppCompatActivity {

    List<LogisticsData> logisticsDatas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_node_progress);

        logisticsDatas = new ArrayList<>();
        logisticsDatas.add(new LogisticsData().setTime("2016-6-28 15:13:02").setContext("快件在【相城中转仓】装车,正发往【无锡分拨中心】已签收,签收人是【王漾】,签收网点是【忻州原平】"));
        logisticsDatas.add(new LogisticsData().setTime("2016-6-28 15:13:02").setContext("快件在【相城中转仓】装车,正发往【无锡分拨中心】"));
        logisticsDatas.add(new LogisticsData().setTime("2016-6-28 15:13:02").setContext("【北京鸿运良乡站】的【010058.269】正在派件"));
        logisticsDatas.add(new LogisticsData().setTime("2016-6-28 15:13:02").setContext("快件到达【潍坊市中转部】,上一站是【】"));
        logisticsDatas.add(new LogisticsData().setTime("2016-6-28 15:13:02").setContext("快件在【潍坊市中转部】装车,正发往【潍坊奎文代派】"));
        logisticsDatas.add(new LogisticsData().setTime("2016-6-28 15:13:02").setContext("快件到达【潍坊】,上一站是【潍坊市中转部】"));
        logisticsDatas.add(new LogisticsData().setTime("2016-6-28 15:13:02").setContext("快件在【武汉分拨中心】装车,正发往【晋江分拨中心】"));
        logisticsDatas.add(new LogisticsData().setTime("2016-6-28 15:13:02").setContext("【北京鸿运良乡站】的【010058.269】正在派件"));
        logisticsDatas.add(new LogisticsData().setTime("2016-6-28 15:13:02").setContext("【北京鸿运良乡站】的【010058.269】正在派件"));
        logisticsDatas.add(new LogisticsData().setTime("2016-6-28 15:13:02").setContext("【北京鸿运良乡站】的【010058.269】正在派件"));
        logisticsDatas.add(new LogisticsData().setTime("2016-6-28 15:13:02").setContext("【北京鸿运良乡站】的【010058.269】正在派件"));

        NodeProgressView nodeProgressView = (NodeProgressView) findViewById(R.id.npv_NodeProgressView);
        nodeProgressView.setNodeProgressAdapter(new NodeProgressAdapter() {

            @Override
            public int getCount() {
                return logisticsDatas.size();
            }

            @Override
            public List<LogisticsData> getData() {
                return logisticsDatas;
            }
        });

    }
}
