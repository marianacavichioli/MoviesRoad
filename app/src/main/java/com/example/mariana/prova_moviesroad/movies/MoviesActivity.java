package com.example.mariana.prova_moviesroad.movies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.mariana.prova_moviesroad.R;
import com.example.mariana.prova_moviesroad.add_movie.AddMovieActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoviesActivity extends AppCompatActivity implements MoviesView {

    //Arruma o bind da view para usar o RecyclerView ao invés de uma ListView.
    @BindView(R.id.rv_movies) RecyclerView rvMovies;

    MoviesPresenter moviesPresenter;

    //Método onCreate para fazer a ligação entre o XML e o arquivo Java.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        ButterKnife.bind(this);
        moviesPresenter = new MoviesPresenter(this);
    }

    //Ao clicar no botão de adicionar um filme, passa-se para uma nova activity.
    @OnClick(R.id.btn_add_movie)
    public void addMovie(){
        Intent openAddMovieAcitivity = new Intent(this, AddMovieActivity.class);
        startActivityForResult(openAddMovieAcitivity, 123);
    }

    //Recebe o resultado da activity AddMovieActivity e adiciona ele na lista
    // a partir do método addMovieInList implementado em MoviesPresenter.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        moviesPresenter.addMovieInList(requestCode, resultCode, data);
    }

    //Atualizar a lista de filmes
    @Override
    public void updateList(List<String> moviesList) {
        //Cria um objeto adapter que é enviado por parametro a lista de filmes
        MoviesAdapter moviesAdapter = new MoviesAdapter(moviesList);
        //Quando um item da Recyclerview é selecionada
        moviesAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            //Clique simples
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(MoviesActivity.this, "Clique Rápido", Toast.LENGTH_SHORT).show();
            }
            //Clique longo
            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(MoviesActivity.this, "Clique Longo", Toast.LENGTH_SHORT).show();
            }
        });
        //Seta o adapter
        rvMovies.setAdapter(moviesAdapter);

        //Criação do gerenciador de layouts
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //Seta o layout no RecyclerView
        rvMovies.setLayoutManager(layoutManager);
    }

}