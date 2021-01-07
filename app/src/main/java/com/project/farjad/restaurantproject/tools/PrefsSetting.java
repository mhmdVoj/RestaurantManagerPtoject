package com.project.farjad.restaurantproject.tools;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsSetting {
    private SharedPreferences sharedPreferences;

    public PrefsSetting(Context context) {
        sharedPreferences = context.getSharedPreferences("restaurant_prefs",Context.MODE_PRIVATE);
    }

    public void saveUser(String userName,String Pass){
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString("userName",userName);
        editor.putString("Pass",Pass);
        editor.apply();
    }

    public String getUser(){
        return sharedPreferences.getString("userName","");
    }
}
