package com.bishe.appletshopserver.model.response;

/**
 * @Author
 * @Description 登陆相应实体
 * @Date 2019/4/28
 * @Modify
 */
public class LoginResponse {
    private String name;
    private String url;

    public LoginResponse() {
    }

    public LoginResponse(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}