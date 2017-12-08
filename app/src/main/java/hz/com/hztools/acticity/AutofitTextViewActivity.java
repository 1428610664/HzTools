package hz.com.hztools.acticity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import hz.com.hztools.R;
import me.grantland.widget.AutofitTextView;

/**
 * Created by pursuit on 2017/12/8.
 */

public class AutofitTextViewActivity extends AppCompatActivity {

    private EditText et_inp;
    private AutofitTextView autofitTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autofittext_view);

        et_inp = (EditText) findViewById(R.id.et_inp);
        autofitTextView = (AutofitTextView) findViewById(R.id.autofitTextView);

        et_inp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                autofitTextView.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}
