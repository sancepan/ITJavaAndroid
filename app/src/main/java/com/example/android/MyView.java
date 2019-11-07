package com.example.android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {
    // Возвращает псевдослучайное число
    // в полуинтервале [min, max)
    float rand(float min , float max){
        return (float)(Math.random() * (max - min + 1)) + min;
    }

    // Заполняет массив псевдослучайными числами в полуинтервале [min, max)
    void fillRandom(float[] array , float min, float max){
        for (int i = 0; i < array.length; i++){
            array[i] = rand (min, max);
        }
    }

    // Прибавляет  к элементам первого массива значения элеметов второго
    // Массивы должны быть одинаковой длины!
    void addValues(float[] array , float[] values){
        for (int i = 0; i < array.length; i++){
            array[i] += values[i];
        }
    }

    int N = 10; // количество шариков
    float[] x  = new float[N];
    float[] y  = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];

    public MyView(Context context) {
        super(context);
        fillRandom(x, 0, 500);
        fillRandom(y, 0, 500);
        fillRandom(vx, -3, 3);
        fillRandom(vy, -3, 3);
    }

    @Override
    protected void onDraw(Canvas canvas){
        Paint paint = new Paint();
        super.onDraw(canvas);
        // отрисовываем все линии
        for (int i = 0; i < N - 1; i++) {

            canvas.drawCircle(x[i], y[i], 20, paint);

        }
        // готовим массивы x и у для следущего кадра
        for (int i = 0; i < N; i++) {
            if (x[i] <= 0 || x[i] >= this.getWidth()){
                vx[i] = - vx[i];
            }
            if (y[i] <= 0 || y[i] >= this.getHeight()){
                vy[i] = - vy[i];
            }
            addValues(x, vx);
            addValues(y, vy);
        }
        //запрашиваем перерисовку
        invalidate();
    }
}
