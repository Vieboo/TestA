package vb.test.a;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/10/31.
 */

public class MergeTestActivity extends AppCompatActivity {


    private String TAG = "Merge";

    TextView text1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merge2);

        text1 = (TextView) findViewById(R.id.text1);
//        text1.setText("&#8226;");

        Log.i(TAG, "str_phone --> " + getResources().getString(R.string.str_phone));
        Log.i(TAG, "str_service --> " + getResources().getString(R.string.str_service));
        Log.i(TAG, "str_contact --> " + getResources().getString(R.string.str_contact));
    }
}
