package com.shakircam.android.utils

import android.content.SharedPreferences

interface AppPreference {



    fun getString(key:String):String ?
    fun setString(key:String,value:String)

    fun getInt(key:String):Int ?
    fun setInt(key:String,value:Int)

    fun getFloat(key:String):Float ?
    fun setFloat(key:String,value:Float)

    fun getLong(key: String):Long ?
    fun setLong(key: String,value: Long)

    fun getBoolean(key:String):Boolean ?
    fun setBoolean(key:String,value:Boolean)
    fun removeValue()
    fun deleteSingleValue(key: String)

}