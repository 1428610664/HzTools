package hz.com.hztools.acticity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import hz.com.hztools.R;

/**
 * Created by pursuit on 2017/11/27.
 */

public class DialogsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_dialogs);

        Button dialog = (Button) findViewById(R.id.bt_dialog);
        dialog.setOnClickListener(this);
        Button inpDialog = (Button) findViewById(R.id.bt_inp_dialog);
        inpDialog.setOnClickListener(this);
        Button listDialog = (Button) findViewById(R.id.bt_list_dialog);
        listDialog.setOnClickListener(this);
        Button proDialog = (Button) findViewById(R.id.bt_pro_dialog);
        proDialog.setOnClickListener(this);
        Button radioDialog = (Button) findViewById(R.id.bt_radio_dialog);
        radioDialog.setOnClickListener(this);
        Button checkboxDialog = (Button) findViewById(R.id.bt_checkbox_dialog);
        checkboxDialog.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_dialog:
                dialogs();
                break;
            case R.id.bt_inp_dialog:
                inputDialogs();
                break;
            case R.id.bt_list_dialog:
                listDialogs();
                break;
            case R.id.bt_pro_dialog:
                ProgressDialogs();
                break;
            case R.id.bt_radio_dialog:
                radioListDialogs();
                break;
            case R.id.bt_checkbox_dialog:
                checkBoxListDialogs();
                break;
        }
    }

    /**
     * 普通弹窗
     */
    private void dialogs(){
        new MaterialDialog.Builder(this)
                .title("标题")
                .content("内容内容。。。")
                .positiveText("确认")
                .negativeText("取消")
                .backgroundColor(Color.parseColor("#ffffff"))
                .titleColor(Color.parseColor("#000000"))
                .contentColor(Color.parseColor("#000000"))
                .checkBoxPrompt("不再提醒", false, new CompoundButton.OnCheckedChangeListener() {//check事件
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            Toast.makeText(DialogsActivity.this, "选中", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(DialogsActivity.this, "不选中", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .onAny(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        if(which == DialogAction.POSITIVE){
                            Toast.makeText(DialogsActivity.this, "点击确定", Toast.LENGTH_SHORT).show();
                        }else if(which == DialogAction.NEGATIVE){
                            Toast.makeText(DialogsActivity.this, "点击取消", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .show();
    }

    /**
     * 列表弹窗
     */
    private void listDialogs(){
        new MaterialDialog.Builder(this)
                .title("List Popup")
                .items(R.array.colorArr)
                .backgroundColor(Color.parseColor("#ffffff"))
                .titleColor(Color.parseColor("#000000"))
                .contentColor(Color.parseColor("#000000"))
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        Toast.makeText(DialogsActivity.this, "选择："+text, Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    /**
     * input 弹窗
     */
    private void inputDialogs(){
        new MaterialDialog.Builder(this)
                .title("Input Dialogs")
                .content("提示：只能输入的类型-电话号码")
                .widgetColor(Color.RED)//输入框光标的颜色
                .backgroundColor(Color.parseColor("#ffffff"))
                .titleColor(Color.parseColor("#000000"))
                .contentColor(Color.parseColor("#000000"))
                .inputType(InputType.TYPE_CLASS_PHONE)//可以输入的类型-电话号码
                //前2个一个是hint一个是预输入的文字
                .input("请输入电话号码", "", new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        Toast.makeText(DialogsActivity.this,  "输入的是：" +  input, Toast.LENGTH_SHORT).show();
                    }
                })
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        if (dialog.getInputEditText().length() <=10) {
                            dialog.getActionButton(DialogAction.POSITIVE).setEnabled(false);
                        }else {
                            dialog.getActionButton(DialogAction.POSITIVE).setEnabled(true);
                        }
                    }
                })
                .show();
    }

    /**
     * 进度条弹窗
     */
    private void  ProgressDialogs(){
        new MaterialDialog.Builder(this)
                .title("提示")
                .content("正在更新App...")
                .backgroundColor(Color.parseColor("#ffffff"))
                .titleColor(Color.parseColor("#000000"))
                .contentColor(Color.parseColor("#000000"))
                .progress(true, 0)
                .show();
    }

    /**
     * 单选列表弹窗
     */
    private void radioListDialogs(){
        new MaterialDialog.Builder(this)
                .title("请选择")
                .items(R.array.colorArr)
                .backgroundColor(Color.parseColor("#ffffff"))
                .titleColor(Color.parseColor("#000000"))
                .contentColor(Color.parseColor("#000000"))
                .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        Toast.makeText(DialogsActivity.this,  "选择："+text, Toast.LENGTH_SHORT).show();
                        return true;
                    }
                })
                .positiveText("确定")
                .show();
    }

    /**
     * 多选列表弹窗
     */
    private void checkBoxListDialogs(){
        new MaterialDialog.Builder(this)
                .title("请选择：")
                .items(R.array.colorArr)
                .backgroundColor(Color.parseColor("#ffffff"))
                .titleColor(Color.parseColor("#000000"))
                .contentColor(Color.parseColor("#000000"))
                .itemsCallbackMultiChoice(null, new MaterialDialog.ListCallbackMultiChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, Integer[] which, CharSequence[] text) {
                        StringBuffer t = new StringBuffer();
                        for (int i = 0, ilen = text.length; i < ilen; i++){
                            t.append(text[i]+",");
                        }
                        if(t.length() > 0){
                            Toast.makeText(DialogsActivity.this, "选择："+t.substring(0, t.length()-1), Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(DialogsActivity.this, "暂无选择", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                })
                .positiveText("确定")
                .show();
    }

}
