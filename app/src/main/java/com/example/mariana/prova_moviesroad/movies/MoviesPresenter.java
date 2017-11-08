package com.example.mariana.prova_moviesroad.movies;

import android.app.Activity;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mariana on 07/11/17.
 */

class MoviesPresenter {

    private MoviesView moviesView;
    private List<String> moviesList = new ArrayList<>();

    MoviesPresenter(MoviesView moviesView){
        this.moviesView = moviesView;
    }

    //Chamado pela MoviesActivity, adiciona um novo filme à lista.
    void addMovieInList(int requestCode, int resultCode, Intent data){
        if(requestCode == 123 && resultCode == Activity.RESULT_OK){
            String movieName = data.getStringExtra("movie_name");
            moviesList.add(movieName);
            moviesView.updateList(moviesList);
        }
    }

}