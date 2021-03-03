package com.dima.viktorina;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelavels);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        TextView textView10 = (TextView) findViewById(R.id.textView10);
        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //Вызов диалогового окна
                    dialog = new Dialog(GameLevels.this); //Создаёт новое диалоговое окно
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //Скрываем шапку диалога
                    dialog.setContentView(R.layout.dialog_warning); //Путь к макету
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //Прозрачный фон диалогового окна
                    dialog.setCancelable(false); //Окно нельзя закрыть системными кнопками

                    //Кнопка закрытия диалогового окна - начало
                    //pass
                    //Кнопка закрытия диалогового окна - конец

                    //Кнопка "Продолжить" - начало

                    Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
                    btncontinue.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            try {
                                dialog.dismiss();
                            }catch (Exception e){

                            }
                        }
                    });

                    //Кнопка "Продолжить" - конец

                    dialog.show(); //Показ окна
                }catch (Exception e){

                }
            }
        });

        TextView textView11 = (TextView) findViewById(R.id.textView11);
        textView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //Вызов диалогового окна
                    dialog = new Dialog(GameLevels.this); //Создаёт новое диалоговое окно
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //Скрываем шапку диалога
                    dialog.setContentView(R.layout.dialog_warning); //Путь к макету
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //Прозрачный фон диалогового окна
                    dialog.setCancelable(false); //Окно нельзя закрыть системными кнопками

                    //Кнопка закрытия диалогового окна - начало
                    //pass
                    //Кнопка закрытия диалогового окна - конец

                    //Кнопка "Продолжить" - начало

                    Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
                    btncontinue.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            try {
                                dialog.dismiss();
                            }catch (Exception e){

                            }
                        }
                    });

                    //Кнопка "Продолжить" - конец

                    dialog.show(); //Показ окна
                }catch (Exception e){

                }
            }
        });

        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // конструкция try - catch - это ловитель ошибок
                try {
                    Intent intent = new Intent(GameLevels.this, MainActivity.class); //есть намерение перейти с Gamelevels в окно MainActivity
                    startActivity(intent); finish(); //запуск процедуры перехода и команда finish закрывает текущее окно
                }catch (Exception e){

                }
            }
        });

        //Кнопка перехода на 1 уровень - начало
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try {
                   Intent intent = new Intent(GameLevels.this, Lavel1.class);
                   startActivity(intent); finish();
               }catch (Exception e){

               }
            }
        });
        //Кнопка перехода на 1 уровень - конец


        //Кнопка 2 уровня - начало
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent2 = new Intent(GameLevels.this, Lavel2.class);
                    startActivity(intent2); finish();
                }catch (Exception e){

                }
            }
        });
        //Кнопка 2 уровня - конец

        //Кнопка 3 уровня - начало
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent3 = new Intent(GameLevels.this, Lavel3.class);
                    startActivity(intent3); finish();
                }catch (Exception e){

                }
            }
        });
        //Кнопка 3 уровня - конец

        //Кнопка 4 уровня - начало
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent4 = new Intent(GameLevels.this, Lavel4.class);
                    startActivity(intent4); finish();
                }catch (Exception e){

                }
            }
        });
        //Кнопка 4 уровня - конец

        //Кнопка 5 уровня - начало
        TextView textView5 = (TextView)findViewById(R.id.textView5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent5 = new Intent(GameLevels.this, Lavel5.class);
                    startActivity(intent5); finish();
                }catch (Exception e){

                }
            }
        });
        //Кнопка 5 уровня - конец

        //Кнопка 6 уровня - начало
        TextView textView6 = (TextView)findViewById(R.id.textView6);
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent6 = new Intent(GameLevels.this, Lavel6.class);
                    startActivity(intent6); finish();
                }catch (Exception e){

                }
            }
        });
        //Кнопка 6 уровня - конец

        //Кнопка 7 уровня - начало
        TextView textView7 = (TextView)findViewById(R.id.textView7);
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent7 = new Intent(GameLevels.this, Lavel7.class);
                    startActivity(intent7); finish();
                }catch (Exception e){

                }
            }
        });
        //Кнопка 7 уровня - конец

        //Кнопка 8 уровня - начало
        TextView textView8 = (TextView)findViewById(R.id.textView8);
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent8 = new Intent(GameLevels.this, Lavel8.class);
                    startActivity(intent8); finish();
                }catch (Exception e){

                }
            }
        });
        //Кнопка 8 уровня - конец

        //Кнопка 8 уровня - начало
        TextView textView9 = (TextView)findViewById(R.id.textView9);
        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent9 = new Intent(GameLevels.this, Lavel9.class);
                    startActivity(intent9); finish();
                }catch (Exception e){

                }
            }
        });
        //Кнопка 8 уровня - конец

    }
    //Системная кнопка "Назад" - начало
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(GameLevels.this, MainActivity.class); //есть намерение перейти с Gamelevels в окно MainActivity
            startActivity(intent); finish(); //запуск процедуры перехода и команда finish закрывает текущее окно
        }catch (Exception e){
        }
    }
    //Системная кнопка "Назад" - конец
}