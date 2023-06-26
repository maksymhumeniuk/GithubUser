package com.example.githubuser.data.repository

import com.example.githubuser.model.Repo
import com.example.githubuser.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUser(id: String): Flow<User>

    fun getRepos(id: String): Flow<List<Repo>>
}