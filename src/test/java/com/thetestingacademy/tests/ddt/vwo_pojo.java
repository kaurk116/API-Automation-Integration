package com.thetestingacademy.tests.ddt;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class vwo_pojo {
    @SerializedName("username")
    @Expose
    public String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("remember")
    @Expose
    public Boolean remember;
    @SerializedName("recaptcha_response_field")
    @Expose
    public String recaptchaResponseField;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRemember() {
        return remember;
    }

    public void setRemember(Boolean remember) {
        this.remember = remember;
    }

    public String getRecaptchaResponseField() {
        return recaptchaResponseField;
    }

    public void setRecaptchaResponseField(String recaptchaResponseField) {
        this.recaptchaResponseField = recaptchaResponseField;
    }
}

