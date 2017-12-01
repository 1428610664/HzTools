package hz.com.hztools.acticity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import hz.com.hztools.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button indicatorDialog = (Button) findViewById(R.id.bt_IndicatorDialog);
        indicatorDialog.setOnClickListener(this);

        Button slider = (Button) findViewById(R.id.bt_slider);
        slider.setOnClickListener(this);

        Button picker = (Button) findViewById(R.id.bt_picker);
        picker.setOnClickListener(this);

        Button dialogs = (Button) findViewById(R.id.bt_dialogs);
        dialogs.setOnClickListener(this);

        Button imagepicker = (Button) findViewById(R.id.bt_imagepicker);
        imagepicker.setOnClickListener(this);

        Button code = (Button) findViewById(R.id.bt_code);
        code.setOnClickListener(this);

        Button refresh = (Button) findViewById(R.id.bt_refresh);
        refresh.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_IndicatorDialog:
                startActivity(new Intent(getApplicationContext(), IndicatorDialogActicity.class));
                break;
            case R.id.bt_slider:
                startActivity(new Intent(getApplicationContext(), SliderActivity.class));
                break;
            case R.id.bt_picker:
                startActivity(new Intent(getApplicationContext(), PickerActivity.class));
                break;
            case R.id.bt_dialogs:
                startActivity(new Intent(getApplicationContext(), DialogsActivity.class));
                break;
            case R.id.bt_imagepicker:
                startActivity(new Intent(getApplicationContext(), ImaPickerActivity.class));
                break;
            case R.id.bt_indicator:
                startActivity(new Intent(getApplicationContext(), IndicatorActivity.class));
                break;
            case R.id.bt_code:
                startActivity(new Intent(getApplicationContext(), ZxingCodeActivity.class));
                break;
            case R.id.bt_refresh:
                startActivity(new Intent(getApplicationContext(), ZxingCodeActivity.class));
                break;
        }
    }
}
