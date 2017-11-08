package com.example.mariana.prova_moviesroad.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;

import com.example.mariana.prova_moviesroad.R;
import com.example.mariana.prova_moviesroad.movies.MoviesActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;


/**
 * Created by mariana on 07/11/17.
 */

public class LoginActivity extends AppCompatActivity implements LoginView {

    //Importar a biblioteca Butterknife no Gradle para fazer o Bind dos elementos da tela de login.
   @BindView(R.id.text_input_layout_username) TextInputLayout usernameTextInputLayout;
   @BindView(R.id.edit_text_username) TextInputEditText usernameEditText;
   @BindView(R.id.text_input_layout_password) TextInputLayout passwordTextInputLayout;
   @BindView(R.id.edit_text_password) TextInputEditText passwordEditText;

    LoginPresenter loginPresenter;

    //Método onCreate que faz a ligação entre o arquivo XML e o arquivo Java.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenter(LoginActivity.this);
    }

    @OnTextChanged(R.id.edit_text_username)
    public void validaUsuario(){
        usernameTextInputLayout.setErrorEnabled(false);
        usernameTextInputLayout.setError("");
    }

    @OnTextChanged(R.id.edit_text_password)
    public void validaSenha(){
        passwordTextInputLayout.setErrorEnabled(false);
        passwordTextInputLayout.setError("");

    }

    //Implementando o método OnClick que representa as funcionalidades do app ao clicar em um dado botão.
    @OnClick(R.id.button_login)
    public void fazLogin(){
        loginPresenter.login(
            usernameEditText.getText().toString(),
            passwordEditText.getText().toString());
    }

    //Define Usuario e Senha invalidos a partir da verificação da entrada do usuário.
    public void setErroUsuario() {
        usernameTextInputLayout.setErrorEnabled(true);
        usernameTextInputLayout.setError(getString(R.string.invalid_username));
    }

    public void setErroSenha() {
        passwordTextInputLayout.setErrorEnabled(true);
        passwordTextInputLayout.setError(getString(R.string.invalid_password));
    }

    //Se o login for realizado com sucesso é chamada uma nova activity.
    public void loginComSuccesso() {
        Intent abirMoviesActivity = new Intent(LoginActivity.this, MoviesActivity.class);
        startActivity(abirMoviesActivity);
    }
}