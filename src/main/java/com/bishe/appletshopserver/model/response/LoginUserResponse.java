package com.bishe.appletshopserver.model.response;

import com.bishe.appletshopserver.entity.LoginUser;

import java.util.List;

/**
 * @Author
 * @Description
 * @Date 2019/5/8
 * @Modify
 */
public class LoginUserResponse {
    private int total;
    private List<LoginUser> loginUserList;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<LoginUser> getLoginUserList() {
        return loginUserList;
    }

    public void setLoginUserList(List<LoginUser> loginUserList) {
        this.loginUserList = loginUserList;
    }

    @Override
    public String toString() {
        return "LoginUserResponse{" +
                "total=" + total +
                ", loginUserList=" + loginUserList +
                '}';
    }
}