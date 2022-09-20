package com.example.memorama_david;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class perdedor extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer play;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perdedor);
        play=MediaPlayer.create(this, R.raw.perdedor);
        play.start();

        btn1=(Button) findViewById(R.id.regresar);
        btn1.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.regresar:
                Intent i = new Intent(perdedor.this,MainActivity.class);
                startActivity(i);
                break;
        }
    }
}