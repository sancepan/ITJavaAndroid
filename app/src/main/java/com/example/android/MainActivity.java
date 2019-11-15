package com.example.android;

import android.app.Activity;
<<<<<<< HEAD
=======
import android.content.Context;
import android.graphics.Color;
>>>>>>> master
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

<<<<<<< HEAD
public class MainActivity extends Activity {
    // Вызывается при создании Активности
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Инициализирует Активность.
        setContentView(R.layout.activity_main);
    }

    /** Вызывается при нажатии пользователем на кнопку Решить */
    public void solveEquation(View view) {
        // ax+b=c
        double a = Double.parseDouble( ((EditText)
                findViewById(R.id.coefficient_a)).getText().toString());
        double b = Double.parseDouble( ((EditText)
                findViewById(R.id.coefficient_b)).getText().toString());
        double c = Double.parseDouble( ((EditText)
                findViewById(R.id.coefficient_c)).getText().toString());
        TextView result = (TextView) findViewById(R.id.result);
        if(a == 0 && b != 0){
            result.setText("" + String.valueOf((-c / b) == -0 ? 0 : -c / b));
        } else if (a == 0 && b == 0 && c != 0){
            result.setText("" + String.valueOf("Нет корней"));
        } else if (a == 0 && b == 0 && c == 0){
            result.setText("" + String.valueOf("x может принимать любое значение"));
        } else if (a != 0 && b == 0){
            result.setText("" + String.valueOf(Math.sqrt(-c / a)) + "; " + -Math.sqrt(-c / a));
        } else if(a != 0 && b != 0 && c == 0){
            result.setText("" + String.valueOf(-b / a) + "; 0");
        } else if (a != 0 && b != 0 && c != 0){
            double d;
            d = b*b - 4*a*c;
            result.setText("" + String.valueOf((-b - Math.sqrt(d)) / (2*a) + "; " + (-b + Math.sqrt(d)) / (2*a)));
        }
        //result.setText("" + String.valueOf((c - b) / a));
    }

}
=======
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener,
        OnLongClickListener{
    int win = 0;
    private int WIDTH = 6;
    private int HEIGHT = 9;
    int[][] mines;
    private Button[][] cells;
    int[][] colls;
    int [][] flages;
    int[] Y1;
    int pov = 0;
    int kk = 10;
    int min = 1;
    int numk = 0;
    int max = 5;
    int yu = 0;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cells);
        makeCells();

        generate1();
    }

    void makeCells () {
        cells = new Button[HEIGHT][WIDTH];
        GridLayout cellsLayout = (GridLayout) findViewById(R.id.CellsLayout);
        cellsLayout.removeAllViews();
        cellsLayout.setColumnCount(WIDTH);
        for (int i = 0; i < HEIGHT-1; i++)
            for (int j = 0; j < WIDTH; j++) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                cells[i][j] = (Button) inflater.inflate(R.layout.cell, cellsLayout, false);
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                cells[i][j].setTag(i + "," + j);
                cellsLayout.addView(cells[i][j]);
            }
        for (int i = HEIGHT-1; i < HEIGHT; i++)
            for (int j = 0; j < 1; j++) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                cells[i][j] = (Button) inflater.inflate(R.layout.cell, cellsLayout, false);
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                cells[i][j].setTag(i + "," + j);
                cellsLayout.addView(cells[i][j]);
            }
    }

    void generate1 () {
        for (int i = 0; i < HEIGHT - 1; i++)
            for (int j = 0; j < WIDTH; j++) {
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                cells[i][j].setBackgroundColor(Color.WHITE);
                cells[i][j].setText("");
            }
        for (int i = HEIGHT - 1; i < HEIGHT; i++)
            for (int j = 0; j < 1; j++) {
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                cells[i][j].setBackgroundColor(Color.YELLOW);
                cells[i][j].setText("↺");
            }
        mines = new int[11][11];
        for (int i = 0; i < HEIGHT-1; i++)
            for (int j = 0; j < WIDTH; j++) {
                mines[i][j] = 0;}
    }
    void generate (int k,int YY,int XX) {
        for (int i = 0; i < HEIGHT-1; i++)
            for (int j = 0; j < WIDTH; j++) {
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                cells[i][j].setBackgroundColor(Color.WHITE);
                cells[i][j].setText("");
            }
        for (int i = HEIGHT - 1; i < HEIGHT; i++)
            for (int j = 0; j < 1; j++) {
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                cells[i][j].setBackgroundColor(Color.YELLOW);
                cells[i][j].setText("↺");
            }

        double num = Math.random();
        mines = new int[11][11];
        colls = new int[11][11];
        flages= new int[11][11];
        for (int i = 0; i < HEIGHT-1; i++)
            for (int j = 0; j < WIDTH; j++) {
                mines[i][j] = 0; colls[i][j] = 0; flages[i][j] = 0;
            }
        while (kk > 0){
            for (int i = 0; i < HEIGHT-1; i++){
                for (int j = 0; j < WIDTH; j++) {
                    if (num > 0.99 && mines[i][j] == 0 && i != YY && j != XX) {
                        mines[i][j] = 1;
                        kk--;
                        if(kk == 0){break;}
                    }
                    num = Math.random();
                }if(k == 0){break;}
            }
        }
    }

    public void Found(int Y,int X){
        if(Y > -1 && X > -1 && Y < 9 && X < 7) {
            for (int i = Y - 1; i < Y + 2; i++)
                for (int j = X - 1; j < X + 2; j++) {
                    if (i > -1 && j > -1 && i < 9 && j < 7 && mines[i][j] == 1) {
                        numk++;
                    }
                }colls[Y][X]=1;
        }
        String Num = String.valueOf(numk);
        if (flages [Y][X] == 0) cells[Y][X].setText(Num);
        if (numk==0){
            if(Y > 0 && colls[Y-1][X] == 0 && flages [Y-1][X] == 0){Found(Y-1,X);}
            if(X < 6 && Y > 0 && colls[Y-1][X+1] == 0 && flages [Y-1][X+1] == 0){Found(Y-1,X+1);}
            if(X < 6 && colls[Y][X+1] == 0 && flages [Y][X+1] == 0){Found(Y,X+1);}
            if(X < 6 && Y < 8 && colls[Y+1][X+1] == 0 && flages [Y+1][X+1] == 0){Found(Y+1,X+1);}
            if(Y < 8 && colls[Y+1][X] == 0 && flages [Y+1][X] == 0){Found(Y+1,X);}
            if(X > 0 && Y < 8 && colls[Y+1][X-1] == 0 && flages [Y+1][X-1] == 0)Found(Y+1,X-1);
            if(X > 0 && colls[Y][X-1] == 0 && flages [Y][X-1] == 0)Found(Y,X-1);
            if(X > 0 && Y > 0 && colls[Y-1][X-1] == 0 && flages [Y-1][X-1] == 0)Found(Y-1,X-1);
        }
        numk=0;
    }

    @Override
    public void onClick (View v){
        Button tappedCell = (Button) v;

//Получаем координтаты нажатой клетки
        int tappedX = getX(tappedCell);
        int tappedY = getY(tappedCell);
        int k = 0;
        if (yu == 0) {
            for (int i = 0; i < HEIGHT - 1; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    if (mines[i][j] == 1) {yu=1;}
                }
            }
        }
        if (yu == 0){generate(kk,tappedY,tappedX);yu = 2;}

        boolean tr=false;

        if (cells[tappedY][tappedX].getText() == "↺") {
            for (int i = 0; i < HEIGHT-1; i++)
                for (int j = 0; j < WIDTH; j++) {
                    cells[i][j].setText("");
                    win = 0;
                    pov = 0;
                    kk = 10;
                }
            yu = 0;
            generate1();
        }
        else if (mines[tappedY][tappedX] == 1){ Toast.makeText(this, "ВЫ ПРОИГРАЛИ", Toast.LENGTH_LONG).show();

            for (int i = 0; i < HEIGHT-1; i++)
                for (int j = 0; j < WIDTH; j++) {win=1;
                    if(mines[i][j]==1){cells[i][j].setText("\uD83D\uDCA3");} }

            for (int i = 0; i < HEIGHT-1; i++)
                for (int j = 0; j < WIDTH; j++) {win=1;
                    if(mines[i][j]==0&&cells[i][j].getText()=="\uD83D\uDEA9"){cells[i][j].setBackgroundColor(Color.RED);} }

        } else if (mines[tappedY][tappedX] == 0&&tappedY<9&&win==0){
            Found(tappedY,tappedX);
            numk = 0;

            for (int i = 0; i < HEIGHT-1; i++){
                for (int j = 0; j < WIDTH; j++){if (mines[i][j] == 0 && cells[i][j].getText() == ""){
                    k = 1; break;}
                }if(k == 1){break;}
            }

            if(k == 0 && win == 0){

                Toast.makeText(this, "ВЫ ПОБЕДИЛИ", Toast.LENGTH_LONG).show();
                pov = 1;
                for (int i = 0; i < HEIGHT-1; i++)
                    for (int j = 0; j < WIDTH; j++) {
                        if(mines[i][j] == 1){cells[i][j].setText("\uD83D\uDEA9");}}
            }
        }
    }

    int getX (View v){
        return Integer.parseInt(((String) v.getTag()).split(",")[1]);
    }

    int getY (View v){
        return Integer.parseInt(((String) v.getTag()).split(",")[0]);
    }

    @Override
    public boolean onLongClick (View v){
        Button tappedCell = (Button) v;
        String OB = "";
        int tappedX = getX(tappedCell);
        int tappedY = getY(tappedCell);

        if (cells[tappedY][tappedX].getText() == "") {
            cells[tappedY][tappedX].setText("\uD83D\uDEA9");flages [tappedY][tappedX] = 1;
        } else if (cells[tappedY][tappedX].getText() == "\uD83D\uDEA9")
        {cells[tappedY][tappedX].setText(OB);flages [tappedY][tappedX] = 0;}

        return true;
    }
}
>>>>>>> master
