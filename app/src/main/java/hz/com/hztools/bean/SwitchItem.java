package hz.com.hztools.bean;

/**
 * Created by hz on 2018/3/6.
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

public class SwitchItem {

    private int imgResId;
    private String title;
    private int likes;
    private int comments;

    public SwitchItem(int imgResId, String title, int likes, int comments) {
        this.imgResId = imgResId;
        this.title = title;
        this.likes = likes;
        this.comments = comments;
    }

    public int getImgResId() {
        return imgResId;
    }

    public String getTitle() {
        return title;
    }

    public int getLikes() {
        return likes;
    }

    public int getComments() {
        return comments;
    }

}
