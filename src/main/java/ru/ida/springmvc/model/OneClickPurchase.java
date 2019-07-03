package ru.ida.springmvc.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class OneClickPurchase implements Serializable {

    private static final long serialVersionUID = 5237931007054301897L;
    private long uid;
    private String name;
    private String phone;
    private String email;


    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
