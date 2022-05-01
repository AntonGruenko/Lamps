package com.example.lamps;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;

public class Lamp extends View{
    public Lamp(@NonNull Context context){
        super(context);
    }

    private Paint p = new Paint();
    private boolean toggled = false;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            toggled = !toggled;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float r = Math.min(canvas.getHeight(), canvas.getWidth()) / 2;
        if(toggled){
            p.setColor(Color.YELLOW);
        }else{
            p.setColor(Color.BLACK);
        }
        canvas.drawCircle(canvas.getWidth()/ 2,canvas.getHeight()/ 2,r, p );
    }
}
