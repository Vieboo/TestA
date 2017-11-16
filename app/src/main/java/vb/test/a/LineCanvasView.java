package vb.test.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * Created by Administrator on 2017/11/16.
 */

public class LineCanvasView extends View {

    LinearLayout layout_title;
    ListView listView;
    Paint mPaint;

    public LineCanvasView(Context context, LinearLayout layout_title, ListView listView) {
        super(context);
        this.layout_title = layout_title;
        this.listView = listView;
        mPaint = new Paint();
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeWidth(1);
        mPaint.setColor(Color.DKGRAY);
        this.listView.setDividerHeight(0);
    }

    public LineCanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LineCanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int childHeight = layout_title.getHeight();
        int height = listView.getHeight() + childHeight;
        int width = listView.getWidth();
        int countHorizontal = layout_title.getChildCount();
        int countLine = height / childHeight;
        int itemCount = listView.getChildCount();
        canvas.drawColor(Color.TRANSPARENT);
        //listview数据不够填满布局时
        if(itemCount < countLine) {
            height = countLine * childHeight;
            canvas.drawLine(0, 0, 1, height, mPaint);
            for(int i=0; i<countHorizontal; i++) {
                View childView = layout_title.getChildAt(i);
                float startX = childView.getX() + childView.getWidth();
                canvas.drawLine(startX - 1, 0, startX, height, mPaint);
            }
            canvas.drawLine(0, 0, width, 1, mPaint);
            int tempHeight = 0;
            for(int i=0; i<countLine; i++) {
                tempHeight += childHeight;
                canvas.drawLine(0, tempHeight - 1, width, tempHeight, mPaint);
            }
        }else {
            canvas.drawLine(0, 0, 1, height, mPaint);
            for(int i=0; i<countHorizontal; i++) {
                View childView = layout_title.getChildAt(i);
                float startX = childView.getX() + childView.getWidth();
                canvas.drawLine(startX - 1, 0, startX, height, mPaint);
            }
            canvas.drawLine(0, 0, width, 1, mPaint);
            canvas.drawLine(0, childHeight - 1, width, childHeight, mPaint);
            float draw_position = 0;
            int i=itemCount-countLine;
            for ( ; i < countLine; i++) {
                View itemView = listView.getChildAt(i);
                float startY = itemView.getY();
                int itemHeight = itemView.getHeight();
                draw_position = startY + itemHeight + childHeight - 1;
                canvas.drawLine(0, draw_position, width, draw_position, mPaint);
            }
        }
    }
}
