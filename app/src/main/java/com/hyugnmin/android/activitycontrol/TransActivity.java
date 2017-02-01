package com.hyugnmin.android.activitycontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.v7.view.ActionMode;



public class TransActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnTransSelec;
    EditText transEditText;
    TextView transText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);

        transEditText = (EditText) findViewById(R.id.transEditText);

        transText = (TextView) findViewById(R.id.transText);

        btnTransSelec = (Button) findViewById(R.id.btnTrans);
        btnTransSelec.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       returnValue();
        //6.액티비티를 종료하여 메인 액티비티를 화면에 나타낸다.
        finish();
    }

    @Override
    public void onBackPressed() {
        returnValue();
        super.onBackPressed();
    }

    private void returnValue() {
        Intent intent = new Intent();
        //1. 되돌려 줄 값 설정
        String result = transEditText.getText().toString();
        //2. 처리상태 설정
        int statusCode = 1;

        //3. 되돌려줄 값에 문제가 있으면 처리상태 벼경
        if(result == null || result.equals("")) {
            statusCode = 0;
        }
        //4. 되돌려 줄 값을 intent에 세팅
        intent.putExtra("result", result);

        //5.setResult함수로 결과값 전송
        setResult(statusCode, intent);

    }
}
