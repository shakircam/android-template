package com.shakircam.android.ui.repo

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shakircam.android.core.BaseViewModel
import com.shakircam.android.domain.repository.GithubRepository
import com.shakircam.android.model.Repository
import com.shakircam.android.utils.ExtensionFunction.hasInternetConnection
import com.shakircam.android.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@RequiresApi(Build.VERSION_CODES.M)
@HiltViewModel
class RepositoryViewModel@Inject constructor(private val githubRepository: GithubRepository, application: Application
) : BaseViewModel(application) {


    private val _repoResponse : MutableLiveData<Resource<Repository>> = MutableLiveData()
    val repoResponse: LiveData<Resource<Repository>> = _repoResponse
    var  searchQuery = "Android"
    var  sortBy = "stars"
    var  orderBy = "asc"
    var  page = 1
    var  perPage = 5

    init {
        /** Checking internet connection first. if internet is available then we call the getCommmit function. */
        if (hasInternetConnection(application)){
            getRepo()
        }
    }

    private fun getRepo()= viewModelScope.launch {
        _repoResponse.postValue(Resource.Loading())
        val response = githubRepository.remote.getMostStarsRepository(searchQuery,sortBy,orderBy,page,perPage)
        _repoResponse.postValue(handleRepoResponse(response))
    }

    private fun handleRepoResponse(response: Response<Repository>): Resource<Repository>? {

        if (response.isSuccessful){

            response.body().let {
                return Resource.Success(it!!)
            }
        }

        return Resource.Error(response.code().toString())
    }


}