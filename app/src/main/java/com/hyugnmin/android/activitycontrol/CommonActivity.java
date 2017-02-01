package com.hyugnmin.android.activitycontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CommonActivity extends AppCompatActivity {

    TextView commonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        commonText = (TextView) findViewById(R.id.commonText);

        //1. intent 꺼내기
        Intent intent = getIntent();
        //2. intent에서 extra 묶음 (bundle) 꺼내기
        Bundle bundle = intent.getExtras();
        //3. bundle에서 변수(타입에 맞게)꺼내기
        String str = bundle.getString("var");

        commonText.setText(str);
    }
}
