package com.shakircam.android.utils

import android.content.Context


class AppPreferenceImpl(context: Context): AppPreference  {

    private val sharedPreferences = context.getSharedPreferences("app_sharedPreference",0)
    private val editor = sharedPreferences.edit()


    override fun getString(key: String): String? {
        return sharedPreferences.getString(key,"Error")
    }

    override fun setString(key: String, value: String) {
        editor.putString(key,value)
        editor.apply()
    }

    override fun getInt(key: String):Int? {
        return sharedPreferences.getInt(key,-1)
    }

    override fun setInt(key: String,value:Int) {
        editor.putInt(key,value)
        editor.apply()
    }

    override fun getFloat(key: String): Float? {
        return sharedPreferences.getFloat(key,-0.1F)
    }

    override fun setFloat(key: String, value: Float) {
        editor.putFloat(key,value)
        editor.apply()
    }

    override fun getLong(key: String): Long? {
       return sharedPreferences.getLong(key,-1)
    }

    override fun setLong(key: String, value: Long) {
        editor.putLong(key,value)
        editor.apply()
    }

    override fun getBoolean(key: String): Boolean? {
        return sharedPreferences.getBoolean(key,false)
    }

    override fun setBoolean(key: String, value: Boolean) {
        editor.putBoolean(key,value)
        editor.apply()
    }

    override fun removeValue() {
        editor.clear()
        editor.commit()
    }

    override fun deleteSingleValue(key: String) {
        editor.remove(key)
        editor.commit()
    }



}