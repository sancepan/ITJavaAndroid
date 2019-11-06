package com.example.android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.view.View;

public class MyView extends View {
    double xe, ye, w;
    double x, y, h = 0.1;
    int k = 100;
    //double xmin = -2 * Math.PI, xmax = 2 * Math.PI;
    double xmin = -4, xmax = 4;

    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int x0 = this.getWidth() / 2;
        int y0 = this.getHeight() / 2;

        Paint paint = new Paint();
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextSize(30.0f);

        canvas.drawLine(x0, 0, x0, this.getHeight(), paint);
        canvas.drawText("Y", this.getWidth() / 2 + 10, 35, paint);
        canvas.drawLine(0, y0, this.getWidth(), y0, paint);
        canvas.drawText("X", this.getWidth() - 50, this.getHeight() / 2 + 50, paint);

        Path path = new Path();
        boolean first = true;
        paint.setColor(Color.BLUE);
        for (x = xmin; x < xmax; x += h) {

            y=Math.abs(x);
            //y = Math.pow(x,4);
            // y=Math.tan(x);
            // y = 3 * Math.sin(x);
            xe = x0 + k * x;
            ye = y0 - k * y;
            if (first) {
                path.moveTo((float) xe, (float) ye);
                first = false;
            } else {
                path.lineTo((float) xe, (float) ye);
            }
            canvas.drawPath(path, paint);
        }
        Path path2 = new Path();
        first = true;
        paint.setColor(Color.RED);
        for (x = xmin; x < xmax; x += h) {
            y=-x*x+3;
            // y=Math.tan(x);
            // y = 3 * Math.sin(x);
            xe = x0 + k * x;
            ye = y0 - k * y;
            if (first) {
                path2.moveTo((float) xe, (float) ye);
                first = false;
            }
            else
            {
                path2.lineTo((float) xe, (float) ye);
            }
            canvas.drawPath(path2, paint);
        }
        Path path3 = new Path();
        first = true;
        paint.setColor(Color.GREEN);
        for (x = -1.5; x < 1.6; x += h) {
            y=Math.tan(x);
            xe = x0 + k * x;
            ye = y0 - k * y;
            if (first) {
                path3.moveTo((float) xe, (float) ye);
                first = false;
            }
            else
            {
                path3.lineTo((float) xe, (float) ye);
            }
            canvas.drawPath(path3, paint);
        }
        Path path4 = new Path();
        first = true;
        paint.setColor(Color.YELLOW);
        for (x = -6; x < 6; x += h) {
             y = 3 * Math.sin(x);
            xe = x0 + k * x;
            ye = y0 - k * y;
            if (first) {
                path4.moveTo((float) xe, (float) ye);
                first = false;
            }
            else
            {
                path4.lineTo((float) xe, (float) ye);
            }
            canvas.drawPath(path4, paint);
        }
        Path path5 = new Path();
        first = true;
        paint.setColor(Color.GRAY);
        for (x = -3.1; x < 1.6; x += h) {
            y = 1/Math.tan(x);
            xe = x0 + 155 + k * x;
            ye = y0 - k * y;
            if (first) {
                path5.moveTo((float) xe, (float) ye);
                first = false;
            }
            else
            {
                path5.lineTo((float) xe, (float) ye);
            }
            canvas.drawPath(path5, paint);
        }
    }
}
