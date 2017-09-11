package com.example.junhee.customviewex;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by JunHee on 2017. 9. 11..
 */

public class JunHeeTextView extends android.support.v7.widget.AppCompatTextView {


    public JunHeeTextView(Context context) {
        super(context);
        setFace(context);

    }

    public JunHeeTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFace(context);

    }

    public JunHeeTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFace(context);

    }

    private void setFace(Context context){
        Typeface face = Typeface.createFromAsset(context.getAssets(), "NanumSquareRegular.ttf");
        this.setTypeface(face);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
