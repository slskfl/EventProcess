package com.example.eventprocess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    View view1, view2;
    TextView tvEvent;
    GestureDetector detector;
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
        //제스처 - 터치 이벤트 중에서 스크롤 등을 구별한 후 알려주는 이벤트
        detector=new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                textPrint("화면을 손가락으로 눌렀음");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                textPrint("화면을 손가락으로 눌렀다 뗌");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                textPrint("화면을 한 손가락으로 눌렀다 뗌");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                textPrint("화면을 누른 상태에서 이동함" + distanceX +" " + distanceY);
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                textPrint("화면을 손가락으로 오래 누르고 있음");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                textPrint("화면을 손가락으로 누른 채 가속도를 붙임");
                return true;
            }
        });
        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        });
    }
    void textPrint(String data){
        //append>> 내용 추가.
        tvEvent.append(data+"\n");
    }
}

