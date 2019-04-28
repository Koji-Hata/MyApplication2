package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*表示用*/
    private String DISPLAY_NUMBER = "0";

    /*合計値*/
    private int TOTAL = 0;

    /*足すフラグ*/
    private boolean TFlg = false;

    /*引くフラグ*/
    private boolean HFlg = false;

    /*かけるフラグ*/
    private boolean Kflg = false;

    /*わるフラグ*/
    private boolean WFlg = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.numberDisplay);
        tv.setText(DISPLAY_NUMBER);
    }

    /* １ボタン押下時 */
    public void one (View view){
            pushNumber(view,"1");
    }

    /* ２ボタン押下時 */
    public void two (View view){
        pushNumber(view,"2");
    }

    /* ３ボタン押下時 */
    public void tree (View view){
        pushNumber(view,"3");
    }

    /* ４ボタン押下時 */
    public void four (View view){
        pushNumber(view,"4");
    }

    /* ５ボタン押下時 */
    public void five (View view){
        pushNumber(view,"5");
    }

    /* ６ボタン押下時 */
    public void six (View view){
        pushNumber(view,"6");
    }

    /* ７ボタン押下時 */
    public void seven (View view){
        pushNumber(view,"7");
    }

    /* ８ボタン押下時 */
    public void eight (View view){
        pushNumber(view,"8");
    }

    /* ９ボタン押下時 */
    public void nine (View view){
        pushNumber(view,"9");
    }

    /* ０ボタン押下時 */
    public void zero (View view){ pushNumber(view,"0");
    }

    /* クリアボタン押下時 */
    public void clear (View view) {
        DISPLAY_NUMBER = "0";
        TextView tv = (TextView) findViewById(R.id.numberDisplay);
        TOTAL = 0;
        tv.setText(DISPLAY_NUMBER);
    }

    /* 足すボタン押下時 */
    public void tasu (View view) {
        TextView tv = (TextView) findViewById(R.id.numberDisplay);
        initFlg();
        TFlg  = true;
        shisoku(tv.getText().toString());
        tv.setText(DISPLAY_NUMBER);
    }

    /* 引くボタン押下時 */
    public void hiku (View view) {
        TextView tv = (TextView) findViewById(R.id.numberDisplay);
        initFlg();
        HFlg  = true;
        shisoku(tv.getText().toString());
        tv.setText(DISPLAY_NUMBER);
    }

    /* かけるボタン押下時 */
    public void kakeru (View view) {
        TextView tv = (TextView) findViewById(R.id.numberDisplay);
        initFlg();
        Kflg = true;
        shisoku(tv.getText().toString());
        tv.setText(DISPLAY_NUMBER);
    }

    /* わるボタン押下時 */
    public void waru (View view) {
        TextView tv = (TextView) findViewById(R.id.numberDisplay);
        initFlg();
        WFlg  = true;
        shisoku(tv.getText().toString());
        tv.setText(DISPLAY_NUMBER);
    }

    /* 合計ボタン押下時 */
    public void goukei(View view) {
        TextView tv = (TextView) findViewById(R.id.numberDisplay);
        shisoku(tv.getText().toString());
        String strTotal = String.valueOf(TOTAL);
        tv.setText(strTotal);
        initFlg();
        TOTAL = 0;
    }


    /* 数字ボタン押下時 */
    private void pushNumber (View view,String strNum) {
        if (DISPLAY_NUMBER.equals("0")){
            DISPLAY_NUMBER = strNum;
        } else {
            DISPLAY_NUMBER = DISPLAY_NUMBER + strNum;
        }
        TextView tv = (TextView) findViewById(R.id.numberDisplay);
        tv.setText(DISPLAY_NUMBER);
    }

    /* 四則演算メソッド */
    /* 足す、引く、かける、わるの各フラグがtrueとなったもので四則演算を行います。 */
    private void shisoku(String strNumber) {
        int number = Integer.parseInt(strNumber);
        DISPLAY_NUMBER = "0";
        if (TOTAL == 0 ){
          TOTAL = number;
        } else if (WFlg) {
            if (number == 0){
                DISPLAY_NUMBER = "エラー";
                TOTAL = 0;
            }else {
                TOTAL = TOTAL / number;
            }
        } else if(Kflg){
            TOTAL = TOTAL * number;
        } else if (HFlg){
            TOTAL = TOTAL - number;
        } else if (TFlg) {
            TOTAL = TOTAL + number;
        } else {

        }
    }

    /* フラグ初期化 */
    /* 四則演算を行ったあとにフラグを初期化します。 */
    private void initFlg(){
        WFlg = false;
        Kflg = false;
        HFlg = false;
        TFlg = false;
    }
}
