package com.example.android;

import android.content.Context;
import android.graphics.*;
import android.view.View;

public class MyView extends View {

    public MyView(Context context) { // конструктор, необходимый для нормальной работы
        super(context);
    }

    @Override

    protected void onDraw(Canvas canvas) { // создаем метод
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStrokeWidth(5);
        paint.setColor(Color.RED);
        canvas.drawRect(190, 867, getHeight(), getHeight(), paint);
        paint.setColor(Color.GREEN);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawLine(5, 10, 15, 800, paint);
        paint.setColor(Color.MAGENTA);
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(10, 410, 350, paint);
        canvas.drawLine(0, 500, this.getWidth(), 600, paint);
        paint.setColor(Color.GREEN);
        canvas.drawLine(6900, 10, 400, 900, paint);
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(20);
        canvas.drawLine(500, 10, 450, 800, paint);
        paint.setColor(Color.CYAN);
        canvas.drawCircle(600, 750, 150, paint);
    }
}
