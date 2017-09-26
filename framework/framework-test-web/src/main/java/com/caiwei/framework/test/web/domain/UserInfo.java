package com.caiwei.framework.test.web.domain;

import java.io.Serializable;

/**
 * @author longhairen
 * @create 2017/8/21 0021 上午 10:17
 */
public class UserInfo implements Serializable{

    private static final long serialVersionUID = -5013948924238303422L;

    private int id;
    private String userName;
    private String passWord;
    private String mobileNo;
    private String email;
    private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
