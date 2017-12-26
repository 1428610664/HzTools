package hz.com.hztools.acticity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.jaeger.ninegridimageview.NineGridImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hz.com.hztools.Adapter.NinegridAdapter;
import hz.com.hztools.Application.HzApplication;
import hz.com.hztools.R;
import hz.com.hztools.bean.Ninegrid;

import static com.jaeger.ninegridimageview.NineGridImageView.BOTTOMCOLSPAN;
import static com.jaeger.ninegridimageview.NineGridImageView.LEFTROWSPAN;
import static com.jaeger.ninegridimageview.NineGridImageView.NOSPAN;
import static com.jaeger.ninegridimageview.NineGridImageView.TOPCOLSPAN;

/**
 * Created by hz on 2017/12/26.
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

public class NinegridActivity extends AppCompatActivity {

    public static final String CONTENT = "看图，字不重要。想看大图？抱歉我还没做这个 ( •̀ .̫ •́ )";
    private RecyclerView mRvPostLister;
    private NinegridAdapter mPostAdapter;

    private ArrayList<Ninegrid> mPostList;
    private String[] IMG_URL_LIST = {
            "http://ac-QYgvX1CC.clouddn.com/36f0523ee1888a57.jpg", "http://ac-QYgvX1CC.clouddn.com/07915a0154ac4a64.jpg",
            "http://ac-QYgvX1CC.clouddn.com/9ec4bc44bfaf07ed.jpg", "http://ac-QYgvX1CC.clouddn.com/fa85037f97e8191f.jpg",
            "http://ac-QYgvX1CC.clouddn.com/de13315600ba1cff.jpg", "http://ac-QYgvX1CC.clouddn.com/15c5c50e941ba6b0.jpg",
            "http://ac-QYgvX1CC.clouddn.com/10762c593798466a.jpg", "http://ac-QYgvX1CC.clouddn.com/eaf1c9d55c5f9afd.jpg",
            "http://ac-QYgvX1CC.clouddn.com/ad99de83e1e3f7d4.jpg", "http://ac-QYgvX1CC.clouddn.com/233a5f70512befcc.jpg",
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninegrid);

        mRvPostLister = (RecyclerView) findViewById(R.id.rv_post_list);
        mRvPostLister.setLayoutManager(new LinearLayoutManager(this));

        fummuyData();
        mPostAdapter = new NinegridAdapter(this, mPostList, NineGridImageView.STYLE_FILL);
        mPostAdapter.setOnClickListener(new NinegridAdapter.OnClickListener() {
            @Override
            public void onItemImageClick(ImageView imageView, int index, List<String> list) {
                toPhoneView(index, (ArrayList<String>) list);
            }

            @Override
            public void onItemImageLongClick(ImageView imageView, int index, List<String> list) {

            }
        });

        mRvPostLister.setAdapter(mPostAdapter);

    }

    private void toPhoneView(int position, ArrayList<String> list){
        Intent intent = new Intent(HzApplication.getContext(), PhonViewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("Ninegrid", list);
        bundle.putInt("NinegridIndex", position);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void fummuyData() {
        mPostList = new ArrayList<>();

        //单张
        mPostList.add(fummuyPost(1,NOSPAN));
        //2张
        mPostList.add(fummuyPost(2,NOSPAN));

        //3张,不跨行不跨列
        mPostList.add(fummuyPost(3,NOSPAN));
        //3张,首行跨列
        mPostList.add(fummuyPost(3,TOPCOLSPAN));
        //3张,末行跨列
        mPostList.add(fummuyPost(3,BOTTOMCOLSPAN));
        //3张,首列跨行
        mPostList.add(fummuyPost(3,LEFTROWSPAN));

        //4张,不跨行不跨列
        mPostList.add(fummuyPost(4,NOSPAN));
        //4张,首行跨列
        mPostList.add(fummuyPost(4,TOPCOLSPAN));
        //4张,末行跨列
        mPostList.add(fummuyPost(4,BOTTOMCOLSPAN));
        //4张,首列跨行
        mPostList.add(fummuyPost(4,LEFTROWSPAN));

        //5张,不跨行不跨列
        mPostList.add(fummuyPost(5,NOSPAN));
        //5张,首行跨列
        mPostList.add(fummuyPost(5,TOPCOLSPAN));
        //5张,末行跨列
        mPostList.add(fummuyPost(5,BOTTOMCOLSPAN));
        //5张,首列跨行
        mPostList.add(fummuyPost(5,LEFTROWSPAN));

        //6张,不跨行不跨列
        mPostList.add(fummuyPost(6,NOSPAN));
        //6张,首行跨列
        mPostList.add(fummuyPost(6,TOPCOLSPAN));
        //6张,末行跨列
        mPostList.add(fummuyPost(6,BOTTOMCOLSPAN));
        //6张,首列跨行
        mPostList.add(fummuyPost(6,LEFTROWSPAN));
        //9张,不跨行不跨列
        mPostList.add(fummuyPost(9,NOSPAN));
    }

    private Ninegrid fummuyPost(int num, int spanType) {
        List<String> imgUrls = new ArrayList<>();
        imgUrls.addAll(Arrays.asList(IMG_URL_LIST).subList(0, num));
        return new Ninegrid(CONTENT, spanType, imgUrls);
    }

}
