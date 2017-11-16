package vb.test.a;

import android.util.Log;

/**
 * Created by Administrator on 2017/10/25.
 */

public class Actor extends Thread {

    String TAG = "THREAD";

    @Override
    public void run() {
        Log.e(TAG, getName() + "是一个演员");
        int count = 0;
        boolean running = true;

        while (running) {
            Log.e(TAG, getName() + "登台演出" + (++count));

            if(count == 100) {
                running = false;
            }

            if(count % 10 == 0) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
