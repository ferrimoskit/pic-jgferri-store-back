package com.jgferri.pic_store_backend.domain.user;

public enum UserType {
    USER("user"),
    ADMIN("admin");

    private String type;
    UserType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
