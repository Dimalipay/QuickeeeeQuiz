package com.dima.viktorina;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.media.MediaPlayer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class Lavel5 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogExit;
    private AdView adView;

    public int numLeft; //Переменная для левой части
    public int numRight; //Переменная для правой части
    Array array = new Array();
    Random random = new Random(); //Переменная для генерации случайных чисел
    public int count = 0; //Счётчик правельных ответов
    private final float maxVolume = 100.0f;
    private float currentVolume = 5.0f;

    MediaPlayer player;
    MediaPlayer player1;
    MediaPlayer player2;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //Рекламный банер - начало
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-6157182552660079~8128665018");
        adView = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        //Рекламный банер - конец

        //Фоновая музыка - начало
        player = MediaPlayer.create(this, R.raw.track1);
        player.setLooping(true);
        player.setVolume(currentVolume / maxVolume, currentVolume / maxVolume);
        //Фоновая музыка - конец

        //Создаём переменную text_levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.lavel5); //Задали текст

        //Код для скругления углов у картинки
        final ImageView img_left = (ImageView) findViewById(R.id.img_left);
        img_left.setClipToOutline(true);

        final ImageView img_right = (ImageView) findViewById(R.id.img_right);
        img_right.setClipToOutline(true);
        //Конец скругления углов картинки

        //Путь к левому TextViev
        final TextView text_left =  findViewById(R.id.text_left);
        //Путь к правому TextViev
        final TextView text_right = findViewById(R.id.text_right);


        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Lavel5.this, GameLevels.class);
                    startActivity(intent); finish();

                    player.stop();

                }catch (Exception e){

                }
            }
        });

        //Игра на весь экран - начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //Игра на весь экран - конец

        //Устанавливаем Bg - начало
        ImageView background = (ImageView) findViewById(R.id.background);
        background.setImageResource(R.drawable.universal_lavel3);
        //Устанавливаем Bg - конец

          //Вызов диалогового окна
        dialog = new Dialog(this); //Создаёт новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //Скрываем шапку диалога
        dialog.setContentView(R.layout.dialog_prev); //Путь к макету
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //Прозрачный фон диалогового окна
        dialog.setCancelable(false); //Окно нельзя закрыть системными кнопками

        //Картинка для диалогового окна - начало
        ImageView imgprev = (ImageView)dialog.findViewById(R.id.imgprev);
        imgprev.setImageResource(R.drawable.img_prev_dialog5);
        //Картинка для диалогового окна - конец

        LinearLayout dialogfon = (LinearLayout)dialog.findViewById(R.id.dialogfon);
        dialogfon.setBackgroundResource(R.drawable.prev_dialog_bg_lavel4);

        //Текст для диалогового окна - начало
        TextView textdescription = (TextView)dialog.findViewById(R.id.dialogtext);
        textdescription.setText(R.string.levelfive);
        //Текст дя диалогового окна - конец

        //Кнопка закрытия диалогового окна - начало
        TextView btncloce = (TextView)dialog.findViewById(R.id.btncloce);
        btncloce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //Возвращение к выбору уровня
                    Intent intent = new Intent(Lavel5.this, GameLevels.class);
                    startActivity(intent); finish();

                    player.stop();

                }catch (Exception e){

                }
                dialog.dismiss();
            }
        });

        //Кнопка закрытия диалогового окна - конец

        //Кнопка "Продолжить" - начало

        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dialog.dismiss();

                    player.start();

                }catch (Exception e){

                }
            }
        });

        //Кнопка "Продолжить" - конец

        dialog.show(); //Показ окна

        //___________
        dialogExit = new Dialog(this); //Создаёт новое диалоговое окно
        dialogExit.requestWindowFeature(Window.FEATURE_NO_TITLE); //Скрываем шапку диалога
        dialogExit.setContentView(R.layout.dialog_exit); //Путь к макету
        dialogExit.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //Прозрачный фон диалогового окна
        dialogExit.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialogExit.setCancelable(false); //Окно нельзя закрыть системными кнопками

        LinearLayout dialogfonexit =(LinearLayout)dialogExit.findViewById(R.id.dialogfon_exit);
        dialogfonexit.setBackgroundResource(R.drawable.prev_dialog_bg_lavel4);

        TextView textExit = (TextView)dialogExit.findViewById(R.id.dialogtextexit);
        textExit.setText(R.string.dialogtextexit5);

        //Кнопка закрытия диалогового окна - начало

        TextView btncloce2 = (TextView)dialogExit.findViewById(R.id.btncloce);
        btncloce2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //Возвращение к выбору уровня
                    Intent intent = new Intent(Lavel5.this, GameLevels.class);
                    startActivity(intent); finish();

                    player.stop();

                }catch (Exception e){

                }
                dialogExit.dismiss();
            }
        });

        //Кнопка закрытия диалогового окна - конец

        //Кнопка "Продолжить" - начало

        Button btncontinue2 = (Button)dialogExit.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent2 = new Intent(Lavel5.this, GameLevels.class);
                    startActivity(intent2); finish();

                    player.stop();

                }catch (Exception e){

                }
            }
        });

        //Кнопка "Продолжить" - конец

        //_________________

        //Массив для заполнеия прогресса игры - начало
        final int [] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,
                R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
                R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15,
                R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20,
        };
        //Массив для заполнеия прогресса игры - конец

        //Подключаем анимацию - начало
        final Animation a = AnimationUtils.loadAnimation(Lavel5.this, R.anim.alpha);
        //Подключаем анимацию - конец

        //Звук ответа true - начало
        player1 = MediaPlayer.create(this, R.raw.true1);
        player1.setVolume(currentVolume / maxVolume, currentVolume / maxVolume);
        //Звук ответа true - конец

        //Звук ответа false - начало
        player2 = MediaPlayer.create(this, R.raw.false1);
        player2.setVolume(currentVolume / maxVolume, currentVolume / maxVolume);
        //Звук ответа false - конец

        //Для левой части
        numLeft = random.nextInt(21); //Генерация случайных чисел от 1 до 21
        img_left.setImageResource(array.images5[numLeft]); //Берём картинку из массива
        text_left.setText(array.text5[numLeft]); //Берём из массива текст

        numRight = random.nextInt(21);

        while (numLeft==numRight){
            numRight = random.nextInt(21);
        }

        //Для правой части
        img_right.setImageResource(array.images5[numRight]);
        text_right.setText(array.text5[numRight]);

        //Обрабатываем нажатие на левую картинку - начало
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //Касание картинки - начало
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    //Если коснулся картинки - начало
                   img_right.setEnabled(false); //Блокируем правую картинку что бы не допустить нажатия на обе сразу
                   if (numLeft > numRight){
                       img_left.setImageResource(R.drawable.lvl1true);
                       player1.start();
                       if (Build.VERSION.SDK_INT >= 26) {
                           ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(50,50));
                       } else {
                           ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(50);
                       }
                   }else{
                       img_left.setImageResource(R.drawable.lvl1false);
                       player2.start();
                       if (Build.VERSION.SDK_INT >= 26) {
                           ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(250,200));
                       } else {
                           ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(250);
                       }
                   }
                   //Если коснулся картинки конец
                }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    //Если отпустил палец - начало
                    if (numLeft > numRight){
                        //Если левая картинка больше
                        if (count < 20){
                          count = count + 1;
                        }
                        //Закрашиваем прогресс серым светом - начало
                        for (int i = 0; i < 20; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //Закрашиваем прогресс серым светом - конец

                        //Определяем правельность ответа и закрашиваем в зелёный цвет - начало
                        for (int i = 0; i < count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Определяем правельность ответа и закрашиваем в зелёный цвет - конец

                    }else {
                        //Если левая картинка меньше
                        if (count > 1){
                            if (count == 1){
                              count = 0;
                            }else{
                                count = count - 2;
                            }
                        }
                        //Закрашиваем прогресс серым светом - начало
                        for (int i = 0; i < 19; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //Закрашиваем прогресс серым светом - конец

                        //Определяем правельность ответа и закрашиваем в зелёный цвет - начало
                        for (int i = 0; i < count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Определяем правельность ответа и закрашиваем в зелёный цвет - конец
                    }
                    //Если отпустил палец - конец

                    if (count == 20){
                        //Выход из уровня
                        dialogExit.show();
                        final KonfettiView konfettiView = findViewById(R.id.konfetti);
                        konfettiView.build()
                                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                                .setDirection(0.0, 359.0)
                                .setSpeed(1f, 5f)
                                .setFadeOutEnabled(true)
                                .setTimeToLive(2000L)
                                .addShapes(Shape.Square.INSTANCE, Shape.Circle.INSTANCE)
                                .addSizes(new Size(12, 5f))
                                .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                                .streamFor(300, 5000L);

                    }else {
                        numLeft = random.nextInt(21); //Генерация случайных чисел от 1 до 21
                        img_left.setImageResource(array.images5[numLeft]); //Берём картинку из массива
                        img_left.startAnimation(a);
                        text_left.setText(array.text5[numLeft]); //Берём из массива текст

                        numRight = random.nextInt(21);

                        while (numLeft==numRight){
                            numRight = random.nextInt(21);
                        }

                        //Для правой части
                        img_right.setImageResource(array.images5[numRight]);
                        img_right.startAnimation(a);
                        text_right.setText(array.text5[numRight]);

                        img_right.setEnabled(true);
                    }
                }


                //Касание картинки - конец
                return true;
            }
        });
        //Обрабатываем нажатие не левую картинку - конец

        //Обрабатываем нажатие на правую картинку - начало
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //Касание картинки - начало
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    //Если коснулся картинки - начало
                    img_left.setEnabled(false); //Блокируем лувую картинку что бы не допустить нажатия на обе сразу
                    if (numLeft < numRight){
                        img_right.setImageResource(R.drawable.lvl1true);
                        player1.start();
                        if (Build.VERSION.SDK_INT >= 26) {
                            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(50,50));
                        } else {
                            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(50);
                        }
                    }else{
                        img_right.setImageResource(R.drawable.lvl1false);
                        player2.start();
                        if (Build.VERSION.SDK_INT >= 26) {
                            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(250,200));
                        } else {
                            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(250);
                        }
                    }
                    //Если коснулся картинки конец
                }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    //Если отпустил палец - начало
                    if (numLeft < numRight){
                        //Если правая картинка больше
                        if (count < 20){
                            count = count + 1;
                        }
                        //Закрашиваем прогресс серым светом - начало
                        for (int i = 0; i < 20; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //Закрашиваем прогресс серым светом - конец

                        //Определяем правельность ответа и закрашиваем в зелёный цвет - начало
                        for (int i = 0; i < count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Определяем правельность ответа и закрашиваем в зелёный цвет - конец

                    }else {
                        //Если правая картинка меньше
                        if (count > 1){
                            if (count == 1){
                                count = 0;
                            }else{
                                count = count - 2;
                            }
                        }
                        //Закрашиваем прогресс серым светом - начало
                        for (int i = 0; i < 19; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //Закрашиваем прогресс серым светом - конец

                        //Определяем правельность ответа и закрашиваем в зелёный цвет - начало
                        for (int i = 0; i < count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Определяем правельность ответа и закрашиваем в зелёный цвет - конец
                    }
                    //Если отпустил палец - конец

                    if (count == 20){
                        //Выход из уровня
                        dialogExit.show();
                        final KonfettiView konfettiView = findViewById(R.id.konfetti);
                        konfettiView.build()
                                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                                .setDirection(0.0, 359.0)
                                .setSpeed(1f, 5f)
                                .setFadeOutEnabled(true)
                                .setTimeToLive(2000L)
                                .addShapes(Shape.Square.INSTANCE, Shape.Circle.INSTANCE)
                                .addSizes(new Size(12, 5f))
                                .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                                .streamFor(300, 5000L);

                    }else {
                        numLeft = random.nextInt(21); //Генерация случайных чисел от 1 до 21
                        img_left.setImageResource(array.images5[numLeft]); //Берём картинку из массива
                        img_left.startAnimation(a);
                        text_left.setText(array.text5[numLeft]); //Берём из массива текст

                        numRight = random.nextInt(21);

                        while (numLeft==numRight){
                            numRight = random.nextInt(21);
                        }

                        //Для правой части
                        img_right.setImageResource(array.images5[numRight]);
                        img_right.startAnimation(a);
                        text_right.setText(array.text5[numRight]);

                        img_left.setEnabled(true);
                    }
                }


                //Касание картинки - конец
                return true;
            }
        });
        //Обрабатываем нажатие не правую картинку - конец
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) player.release();
        if (player1 != null) player1.release();
        if (player2 != null) player2.release();
    }

    @Override
    protected void onPause(){
        super.onPause();
        player.pause();
        player1.pause();
        player2.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        player.start();
        player1.start();
        player2.start();
    }
}