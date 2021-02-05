package com.example.orientationeventex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtContent;
    Button btnOk, btnChkV;
    String message="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("테스트","onCreate() 메서드 호출됨" );

        if(savedInstanceState!=null){
            message=savedInstanceState.getString("rmsg");
        }
        edtContent=findViewById(R.id.edt1);
        btnOk=findViewById(R.id.btnOk);
        btnChkV=findViewById(R.id.btnChkV);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message =edtContent.getText().toString();
            }
        });
        btnChkV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toastmsg(message);
            }
        });
    }

    void Toastmsg(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //액티비티 종료되기 전에 상태를 저장함.
        outState.putString("rmsg", message);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("테스트","onStart() 메서드 호출됨" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("테스트","onStop() 메서드 호출됨" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("테스트","onDestroy() 메서드 호출됨" );
    }
}