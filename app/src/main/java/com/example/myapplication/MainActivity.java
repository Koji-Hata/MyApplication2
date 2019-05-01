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
    /* 初期実行メソッド */
    /* アプリ実行時の始めに実行されるメソッドです。 */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.numberDisplay); // Viewクラス（画面のオブジェクト群）から「numberDisplay」というIDをもつオブジェクトを取得します。
        tv.setText(DISPLAY_NUMBER); // レイアウトのnumberDisplayにクラス変数「DISPLAY_NUMBER」をセットしています。
    }

    /* １ボタン押下時 */
    public void one (View view){
            pushNumber("1");
    } // pushNumberメソッドに"1"の引数を渡して実行しています。

    /* ２ボタン押下時 */
    public void two (View view){
        pushNumber("2");
    } // pushNumberメソッドに"2"の引数を渡して実行しています。

    /* ３ボタン押下時 */
    public void tree (View view){
        pushNumber("3");
    } // pushNumberメソッドに"3"の引数を渡して実行しています。

    /* ４ボタン押下時 */
    public void four (View view){
        pushNumber("4");
    } // pushNumberメソッドに"4"の引数を渡して実行しています。

    /* ５ボタン押下時 */
    public void five (View view){
        pushNumber("5");
    } // pushNumberメソッドに"5"の引数を渡して実行しています。

    /* ６ボタン押下時 */
    public void six (View view){
        pushNumber("6");
    } // pushNumberメソッドに"6"の引数を渡して実行しています。

    /* ７ボタン押下時 */
    public void seven (View view){
        pushNumber("7");
    } // pushNumberメソッドに"7"の引数を渡して実行しています。

    /* ８ボタン押下時 */
    public void eight (View view){
        pushNumber("8");
    } // pushNumberメソッドに"8"の引数を渡して実行しています。

    /* ９ボタン押下時 */
    public void nine (View view){
        pushNumber("9");
    } // pushNumberメソッドに"9"の引数を渡して実行しています。

    /* ０ボタン押下時 */
    public void zero (View view){ pushNumber("0"); // pushNumberメソッドに"0"の引数を渡して実行しています。
    }

    /* クリアボタン押下時 */
    public void clear (View view) {
        DISPLAY_NUMBER = "0";
        TextView tv = findViewById(R.id.numberDisplay);
        TOTAL = 0;
        tv.setText(DISPLAY_NUMBER);
    }

    /* 足すボタン押下時 */
    public void tasu (View view) {
        TextView tv =  findViewById(R.id.numberDisplay);
        initFlg(); // 足すフラグを立てる前に全てのフラグを一旦クリアします。
        TFlg  = true; // 足すフラグを立てます。
        shisoku(tv.getText().toString()); // 足すフラグを立てているので、四則演算メソッドで足し算が実行されます。
        tv.setText(DISPLAY_NUMBER);
    }

    /* 引くボタン押下時 */
    public void hiku (View view) {
        TextView tv =  findViewById(R.id.numberDisplay);
        initFlg(); // 引くフラグを立てる前に全てのフラグを一旦クリアします。
        HFlg  = true; // 引くフラグを立てます。
        shisoku(tv.getText().toString()); // 引くフラグを立てているので、四則演算メソッドで引き算が実行されます。
        tv.setText(DISPLAY_NUMBER);
    }

    /* かけるボタン押下時 */
    public void kakeru (View view) {
        TextView tv =  findViewById(R.id.numberDisplay);
        initFlg(); // かけるフラグを立てる前に全てのフラグを一旦クリアします。
        Kflg = true; // かけるフラグを立てます。
        shisoku(tv.getText().toString()); // かけるフラグを立てているので、四則演算メソッドで掛け算が実行されます。
        tv.setText(DISPLAY_NUMBER);
    }

    /* わるボタン押下時 */
    public void waru (View view) {
        TextView tv =  findViewById(R.id.numberDisplay);
        initFlg(); // わるフラグを立てる前に全てのフラグを一旦クリアします。
        WFlg  = true; // わるフラグを立てます。
        shisoku(tv.getText().toString()); // わるフラグを立てているので、四則演算メソッドで割り算が実行されます。
        tv.setText(DISPLAY_NUMBER);
    }

    /* 合計ボタン押下時 */
    public void goukei(View view) {
        TextView tv =  findViewById(R.id.numberDisplay);
        shisoku(tv.getText().toString());
        String strTotal = String.valueOf(TOTAL);
        tv.setText(strTotal);
        initFlg();
        TOTAL = 0;
    }


    /* 数字ボタン押下時 */
    /* 数字ボタンを押下した値をDISPLAY_NUMBERに文字列連結します。 */
    private void pushNumber (String strNum) {
        // 0の場合は文字列連結しないようにしている。
        if (DISPLAY_NUMBER.equals("0")){
            DISPLAY_NUMBER = strNum;
        } else {
            DISPLAY_NUMBER = DISPLAY_NUMBER + strNum;
        }
        TextView tv =  findViewById(R.id.numberDisplay);
        tv.setText(DISPLAY_NUMBER);
    }

    /* 四則演算メソッド */
    /* 足す、引く、かける、わるの各フラグがtrueとなったもので四則演算を行います。 */
    private void shisoku(String strNumber) {
        int number = Integer.parseInt(strNumber);
        DISPLAY_NUMBER = "0";
        if (TOTAL == 0 ){ // 合計値が0の場合は計算していないと判断して引数の数値をそのまま格納
          TOTAL = number;
        } else if (WFlg) { // 割り算の計算
            if (number == 0){ // ゼロ割りの判定
                DISPLAY_NUMBER = "エラー";
                TOTAL = 0;
            }else {
                TOTAL = TOTAL / number;
            }
        } else if(Kflg){ // 掛け算の計算
            TOTAL = TOTAL * number;
        } else if (HFlg){ // 引き算の計算
            TOTAL = TOTAL - number;
        } else if (TFlg) { // 足し算の計算
            TOTAL = TOTAL + number;
        } else { // 条件として処理されないはずだが、入ってきた場合に初期化する
            TOTAL = 0;
        }
    }

    /* フラグ初期化 */
    /* 四則演算を行ったあとに全てのフラグを初期化します。 */
    private void initFlg(){
        WFlg = false;
        Kflg = false;
        HFlg = false;
        TFlg = false;
    }
}
