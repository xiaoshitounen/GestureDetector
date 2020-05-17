package swu.xl.ondoubletaplistener;

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
        final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.OnGestureListener() {

            //用户轻触触摸屏
            @Override
            public boolean onDown(MotionEvent e) {
                Log.d(TAG,"down");
                return false;
            }

            //用户轻触触摸屏，尚未松开或拖动
            @Override
            public void onShowPress(MotionEvent e) {
                Log.d(TAG,"show_press");
            }

            //用户轻击屏幕后抬起
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Log.d(TAG,"single_tap_up");
                return true;
            }

            //用户按下触摸屏或者拖动
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                Log.d(TAG,"scroll");
                return true;
            }

            //用户长按触摸屏
            @Override
            public void onLongPress(MotionEvent e) {
                Log.d(TAG,"long_press");
            }

            //用户按下触摸屏，快速移动后松开
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Log.d(TAG,"fling");
                return true;
            }
        });

        //2. 设置OnDoubleTapListener接口实现类
        gestureDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {

            //1.单机事件
            //onSingleTapUp:手抬起就会执行
            //onSingleTapConfirmed:双击不会执行
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                Log.d(TAG,"single_tap_confirmed");

                return true;
            }

            //双击事件
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                Log.d(TAG,"double_tap");

                return true;
            }

            //双击间隔发生的动作
            @Override
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
