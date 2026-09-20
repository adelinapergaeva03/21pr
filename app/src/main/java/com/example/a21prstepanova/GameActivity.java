package com.example.a21prstepanova;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    public boolean Started = false;    // игра идёт
    public boolean Finished = false;   // игра окончена

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        // убираем строку состояния — во весь экран
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    // === Кнопка СТАРТ / ПАУЗА / ЗАНОВО ===
    public void Start(View view) {
        Button button = (Button) view;

        if (!Finished) {
            if (!Started) {
                // запускаем игру
                button.setBackgroundColor(Color.RED);
                button.setText("Пауза");
                Started = true;
            } else {
                // пауза
                button.setBackgroundColor(Color.GREEN);
                button.setText("Старт");
                Started = false;
            }
        } else {
            // перезапуск игры
            recreate();
        }
    }

    // === Движение красной машины (верх) ===
    public void Drive1(View view) {
        Button btnStart = findViewById(R.id.btnStart);
        ImageView car = findViewById(R.id.redCar);
        TextView result = findViewById(R.id.tvResult);
        View finishLine = findViewById(R.id.finishLine);

        if (Started && !Finished) {
            ConstraintLayout.LayoutParams params =
                    (ConstraintLayout.LayoutParams) car.getLayoutParams();
            params.leftMargin += 40;
            car.setLayoutParams(params);

            int carRight = params.leftMargin + car.getWidth();
            int finishX = finishLine.getLeft();

            if (carRight >= finishX) {
                result.setText("Победа 1 игрока!");
                result.setTextColor(0xFFFF5252);
                btnStart.setText("Заново");
                btnStart.setBackgroundColor(Color.GREEN);
                Finished = true;
            }
        }
    }

    // === Движение розовой машины (низ) ===
    public void Drive2(View view) {
        Button btnStart = findViewById(R.id.btnStart);
        ImageView car = findViewById(R.id.pinkCar);
        TextView result = findViewById(R.id.tvResult);
        View finishLine = findViewById(R.id.finishLine);

        if (Started && !Finished) {
            ConstraintLayout.LayoutParams params =
                    (ConstraintLayout.LayoutParams) car.getLayoutParams();
            params.leftMargin += 40;
            car.setLayoutParams(params);

            int carRight = params.leftMargin + car.getWidth();
            int finishX = finishLine.getLeft();

            if (carRight >= finishX) {
                result.setText("Победа 2 игрока!");
                result.setTextColor(0xFFFF80AB);
                btnStart.setText("Заново");
                btnStart.setBackgroundColor(Color.GREEN);
                Finished = true;
            }
        }
    }
}