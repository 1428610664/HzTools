package hz.com.hztools.acticity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import hz.com.hztools.R;

/**
 * Created by pursuit on 2017/11/27.
 */

public class SliderActivity extends AppCompatActivity {

    private SliderLayout mTextSlider;
    private SliderLayout mtDefaultSlider;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        initTextSlider();
        initDefaultSlider();

    }

    private void initDefaultSlider() {

        mtDefaultSlider = (SliderLayout) findViewById(R.id.default_slider);

        DefaultSliderView defaultSliderView1 = new DefaultSliderView(getApplicationContext());
        defaultSliderView1.image(R.mipmap.slider1);
        defaultSliderView1.setScaleType(BaseSliderView.ScaleType.Fit);
        mtDefaultSlider.addSlider(defaultSliderView1);

        DefaultSliderView defaultSliderView2 = new DefaultSliderView(getApplicationContext());
        defaultSliderView1.image(R.mipmap.slider2);
        defaultSliderView1.setScaleType(BaseSliderView.ScaleType.Fit);
        mtDefaultSlider.addSlider(defaultSliderView2);

        DefaultSliderView defaultSliderView3 = new DefaultSliderView(getApplicationContext());
        defaultSliderView1.image(R.mipmap.slider3);
        defaultSliderView1.setScaleType(BaseSliderView.ScaleType.Fit);
        mtDefaultSlider.addSlider(defaultSliderView3);

        DefaultSliderView defaultSliderView4 = new DefaultSliderView(getApplicationContext());
        defaultSliderView1.image(R.mipmap.slider4);
        defaultSliderView1.setScaleType(BaseSliderView.ScaleType.Fit);
        mtDefaultSlider.addSlider(defaultSliderView4);

        mtDefaultSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mtDefaultSlider.setCustomAnimation(new DescriptionAnimation());
        mtDefaultSlider.setPresetTransformer(SliderLayout.Transformer.RotateDown);
        mtDefaultSlider.setDuration(3000);
    }

    private void initTextSlider() {
        mTextSlider = (SliderLayout) findViewById(R.id.text_slider);

        TextSliderView textSliderView = new TextSliderView(getApplicationContext());
        textSliderView.image(R.mipmap.slider1);
        textSliderView.description("标题1");
        textSliderView.setScaleType(BaseSliderView.ScaleType.Fit);
        mTextSlider.addSlider(textSliderView);

        TextSliderView textSliderView2 = new TextSliderView(getApplicationContext());
        textSliderView.image(R.mipmap.slider2);
        textSliderView.description("标题2");
        textSliderView.setScaleType(BaseSliderView.ScaleType.Fit);
        mTextSlider.addSlider(textSliderView2);

        TextSliderView textSliderView3 = new TextSliderView(getApplicationContext());
        textSliderView.image(R.mipmap.slider3);
        textSliderView.description("标题3");
        textSliderView.setScaleType(BaseSliderView.ScaleType.Fit);
        mTextSlider.addSlider(textSliderView3);

        TextSliderView textSliderView4 = new TextSliderView(getApplicationContext());
        textSliderView.image(R.mipmap.slider4);
        textSliderView.description("标题4");
        textSliderView.setScaleType(BaseSliderView.ScaleType.Fit);
        mTextSlider.addSlider(textSliderView4);

        mTextSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mTextSlider.setCustomAnimation(new DescriptionAnimation());
        mTextSlider.setPresetTransformer(SliderLayout.Transformer.RotateUp);
        mTextSlider.setDuration(3000);
    }
}
