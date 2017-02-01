package com.hyugnmin.android.activitycontrol;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private  static final String TAG = "MainActivity";
    Button btnCommon, btnTrans, btnTrans2, btnDial, btnBro, btnSms;
    EditText mainEdit, editDial, editSms, editBro;
    TextView mainTv, mainTv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCommon = (Button) findViewById(R.id.btnCommon);
        btnTrans = (Button) findViewById(R.id.btnTrans);
        btnTrans2 = (Button) findViewById(R.id.btnTrans2);
        btnDial = (Button) findViewById(R.id.btnDial);
        btnBro = (Button) findViewById(R.id.btnBro);
        btnSms = (Button) findViewById(R.id.btnSms);

        btnCommon.setOnClickListener(this);
        btnTrans.setOnClickListener(this);
        btnTrans2.setOnClickListener(this);
        btnDial.setOnClickListener(this);
        btnSms.setOnClickListener(this);
        btnBro.setOnClickListener(this);


        mainEdit = (EditText) findViewById(R.id.mainEdit);
        editDial = (EditText) findViewById(R.id.editDial);
        editSms = (EditText) findViewById(R.id.editSms);
        editBro = (EditText) findViewById(R.id.editBro);


        mainTv = (TextView) findViewById(R.id.mainTv);
        mainTv2 = (TextView) findViewById(R.id.mainTv2);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.print("onReStart 시작", TAG);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.print("onStart 시작", TAG);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.print("onResume 시작", TAG);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.print("onPause 시작", TAG);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.print("onStop 시작", TAG);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.print("onDestroy 시작", TAG);
    }

    public static final int ONE = 1;
    public static final int TWO = 2;

    @Override
    public void onClick(View view) {
        String value;
        switch (view.getId()) {
            case R.id.btnCommon:
                //액티비티로 값 넘기기
                //1. 인텐트 생성
                Intent intent = new Intent(getApplicationContext(), CommonActivity.class);
                //2. putExtra 함수에 전달할 값 설정
                intent.putExtra("var", mainEdit.getText().toString());
                //3. extra에 담긴 값을 인텐트로 전달
                startActivity(intent);
                break;


            case R.id.btnTrans:
                //호출한 액티비티로부터 값을 돌려받을 때

                //1. 인텐트 생성
                intent = new Intent(getApplicationContext(), TransActivity.class);
                //2. putExtra 함수에 전달할 값 설정
                intent.putExtra("var", mainEdit.getText().toString());
                intent.putExtra("varNum", 33333);
                startActivityForResult(intent, ONE);
                break;

            case R.id.btnTrans2:
                //호출한 액티비티로부터 값을 돌려받을 때

                //1. 인텐트 생성
                intent = new Intent(getApplicationContext(), TransActivity.class);
                //2. putExtra 함수에 전달할 값 설정
                intent.putExtra("var", mainEdit.getText().toString());
                intent.putExtra("varNum", 33333);
                startActivityForResult(intent, TWO);
                break;

            case R.id.btnDial :
                value = editDial.getText().toString();
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + value));
                startActivity(intent);
                break;

            case R.id.btnBro :
                value = editBro.getText().toString();
                intent = new Intent (Intent.ACTION_VIEW, Uri.parse("http://" + value));
                startActivity(intent);
                break;

            case R.id.btnSms :
                value = editSms.getText().toString();
                intent = new Intent (Intent.ACTION_SENDTO, Uri.parse("smsto:" + value));
                startActivity(intent);
                break;
        }
    }

    /**startActivityForResult 함수로 호출된 액티비티가 종료되면서 호출
     *
     * @param requestCode 호출시에 메인 액티비티에서 넘긴 구분값
     * @param resultCode 호출된 액티비티의 처리 상태 코드
     * @param intent 호출된 액티비티가 돌려주는 데이터
     */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        //처리상태코드
        if(requestCode == 1) {

        //1. 돌려받은 intent를 꺼내고
        Bundle bundle = intent.getExtras();
        String result = bundle.getString("result");

        //2. 호출한 측 코드를 매칭 후 값을 처리
        switch(requestCode) {
            case ONE:
                mainTv.setText(result);
                break;
            case TWO:
                mainTv2.setText(result);
                break;
        }

    }}
}
