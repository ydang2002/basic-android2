package com.nhuy.useretrofitcallapi;

import com.google.gson.annotations.SerializedName;

public class Quote {
    @SerializedName("USDVND")
    private float usdVnd;

    public float getUsdVnd() {
        return usdVnd;
    }

    public void setUsdVnd(float usdVnd) {
        this.usdVnd = usdVnd;
    }
}
