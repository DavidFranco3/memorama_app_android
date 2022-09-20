package com.example.memorama_david;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
ImageView img1, img2, img3, img4, img5, img6;
Button start;
int[] imagenes;
final Handler handler = new Handler();
ImageView elegida=null;
ArrayList<Integer> ArrayBarajar;
int click1, click2, contPares=0;
int bandera=0;
int conclicks=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1=(ImageView) findViewById(R.id.imagen1);
        img2=(ImageView) findViewById(R.id.imagen2);
        img3=(ImageView) findViewById(R.id.imagen3);
        img4=(ImageView) findViewById(R.id.imagen4);
        img5=(ImageView) findViewById(R.id.imagen5);
        img6=(ImageView) findViewById(R.id.imagen6);

        start=(Button) findViewById(R.id.iniciar);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        img6.setOnClickListener(this);
        start.setOnClickListener(this);
    }

    public void calcular(int pos, final ImageView seleccion){
        if(elegida==null){
            click1=ArrayBarajar.get(pos);
            seleccion.setImageResource(imagenes[ArrayBarajar.get(pos)]);
            elegida=seleccion;
            elegida.setEnabled(false);
        } else{
            click2=ArrayBarajar.get(pos);
            seleccion.setImageResource(imagenes[ArrayBarajar.get(pos)]);
            seleccion.setEnabled(false);
            if(click1==click2) {
                contPares++;
                elegida=null;
                if (contPares == 3) {
                    Intent i = new Intent(MainActivity.this,ganador.class);

                    startActivity(i);

                    contPares=0; 
                }
            }else {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            elegida.setEnabled(true);
                            elegida.setImageResource(R.drawable.cerrado);
                            seleccion.setImageResource(R.drawable.cerrado);
                            seleccion.setEnabled(true);
                            //click1=0;
                            //click2=0;
                            elegida=null;
                            conclicks++;
                            if(conclicks==1){
                                Toast.makeText(getApplicationContext(), "SOLO TE QUEDA UN INTENTO", Toast.LENGTH_LONG).show();
                            } else {
                                Intent a = new Intent(MainActivity.this, perdedor.class);
                                startActivity(a);
                            }
                        }
                    }, 2000);


            }
        }


    }

    private void cargarImagenes(){
        imagenes = new int[]{
                R.drawable.perrito,
                R.drawable.elefante,
                R.drawable.dinosario
        };
    }

    public ArrayList<Integer> barajar(int longitud){
        ArrayList resul=new ArrayList<Integer>();

        for (int i=0; i<longitud; i++){
            resul.add(i%longitud/2);
        }

        Collections.shuffle(resul);

        return resul;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imagen1:
                if(bandera==1) {
                    calcular(0, img1);
                } else {
                    Toast.makeText(this, "POR FAVOR INICIA UN NUEVO JUEGO", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.imagen2:
                if(bandera==1) {
                    calcular(1, img2);
                } else {
                    Toast.makeText(this, "POR FAVOR INICIA UN NUEVO JUEGO", Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.imagen3:
                if(bandera==1) {
                    calcular(2, img3);
                } else {
                    Toast.makeText(this, "POR FAVOR INICIA UN NUEVO JUEGO", Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.imagen4:
                if(bandera==1) {
                    calcular(3, img4);
                } else {
                    Toast.makeText(this, "POR FAVOR INICIA UN NUEVO JUEGO", Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.imagen5:
                if(bandera==1) {
                    calcular(4, img5);
                } else {
                    Toast.makeText(this, "POR FAVOR INICIA UN NUEVO JUEGO", Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.imagen6:
                if(bandera==1) {
                    calcular(5, img6);
                } else {
                    Toast.makeText(this, "POR FAVOR INICIA UN NUEVO JUEGO", Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.iniciar:

                cargarImagenes();
                ArrayBarajar = barajar (imagenes.length*2);
                //img1.setScaleType(ImageView.ScaleType.CENTER_CROP);
                img1.setImageResource(imagenes[ArrayBarajar.get(0)]);
                img1.setEnabled(true);
                //img2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                img2.setImageResource(imagenes[ArrayBarajar.get(1)]);
                img2.setEnabled(true);
                //img3.setScaleType(ImageView.ScaleType.CENTER_CROP);
                img3.setImageResource(imagenes[ArrayBarajar.get(2)]);
                img3.setEnabled(true);
                //img4.setScaleType(ImageView.ScaleType.CENTER_CROP);
                img4.setImageResource(imagenes[ArrayBarajar.get(3)]);
                img4.setEnabled(true);
                //img5.setScaleType(ImageView.ScaleType.CENTER_CROP);
                img5.setImageResource(imagenes[ArrayBarajar.get(4)]);
                img5.setEnabled(true);
                //img6.setScaleType(ImageView.ScaleType.CENTER_CROP);
                img6.setImageResource(imagenes[ArrayBarajar.get(5)]);
                img6.setEnabled(true);
                bandera=1;

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //img1.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        img1.setImageResource(R.drawable.cerrado);
                        //img2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        img2.setImageResource(R.drawable.cerrado);
                        //img3.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        img3.setImageResource(R.drawable.cerrado);
                        //img4.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        img4.setImageResource(R.drawable.cerrado);
                        //img5.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        img5.setImageResource(R.drawable.cerrado);
                        //img6.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        img6.setImageResource(R.drawable.cerrado);
                    }
                },2000);
                break;
        }
    }
}

