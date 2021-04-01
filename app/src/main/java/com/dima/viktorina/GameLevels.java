package com.dima.viktorina;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;
import com.ramotion.circlemenu.CircleMenuView;

public class GameLevels extends AppCompatActivity {

    Dialog dialog;
    private AdView adView;
    private FloatingActionButton floatingactionbutton0, floatingactionbutton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelavels);

        //SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        //final int lavel = save.getInt("Lavel", 1);

        //Рекламный банер - начало
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-6157182552660079~8128665018");
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        //Рекламный банер - конец

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

       /* ImageButton imbtn = (ImageButton) findViewById(R.id.imageButton);
        imbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });*/

        floatingactionbutton0 = findViewById(R.id.floatingactionbutton0);
        floatingactionbutton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

        floatingactionbutton1 = findViewById(R.id.floatingactionbutton1);
        floatingactionbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_opt = new Intent(GameLevels.this, Menu_option.class);
                startActivity(intent_opt);finish();
            }
        });

        TextView textView15 = (TextView) findViewById(R.id.textView15);
        textView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //Вызов диалогового окна
                    dialog = new Dialog(GameLevels.this); //Создаёт новое диалоговое окно
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //Скрываем шапку диалога
                    dialog.setContentView(R.layout.dialog_prev); //Путь к макету
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //Прозрачный фон диалогового окна
                    dialog.setCancelable(false); //Окно нельзя закрыть системными кнопками

                    //Картинка для диалогового окна - начало
                    ImageView imgprev = (ImageView)dialog.findViewById(R.id.imgprev);
                    imgprev.setImageResource(R.drawable.warning_new);
                    //Картинка для диалогового окна - конец

                    LinearLayout dialogfon = (LinearLayout)dialog.findViewById(R.id.dialogfon);
                    dialogfon.setBackgroundResource(R.drawable.prev_dialog_bg_lavel4);

                    //Текст для диалогового окна - начало
                    TextView textdescription = (TextView)dialog.findViewById(R.id.dialogtext);
                    textdescription.setText(R.string.warning);
                    //Текст дя диалогового окна - конец

                    //Кнопка закрытия диалогового окна - начало
                    TextView btncloce = (TextView)dialog.findViewById(R.id.btncloce);
                    btncloce.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            try {
                                dialog.dismiss();
                            }catch (Exception e){

                            }
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

        TextView textView16 = (TextView) findViewById(R.id.textView16);
        textView16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //Вызов диалогового окна
                    dialog = new Dialog(GameLevels.this); //Создаёт новое диалоговое окно
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //Скрываем шапку диалога
                    dialog.setContentView(R.layout.dialog_prev); //Путь к макету
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //Прозрачный фон диалогового окна
                    dialog.setCancelable(false); //Окно нельзя закрыть системными кнопками

                    //Картинка для диалогового окна - начало
                    ImageView imgprev = (ImageView)dialog.findViewById(R.id.imgprev);
                    imgprev.setImageResource(R.drawable.warning_new);
                    //Картинка для диалогового окна - конец

                    LinearLayout dialogfon = (LinearLayout)dialog.findViewById(R.id.dialogfon);
                    dialogfon.setBackgroundResource(R.drawable.prev_dialog_bg_lavel4);

                    //Текст для диалогового окна - начало
                    TextView textdescription = (TextView)dialog.findViewById(R.id.dialogtext);
                    textdescription.setText(R.string.warning);
                    //Текст дя диалогового окна - конец

                    //Кнопка закрытия диалогового окна - начало
                    TextView btncloce = (TextView)dialog.findViewById(R.id.btncloce);
                    btncloce.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            try {
                                dialog.dismiss();
                            }catch (Exception e){

                            }
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
                   //if (lavel >=1){
                       Intent intent = new Intent(GameLevels.this, Lavel1.class);
                       startActivity(intent); finish();
                   //}else{

                   //}
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
                    //if (lavel>=2) {
                        Intent intent2 = new Intent(GameLevels.this, Lavel2.class);
                        startActivity(intent2);
                        finish();
                    //}else{

                    //}
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
                    //if (lavel>=3) {
                        Intent intent3 = new Intent(GameLevels.this, Lavel3.class);
                        startActivity(intent3);
                        finish();
                    //}else{

                    //}
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
                    //if (lavel>=4) {
                        Intent intent4 = new Intent(GameLevels.this, Lavel4.class);
                        startActivity(intent4);
                        finish();
                    //}else{

                    //}
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
                    //if (lavel>=5) {
                        Intent intent5 = new Intent(GameLevels.this, Lavel5.class);
                        startActivity(intent5);
                        finish();
                    //}else{

                    //}
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
                    //if (lavel>=6) {
                        Intent intent6 = new Intent(GameLevels.this, Lavel6.class);
                        startActivity(intent6);
                        finish();
                    //}else{

                    //}
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
                    //if (lavel>=7) {
                        Intent intent7 = new Intent(GameLevels.this, Lavel7.class);
                        startActivity(intent7);
                        finish();
                    //}else{

                    //}
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
                    //if (lavel>=8) {
                        Intent intent8 = new Intent(GameLevels.this, Lavel8.class);
                        startActivity(intent8);
                        finish();
                    //}else{

                    //}
                }catch (Exception e){

                }
            }
        });
        //Кнопка 8 уровня - конец

        //Кнопка 9 уровня - начало
        TextView textView9 = (TextView)findViewById(R.id.textView9);
        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //if (lavel>=9) {
                        Intent intent9 = new Intent(GameLevels.this, Lavel9.class);
                        startActivity(intent9);
                        finish();
                    //}else{

                    //}
                }catch (Exception e){

                }
            }
        });
        //Кнопка 9 уровня - конец

        //Кнопка 10 уровня - начало
        TextView textView10 = (TextView)findViewById(R.id.textView10);
        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //if (lavel>=10) {
                        Intent intent10 = new Intent(GameLevels.this, Lavel10.class);
                        startActivity(intent10);
                        finish();
                    //}else{

                    //}
                }catch (Exception e){

                }
            }
        });
        //Кнопка 10 уровня - конец

        //Кнопка 11 уровня - начало
        TextView textView11 = (TextView)findViewById(R.id.textView11);
        textView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //if (lavel>=11) {
                        Intent intent11 = new Intent(GameLevels.this, Lavel11.class);
                        startActivity(intent11);
                        finish();
                    //}else{

                    //}
                }catch (Exception e){

                }
            }
        });
        //Кнопка 11 уровня - конец

        //Кнопка 12 уровня - начало
        TextView textView12 = (TextView)findViewById(R.id.textView12);
        textView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //if (lavel>=12) {
                        Intent intent12 = new Intent(GameLevels.this, Lavel12.class);
                        startActivity(intent12);
                        finish();
                    //}else{

                    //}
                }catch (Exception e){

                }
            }
        });
        //Кнопка 12 уровня - конец

        //Кнопка 13 уровня - начало
        TextView textView13 = (TextView)findViewById(R.id.textView13);
        textView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //if (lavel>=13) {
                        Intent intent13 = new Intent(GameLevels.this, Lavel13.class);
                        startActivity(intent13);
                        finish();
                    //}else{

                    //}
                }catch (Exception e){

                }
            }
        });
        //Кнопка 13 уровня - конец

        //Кнопка 14 уровня - начало
        TextView textView14 = (TextView)findViewById(R.id.textView14);
        textView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent14 = new Intent(GameLevels.this, Lavel14.class);
                    startActivity(intent14); finish();
                }catch (Exception e){

                }
            }
        });
        //Кнопка 14 уровня - конец

    }

    private void showPopupMenu(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.inflate(R.menu.popup_menu);

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item1:
                        Intent intent_opt = new Intent(GameLevels.this, Menu_option.class);
                        startActivity(intent_opt);
                        //Toast.makeText(getApplicationContext(), "Item 1 clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.item2:
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                        return true;
                    default:
                        return false;
                }
            }
        });
        popup.show();
    }

    /*final int[] x = {
            R.id.textView1,
            R.id.textView2,
            R.id.textView3,
            R.id.textView4,
            R.id.textView5,
            R.id.textView6,
            R.id.textView7,
            R.id.textView8,
            R.id.textView9,
            R.id.textView10,
            R.id.textView11,
            R.id.textView12,
            R.id.textView13,
    };

    for(int i=1; i < lavel; i++){
        TextView tv = findViewById(x[i]);
        tv.setText("" + (i + 1));
    }*/

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