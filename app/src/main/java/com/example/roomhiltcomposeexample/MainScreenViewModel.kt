package com.example.roomhiltcomposeexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.roomhiltcomposeexample.data.User
import com.example.roomhiltcomposeexample.data.UserDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(private val userDao: UserDao) :
    ViewModel() {
    fun getUsers(): Flow<PagingData<User>> =
        Pager(
            config = PagingConfig(
                pageSize = 10,
                prefetchDistance = 20,
            ),
        ) {
            userDao.getUserPages()
        }.flow.cachedIn(viewModelScope)
}