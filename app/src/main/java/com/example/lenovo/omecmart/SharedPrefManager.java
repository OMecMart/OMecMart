package com.example.lenovo.omecmart;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by user on 11/05/2017.
 */

public class SharedPrefManager {
    private static SharedPrefManager mInstance;
    private  static Context mCtx;
    private static final String SHARED_PREF_NAMED="mysharedpref12";
    private static final String KEY_USERNAME="name";
    private static final String KEY_HP="telephone";
    private static final String KEY_ALAMAT="alamat";
    private static final String KEY_USER_EMAIL="email";
    private static final String KEY_USER_ID="id";


    private SharedPrefManager(Context context){
        mCtx = context;
    }

    public  static  synchronized  SharedPrefManager getInstance(Context context){
        if (mInstance == null){
            mInstance=new SharedPrefManager(context);
        }
        return mInstance;
    }
    public boolean userLogin(int id, String name, String email, String alamat, String telephone){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAMED, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        editor.putInt(KEY_USER_ID,id);
        editor.putString(KEY_USER_EMAIL,email);
        editor.putString(KEY_USERNAME,name);
        editor.putString(KEY_ALAMAT,alamat);
        editor.putString(KEY_HP,telephone);
        editor.apply();
        return true;
    }
    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAMED, Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_USERNAME,null)!=null){
            return true;
        }return false;
    }
    public boolean logout(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAMED, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }
    public String getNama(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAMED, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME,null);
    }
    public String getHp(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAMED, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_HP,null);
    }
    public String getEmail(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAMED, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_EMAIL,null);
    }

}





   /* private static SharedPrefManager mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME ="mysharedpref12";
    private static final String KEY_USERNAME ="username";
    private static final String KEY_USER_EMAIL ="useremail";
    private static final String KEY_USER_ID="userid";

    private SharedPrefManager(Context context) {
        mCtx = context;


    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public  boolean userLogin(int id, String username, String email){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_USER_ID, id);
        editor.putString(KEY_USER_EMAIL, email);
        editor.putString(KEY_USERNAME, username);

        editor.apply();

        return true;
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_USERNAME, null) !=null){
            return true;
        }
        return false;
    }

    public  boolean logout(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }

    public String getUsername(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME,null);
    }

    public String getUserEmail(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_EMAIL,null);
    }*/

