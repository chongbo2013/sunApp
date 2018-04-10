package sunlearning.sunlearningdemo.utils.widegt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import sunlearning.sunlearningdemo.R;

/**
 * Created by chenny on 2018/4/3.
 */

public class NoExistDataTextTip extends View {
    private String text;
    private int icon;


    public NoExistDataTextTip(Context context) {
        super(context);
        init();
    }

    public NoExistDataTextTip(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init() {
        text = "暂无数据";
        icon = R.drawable.include_loading;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制图片
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.include_loading);
        Rect mSrcRect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Rect mDestRect = new Rect(getWidth() / 2 - bitmap.getWidth() / 2, getHeight() / 2 - bitmap.getHeight() / 2, getWidth() / 2 + bitmap.getWidth() / 2, getHeight() / 2 + bitmap.getHeight() / 2);
        canvas.drawBitmap(bitmap, null, mDestRect, new Paint());

        //绘制文字
        /**
         * 文字居中：https://blog.csdn.net/zly921112/article/details/50401976
         */
        Paint textPaint = new Paint();
        textPaint.setTextSize(60);
        textPaint.setTextAlign(Paint.Align.CENTER);
        Rect textBound = new Rect(0,0,getWidth(),40);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float top = fontMetrics.top;//为基线到字体上边框的距离,即上图中的top
        float bottom = fontMetrics.bottom;//为基线到字体下边框的距离,即上图中的bottom
        int baseLineY = (int) (textBound.centerY() - top/2 - bottom/2);//基线中间点的y轴计算公式

        canvas.drawText(text, textBound.centerX(),baseLineY+getHeight() / 2 + bitmap.getHeight() / 2, textPaint);
    }
}
