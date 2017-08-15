package com.ld.exam.Model;

import com.ld.exam.LoginListener;

/**
 * Created by hz on 2017/8/14.
 */

public interface LoginModel {
    void login(String username,String passwoord,LoginListener loginListener);
}
