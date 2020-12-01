package com.redis.pojo;

import org.springframework.stereotype.Component;

/**
 * @author smxr
 * @date 2020/11/19
 * @time 9:47
 */
public class User {

    private String userName;
    private String userPwd;
    private String userSex;
    private int userAge;
    private String phoneNumber;
    private String address;
    private String createTime;

    public User() {
    }

    public User(String userName, String userPwd, String userSex, int userAge, String phoneNumber, String address, String createTime) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.userSex = userSex;
        this.userAge = userAge;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userAge=" + userAge +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
