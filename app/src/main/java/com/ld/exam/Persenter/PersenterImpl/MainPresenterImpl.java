package com.ld.exam.Persenter.PersenterImpl;

import com.ld.exam.Model.MainModel;
import com.ld.exam.Model.ModelImpl.MainModelImpl;
import com.ld.exam.Persenter.MainPresenter;

/**
 * Created by hz on 2017/8/14.
 */

public class MainPresenterImpl implements MainPresenter {
    private MainModel mainModle;

    public MainPresenterImpl( ) {
        this.mainModle = new MainModelImpl();
    }


    @Override
    public void setIn(String json) {
        mainModle.setInfo(json);
    }

}
