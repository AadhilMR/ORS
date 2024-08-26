package com.kanishka.ors.entity;

public enum FoodStatus {
    AVAILABLE, NOT_AVAILABLE;

    public static FoodStatus valueOf(int id) throws IllegalArgumentException {
        if(id<1 || id>2) {
            throw new IllegalArgumentException("Illegal argument has been passed: " + id);
        }

        if(id==1) {
            return AVAILABLE;
        } else {
            return NOT_AVAILABLE;
        }
    }
}
