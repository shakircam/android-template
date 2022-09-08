package com.shakircam.android.data.local

import com.shakircam.android.model.User
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val userDao: UserDao) {

    suspend fun insertUserInformation(user: User){
        userDao.insertUserInformation(user)
    }
}