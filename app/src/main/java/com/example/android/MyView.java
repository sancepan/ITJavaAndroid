package com.example.android;

import android.content.Context;
//import android.graphics.Canvas;
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
        int y = canvas.getHeight();
        int x = 0;
        while (y > 0) {
            canvas.drawLine(0, y,
                    x, canvas.getHeight(), paint);
            y -= canvas.getHeight()/20;
            x += this.getWidth()/20;
        }
        y = canvas.getHeight() - 70;
        x = 50;
        while (y > 0) {
            canvas.drawLine(x, 0,
                    this.getWidth(), y, paint);
            y -= canvas.getHeight()/20;
            x += this.getWidth()/20;
        }
    }
}
