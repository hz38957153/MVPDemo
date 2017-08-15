package com.ld.exam.Persenter.PersenterImpl;

import android.content.SharedPreferences;
import android.widget.Toast;

import com.ld.exam.Persenter.LoginPresenter;
import com.ld.exam.View.LoginView;
import com.ld.exam.LoginListener;
import com.ld.exam.Model.LoginModel;
import com.ld.exam.Model.ModelImpl.LoginModelImpl;

/**
 * Created by hz on 2017/8/14.
 */

public class LoginPresenterImpl implements LoginPresenter,LoginListener {

    private LoginModel loginModel;
    private LoginView loginView;

    public LoginPresenterImpl(LoginView loadinView) {
        this.loginView = loadinView;
        this.loginModel = new LoginModelImpl();
    }
    @Override
    public void onError() {
        loginView.loginError();
    }

    @Override
    public void onSuccess() {
        loginView.navigateToHome();
    }

    @Override
    public void validateCredentials(String username, String password) {
        loginModel.login(username,password,this);
    }



}
