package com.wishlist.enums;

public enum Statuses {

    PURCHASED(true),
    NOT_PURCHASED(false);
    private final boolean status;

    Statuses(boolean status){this.status = status;}
    public boolean getStatus(){return status;}



}
