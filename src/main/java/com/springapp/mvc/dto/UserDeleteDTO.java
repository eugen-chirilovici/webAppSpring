package com.springapp.mvc.dto;

public class UserDeleteDTO {

    private String userId;

    public long getUserId() {
        return Long.parseLong(userId);
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
