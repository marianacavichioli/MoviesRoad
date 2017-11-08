package com.example.mariana.prova_moviesroad.movies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mariana.prova_moviesroad.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

/**
 * Created by mariana on 07/11/17.
 */

//Como a RecyclerView não aceita um ArrayAdapter é preciso definir a própria classe Adapter
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private List<String> moviesList;
    OnRecyclerViewSelected onRecyclerViewSelected;

    //Construtor que recebe a lista
    MoviesAdapter(List<String> moviesList) {
        this.moviesList = moviesList;
    }

    //Infla o componente view
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item_list, parent, false);
        return new ViewHolder(v);
    }

    //Seta os dados nas views
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txMovieName.setText(moviesList.get(position));
        //holder.imgBackgroud.setImageBitmap();
    }

    //Retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    //Mapeamento dos componentes da view
    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tx_movie_name)
        TextView txMovieName;

        @BindView(R.id.image_view_background)
        ImageView imgBackgroud;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        //Seta o clique rápido
        @OnClick(R.id.container)
        void onItemClick(View view){
            if(onRecyclerViewSelected != null)
                onRecyclerViewSelected.onClick(view, getAdapterPosition());

        }

        //Seta o clique longo
        @OnLongClick(R.id.container)
        boolean onLongItemClick(View view){
            if(onRecyclerViewSelected != null)
                onRecyclerViewSelected.onLongClick(view, getAdapterPosition());

            return true;
        }

    }

    public void setOnRecyclerViewSelected(OnRecyclerViewSelected onRecyclerViewSelected){
        this.onRecyclerViewSelected = onRecyclerViewSelected;
    }
}