package com.ld.exam.Model.ModelImpl;


import android.util.Log;

import com.google.gson.Gson;
import com.ld.exam.Bean.LoginStatusBean;
import com.ld.exam.LoginListener;
import com.ld.exam.Model.LoginModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hz on 2017/8/14.
 */

public class LoginModelImpl implements LoginModel {
    @Override
    public void login(String username, String passwoord, final LoginListener loginListener) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader reader = null;
                String result = null;
                StringBuffer sbf = new StringBuffer();
                HttpURLConnection connection = null;
                try {
                    URL mURL = new URL("http://115.28.136.52:9090/zoo/gameInfo.json");
                    connection = (HttpURLConnection) mURL.openConnection();
                    connection.setConnectTimeout(5000);
                    connection.connect();
                    if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        InputStream is = connection.getInputStream();
                        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                        String strRead = null;
                        while ((strRead = reader.readLine()) != null) {
                            sbf.append(strRead);
                            sbf.append("\r\n");
                        }
                        reader.close();
                        result = sbf.toString();
                        Gson gson = new Gson();
                        LoginStatusBean bean = gson.fromJson(result, LoginStatusBean.class);
                        Log.d("555555", bean.getStatus() + "");
                        if (Integer.parseInt(bean.getStatus())==0){
                            loginListener.onSuccess();

                        }
                    }
                    else{
                        loginListener.onError();

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    connection.disconnect();
                }
            }
        }).start();






    }

}

