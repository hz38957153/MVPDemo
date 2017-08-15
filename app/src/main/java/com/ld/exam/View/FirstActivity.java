package com.ld.exam.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.ld.exam.Persenter.FirstPresenter;
import com.ld.exam.Persenter.PersenterImpl.FirstPresenterImpl;
import com.ld.exam.R;

/**
 * Created by hz on 2017/8/14.
 */

public class FirstActivity extends Activity{

    private FirstPresenter firstPresenter;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        firstPresenter = new FirstPresenterImpl();
        intent=getIntent();
        String json = intent.getStringExtra("json");
        firstPresenter.setIn(json);
    }

}
