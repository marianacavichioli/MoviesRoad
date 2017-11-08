package com.example.mariana.prova_moviesroad.movies;

import android.view.View;

/**
 * Created by mariana on 07/11/17.
 */

public interface OnRecyclerViewSelected {
    void onClick(View view, int position);
    void onLongClick(View view, int position);
}
