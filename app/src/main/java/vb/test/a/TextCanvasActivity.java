package vb.test.a;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2017/11/16.
 */

public class TextCanvasActivity extends AppCompatActivity {

    RelativeLayout layout_main;
    LinearLayout layout_title;
    ListView listView;
    LineCanvasView lineCanvasView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        layout_main = (RelativeLayout) findViewById(R.id.layout_main);
        layout_title = (LinearLayout) findViewById(R.id.layout_title);
        listView = (ListView) findViewById(R.id.listView);
        lineCanvasView = new LineCanvasView(TextCanvasActivity.this, layout_title, listView);
        layout_main.addView(lineCanvasView);

        listView.setAdapter(new MyAdapter());

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(null != lineCanvasView) lineCanvasView.invalidate();
            }
        });
    }


    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 25;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(TextCanvasActivity.this).inflate(R.layout.layout_canvas_item, null, false);
            return view;
        }
    }
}
