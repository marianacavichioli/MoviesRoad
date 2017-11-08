package com.example.mariana.prova_moviesroad.add_movie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.mariana.prova_moviesroad.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mariana on 07/11/17.
 */

public class AddMovieActivity extends AppCompatActivity {

    @BindView(R.id.edt_movie_name) EditText movieName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_movie_added)
    public void movieAdded(){
        Intent resultIntent = new Intent();
        resultIntent.putExtra("movie_name", movieName.getText().toString());
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

}