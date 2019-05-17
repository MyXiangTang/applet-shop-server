package com.bishe.appletshopserver.entity;

import java.io.Serializable;
import java.util.Date;


public class LoginUser implements Serializable {

    private long id;
    private String name;
    private String age;
    private String url;
    private Date birth;
    private String births;
    private String password;
    private String rank;
    private String phone;
    private String sex;
    private String email;
    private String remark;
    private Date creationdate;
    private Date modifieddate;
    private int page ;
    private int pageSize;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getBirths() {
        return births;
    }

    public void setBirths(String births) {
        this.births = births;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", url='" + url + '\'' +
                ", birth=" + birth +
                ", births='" + births + '\'' +
                ", password='" + password + '\'' +
                ", rank='" + rank + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", remark='" + remark + '\'' +
                ", creationdate=" + creationdate +
                ", modifieddate=" + modifieddate +
                ", page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
