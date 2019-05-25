package com.luisgomez.http_con_retrofit_final;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private PostAdapter postAdapter;
    private ArrayList<Post> listaDePost =new ArrayList<>();
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar; //  Esta vez se me ha  ocurrido añadirle una barra de progreso circulas que se va a activar antes de abrir datos

    // Para el proyecto de investigacion de GPS del segundo trimestre,
    // tenia una primera activity con un ProgressBar y al tiempo de unos segundos automaticamente
    // pasaba a la siguente activity (una pagina loading), pero ahora se trata solo de la barra de progreso
    //que aparece cuando pulsamos el boton Recibir Datos y va a estar visible hasta que aparezcan los datos


    Button recibirDatosGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar=(ProgressBar)findViewById(R.id.progress_bar);
        //mProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView=(RecyclerView)findViewById(R.id.listadoDePosts);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        recibirDatosGet = findViewById(R.id.btnRecibirDatosGet);
        recibirDatosGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        loadJSON();

            }
        });
    }

    private void loadJSON() {

        //Al pulsar el boton recibir datos, pasamos al metodo loadJson,
        // y ahora se activa la barra de progreso a cual va a estar visible el tiempo que tarde en verse los datos de la API

        mProgressBar.setVisibility(View.VISIBLE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestClient request = retrofit.create(RestClient.class);
        Call<List<Post>> call1=request.getObtenerPost();
        call1.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                mProgressBar.setVisibility(View.GONE);
                if (response.isSuccessful() && response.body()!=null) {
                    listaDePost = new ArrayList<>(response.body());
                    postAdapter =new PostAdapter(listaDePost,MainActivity.this);
                    mRecyclerView.setAdapter(postAdapter);
                }
            }


            // En caso de no poder acceder a los dato, podemos imprimir o realizar otra funcion
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                //Desactivo la barra
                mProgressBar.setVisibility(View.GONE);

                Toast.makeText(MainActivity.this,"Ha surgido un problema y no es posible acceder a la API!",Toast.LENGTH_SHORT).show();
            }

        });
    }

}
