package com.shakircam.android.ui.commit

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
import com.shakircam.android.model.Commits
import com.shakircam.android.model.Repository
import com.shakircam.android.utils.ExtensionFunction.hasInternetConnection
import com.shakircam.android.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.M)
@HiltViewModel
class CommitViewModel @Inject constructor(private val githubRepository: GithubRepository, application: Application
) : BaseViewModel(application) {

    /** RETROFIT */
    /**  ------ github commits call ----- */


    private val _commitsResponse : MutableLiveData<Resource<MutableList<Commits.CommitsItem>>> = MutableLiveData()
    val commitsResponse: LiveData<Resource<MutableList<Commits.CommitsItem>>> = _commitsResponse



    private val _repoResponse : MutableLiveData<Resource<Repository>> = MutableLiveData()
    val repoResponse: LiveData<Resource<Repository>> = _repoResponse
    var  searchQuery = "Android"
    var  sortBy = "stars"
    var  orderBy = "asc"
    var  page = 1
    var  perPage = 5

    init {
        /** Checking internet connection first. if internet is available then we call the getCommit function. */
        if (hasInternetConnection(application)){
            getRepo()
            getCommit()
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

    private fun getCommit() = viewModelScope.launch {
        _commitsResponse.postValue(Resource.Loading())
        val response = githubRepository.remote.getGithubCommit()
        _commitsResponse.postValue(handleCommitsResponse(response))
    }


    private fun handleCommitsResponse(response: Response<MutableList<Commits.CommitsItem>>) : Resource<MutableList<Commits.CommitsItem>> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->

                val filterList = mutableListOf<Commits.CommitsItem>()
                val updatedList = mutableListOf<Commits.CommitsItem>()

                /** we are checking user name starts with g & x .If match with condition then we are keeping those a list.After that removing from main list.
                And finally keeping only last 10 commits   */


                for (element in resultResponse){
                    if (element.commit.author.name.startsWith("g") || element.commit.author.name.startsWith("x")){
                        filterList.add(element)
                    }
                }

                resultResponse.removeAll(filterList)
                var commitItem = 0
                for (item in resultResponse){

                    if (commitItem<10){
                        updatedList.add(item)
                        commitItem++
                    }
                }
                return Resource.Success(updatedList)
            }

        }
        return Resource.Error(response.message())
    }



}