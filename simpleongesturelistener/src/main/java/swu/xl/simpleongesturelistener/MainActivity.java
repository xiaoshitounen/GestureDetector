package swu.xl.simpleongesturelistener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.创建手势检测器实例
        final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener(){

            public boolean onDown(MotionEvent e) {
                Log.d(TAG,"down");
                return false;
            }

            public void onShowPress(MotionEvent e) {
                Log.d(TAG,"show_press");
            }

            public void onLongPress(MotionEvent e) {
                Log.d(TAG,"long_press");
            }

            public boolean onSingleTapUp(MotionEvent e) {
                Log.d(TAG,"single_tap_up");
                return true;
            }

            public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                    float distanceX, float distanceY) {
                Log.d(TAG,"scroll");
                return true;
            }

            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                                   float velocityY) {
                Log.d(TAG,"fling");
                return true;
            }

            public boolean onSingleTapConfirmed(MotionEvent e) {
                Log.d(TAG,"single_tap_confirmed");
                return false;
            }

            public boolean onDoubleTap(MotionEvent e) {
                Log.d(TAG,"double_tap");
                return false;
            }

            public boolean onDoubleTapEvent(MotionEvent e) {
                Log.d(TAG,"double_tap_event");
                return false;
            }
        });

        //2.让某个View检测手势
        findViewById(R.id.view).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //将View的触摸事件交给GestureDetector处理
                gestureDetector.onTouchEvent(event);

                return true;
            }
        });
    }
}
