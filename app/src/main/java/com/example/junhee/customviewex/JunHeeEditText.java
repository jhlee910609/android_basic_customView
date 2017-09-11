package com.example.junhee.customviewex;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by JunHee on 2017. 9. 11..
 */

public class JunHeeEditText extends android.support.v7.widget.AppCompatEditText implements TextWatcher, View.OnTouchListener, View.OnFocusChangeListener {

    private Drawable clearDrawable;
    private OnFocusChangeListener onFocusChangeListener;
    private OnTouchListener onTouchListener;

    public JunHeeEditText(Context context) {
        super(context);
        init();
        setFace(context);
    }

    public JunHeeEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        setFace(context);
    }

    public JunHeeEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        setFace(context);

    }

    private void setFace(Context context) {
        Typeface face = Typeface.createFromAsset(context.getAssets(), "NanumSquareRegular.ttf");
        this.setTypeface(face);
        setHint("입력입력");
    }

    private void init() {
        Drawable tempDrawable = ContextCompat.getDrawable(getContext(), R.mipmap.ic_launcher);
        clearDrawable = DrawableCompat.wrap(tempDrawable);
        DrawableCompat.setTintList(clearDrawable, getHintTextColors());
        clearDrawable.setBounds(0, 0, clearDrawable.getIntrinsicWidth(), clearDrawable.getIntrinsicHeight());

        setClearIconVisible(false);


        super.setOnTouchListener(this);
        super.setOnFocusChangeListener(this);
        addTextChangedListener(this);
    }

    @Override
    public void setOnFocusChangeListener(OnFocusChangeListener l) {
        this.onFocusChangeListener = l;
    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {
        this.onTouchListener = l;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence c, int i, int i1, int i2) {
        if(isFocused()){
            setClearIconVisible(c.length() > 0);
        }

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if(hasFocus()){
            setClearIconVisible(getText().length() > 0);
        } else {
            setClearIconVisible(false);
        }

        if(onFocusChangeListener != null){
            onFocusChangeListener.onFocusChange(view, b);
        }


    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        final int x = (int) motionEvent.getX();
        if (clearDrawable.isVisible() && x > getWidth() - getPaddingRight() - clearDrawable.getIntrinsicWidth()) {
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                setError(null);
                setText(null);
            }
            return true;
        }

        if (onTouchListener != null) {
            return onTouchListener.onTouch(view, motionEvent);
        } else {
            return false;
        }
    }


    private void setClearIconVisible(boolean visible) {
        clearDrawable.setVisible(visible, false);
        setCompoundDrawables(null, null, visible ? clearDrawable : null, null);
    }
}
