package com.dima.viktorina;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Menu_option extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView btncloce = (TextView)findViewById(R.id.btncloce);
        btncloce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //Возвращение к выбору уровня
                    Intent intent = new Intent(Menu_option.this, GameLevels.class);
                    startActivity(intent); finish();
                }catch (Exception e){

                }
            }
        });

        TextView policy = (TextView)findViewById(R.id.policy);
        policy.setMovementMethod(LinkMovementMethod.getInstance());

        Switch Switch_music = (Switch)findViewById(R.id.switch_music);
        Switch_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Switch_music.isChecked()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Включено", Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Выключено", Toast.LENGTH_SHORT);
                    toast1.show();
                }
            }
        });

        Switch Switch_vibro = (Switch)findViewById(R.id.switch_vibro);
        Switch_vibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Switch_music.isChecked()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Включено", Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Выключено", Toast.LENGTH_SHORT);
                    toast1.show();
                }
            }
        });

        Switch Switch_music_otv = (Switch)findViewById(R.id.switch_music_otv);
        Switch_music_otv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Switch_music.isChecked()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Включено", Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Выключено", Toast.LENGTH_SHORT);
                    toast1.show();
                }
            }
        });
    }
}
