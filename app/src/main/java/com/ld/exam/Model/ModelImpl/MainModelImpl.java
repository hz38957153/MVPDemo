package com.ld.exam.Model.ModelImpl;


import com.ld.exam.Model.MainModel;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

/**
 * Created by hz on 2017/8/14.
 */

public class MainModelImpl implements MainModel {


    @Override
    public void setInfo(final String json) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection=null;
                try {
                    URL url = new URL("http://115.28.136.52:9090/rest/public/game/op");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setDoOutput(true);
                    connection.setDoInput(true);
                    connection.setRequestMethod("POST");
                    connection.connect();
                    DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                    out.writeBytes(json);
                    out.flush();
                    out.close();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String lines;
                    StringBuffer sb = new StringBuffer("");
                    while ((lines = reader.readLine()) != null) {
                        lines = URLDecoder.decode(lines, "utf-8");
                        sb.append(lines);
                    }
                    System.out.println(sb+"非首次"+json);
                    reader.close();
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
