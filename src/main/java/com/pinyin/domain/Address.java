package com.pinyin.domain;

import java.util.regex.Pattern;

public class Address {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    private long id;

    private String userName;
    private String userAddress;

    public Address() {
    }

    private Address(String userName, String userAddress) {
        this.userName = userName;
        this.userAddress = userAddress;
    }

    public static Address anAddress(String userName, String userAddress) {
        return new Address(userName, userAddress);
    }

    public static Address anAddress(String userAddress) {
        return new Address(userAddress.split("@")[0], userAddress);
    }

    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setUserAddress(String userAddress){
        this.userAddress = userAddress;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public boolean isValid() {
        return EMAIL_PATTERN.matcher(this.userAddress).matches();
    }
}
