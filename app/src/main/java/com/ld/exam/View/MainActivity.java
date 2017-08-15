package com.ld.exam.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ld.exam.Persenter.MainPresenter;
import com.ld.exam.Persenter.PersenterImpl.MainPresenterImpl;
import com.ld.exam.R;

/**
 * Created by hz on 2017/8/14.
 */

public class MainActivity extends Activity{

    private MainPresenter mainPresenter;
    private Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenterImpl();
        intent = getIntent();
        String json = intent.getStringExtra("json");
        mainPresenter.setIn(json);
    }

}
