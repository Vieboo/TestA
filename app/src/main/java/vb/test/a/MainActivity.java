package vb.test.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    String TAG = "TestHandlerThread";
    HandlerThread mHandlerThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postRunnable();
        handlerThread();
    }

    private void postRunnable() {
        Handler runnHandler = new Handler();
        runnHandler.post(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "Runnable-->" + Thread.currentThread().getName());
            }
        });
    }

    private void handlerThread() {
        mHandlerThread = new HandlerThread("testHandlerThreadName");
        mHandlerThread.start();
        Handler htHandler = new Handler(mHandlerThread.getLooper(), new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                Log.e(TAG, "HandlerThread-->" + Thread.currentThread().getName());
                return false;
            }
        });
        htHandler.sendEmptyMessage(0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(null != mHandlerThread) mHandlerThread.quit();
    }
}
