package com.ld.exam.Persenter.PersenterImpl;

import com.ld.exam.Model.FirstModel;
import com.ld.exam.Model.ModelImpl.FirstModelImpl;
import com.ld.exam.Persenter.FirstPresenter;

/**
 * Created by hz on 2017/8/14.
 */

public class FirstPresenterImpl implements FirstPresenter {
    private FirstModel firstModle;

    public FirstPresenterImpl() {
        this.firstModle = new FirstModelImpl();
    }

    @Override
    public void setIn(String json) {
        firstModle.setInfo(json);
    }
}
