package com.example.mariana.prova_moviesroad.login;

import android.text.TextUtils;

/**
 * Created by mariana on 07/11/17.
 */

public class LoginPresenter {

    LoginView loginView;

    public LoginPresenter(LoginView loginView){
        this.loginView = loginView;
    }

    public void login(String username, String password){
        if(TextUtils.isEmpty(username)){
            loginView.setErroUsuario();
        } else if(TextUtils.isEmpty(password)){
            loginView.setErroSenha();
        } else {
            loginView.loginComSuccesso();
        }
    }
}