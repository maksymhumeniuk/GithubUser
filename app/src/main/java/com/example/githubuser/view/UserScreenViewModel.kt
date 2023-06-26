package com.example.githubuser.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubuser.domain.GetGithubUserRepoListUseCase
import com.example.githubuser.domain.GetGithubUserUseCase
import com.example.githubuser.model.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserScreenViewModel @Inject constructor(
    val getGithubUserUseCase: GetGithubUserUseCase,
    val getGithubUserRepoListUseCase: GetGithubUserRepoListUseCase,
) : ViewModel() {
    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username

    private val _userImageUrl = MutableStateFlow("")
    val userImageUrl: StateFlow<String> = _userImageUrl

    private val _reposList = MutableStateFlow<List<Repo>>(emptyList())
    val reposList: StateFlow<List<Repo>> = _reposList

    fun doSearch(userId: String) {
        viewModelScope.launch {
            getGithubUserUseCase(userId).collectLatest {
                _username.value = it.name
                _userImageUrl.value = it.imageUrl
            }
        }
        viewModelScope.launch {
            getGithubUserRepoListUseCase(userId).collectLatest {
                _reposList.value = it
            }
        }
    }
}