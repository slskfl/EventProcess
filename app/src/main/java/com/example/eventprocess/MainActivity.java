package com.example.eventprocess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    View view1, view2;
    TextView tvEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view1=findViewById(R.id.view1);
        view2=findViewById(R.id.view2);
        tvEvent=findViewById(R.id.tvEvent);

        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float x=event.getX();
                float y=event.getY();
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        textPrint("손가락을 눌렀음>> "+x+" " +y);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        textPrint("손가락을 움직였음>> "+x+" " +y);
                        break;
                    case MotionEvent.ACTION_UP:
                        textPrint("손가락을 뗌>> "+x+" " +y);
                        break;
                }
                return true;
            }
        });
    }
    void textPrint(String data){
        //append>> 내용 추가.
        tvEvent.append(data+"\n");
    }
}