package vb.test.a;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/10/31.
 */

public class ViewStubActivity extends AppCompatActivity {

    ViewStub viewStub;
    TextView tv_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstub);
        viewStub = (ViewStub) findViewById(R.id.viewStub);
    }

    public void inflate(View v) {
        viewStub.inflate();
//        viewStub.setVisibility(View.INVISIBLE);
        View view = findViewById(R.id.inner_content);
        view.setPadding(20,20, 20, 20);
        tv_content = (TextView) findViewById(R.id.tv_content);
    }

    public void setData(View view) {
        if(tv_content.isShown())
            tv_content.setVisibility(View.INVISIBLE);
        else
            tv_content.setVisibility(View.VISIBLE);
        tv_content.setText("电风扇地方i额外i及法国");
    }
}
