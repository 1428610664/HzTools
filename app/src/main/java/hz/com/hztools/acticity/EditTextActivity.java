package hz.com.hztools.acticity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.andreabaccega.widget.FormEditText;

import hz.com.hztools.R;

/**
 * Created by pursuit on 2017/12/7.
 */

public class EditTextActivity extends AppCompatActivity {

    private FormEditText et_alpha;
    private FormEditText et_numeric;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);

        et_alpha = (FormEditText) findViewById(R.id.et_alpha);
        et_numeric = (FormEditText) findViewById(R.id.et_numeric);

    }

    public void onClick(View v) {

        if(et_alpha.testValidity() && et_numeric.testValidity()){
            Toast.makeText(this, "输入值：" +et_alpha.getText()+ "------------" + et_numeric.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}
