package com.ld.exam.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ld.exam.MainApplication;
import com.ld.exam.Persenter.LoginPresenter;
import com.ld.exam.Persenter.PersenterImpl.LoginPresenterImpl;
import com.ld.exam.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hz on 2017/8/14.
 */

public class LoginActivity extends Activity implements LoginView,View.OnClickListener {

    private Button btnLogin;
    private LoginPresenter loadinPresenter;
    private EditText name,passwowrd;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Intent intent;
    private Boolean isF;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadin);
        sharedPreferences=getSharedPreferences("isFirst", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        btnLogin = (Button) findViewById(R.id.btnLogin);
        name = (EditText) findViewById(R.id.edit_name);
        passwowrd = (EditText) findViewById(R.id.edit_password);
        btnLogin.setOnClickListener(this);
        loadinPresenter = new LoginPresenterImpl(this);

    }

    /**
     * 点击登录
     * @param v
     */
    @Override
    public void onClick(View v) {
        loadinPresenter.validateCredentials(name.getText().toString(),passwowrd.getText().toString());
    }

    /**
     * 登录成功后的跳转
     */
    @Override
    public void navigateToHome() {
        /**
         * 如果是第一次登录调转首次启动页
         */
        if (isFirst()){
            intent = new Intent(this,FirstActivity.class);
            JSONObject bodyInfo  =new JSONObject();
            try {
                bodyInfo.put("op","install");
                bodyInfo.put("game",name.getText().toString());
                bodyInfo.put("device",Build.MODEL);
                bodyInfo.put("identifier",sharedPreferences.getString("identifier",""));
            }
            catch (JSONException e){
                e.printStackTrace();
            }
            String json= bodyInfo.toString();
            intent.putExtra("json",json);
            startActivity(intent);
        }
        /**
         * 如果不是第一次登录调转首页
         */
        else{
            intent = new Intent(this,MainActivity.class);
            JSONObject bodyInfo  =new JSONObject();
            try {
                bodyInfo.put("op","open");
                bodyInfo.put("game",name.getText().toString());
                bodyInfo.put("device",Build.MODEL);
                bodyInfo.put("identifier",sharedPreferences.getString("identifier",""));
            }
            catch (JSONException e){
                e.printStackTrace();
            }
            String json= bodyInfo.toString();
            intent.putExtra("json",json);
            startActivity(intent);
        }

    }

    @Override
    public void loginError() {
        Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
    }

    /**
     * 判断是否第一次登录
     * @return
     */
    private boolean isFirst(){
        isF=sharedPreferences.getBoolean("isFirst",false);
        if (!isF){
            Date date = new Date();
            editor.putBoolean("isFirst",true);
            editor.putString("identifier",date.getTime()+""); //设置唯一标识符
            editor.commit();
            MainApplication.isFirstLoadin=true;
            return true;
        }
        else{
            MainApplication.isFirstLoadin=false;
            return false;
        }
    }

}
