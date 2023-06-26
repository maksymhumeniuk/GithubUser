package com.example.githubuser.data.repository

import com.example.githubuser.common.network.Dispatcher
import com.example.githubuser.common.network.GithubUserDispatchers.IO
import com.example.githubuser.data.mappers.toRepo
import com.example.githubuser.data.mappers.toUser
import com.example.githubuser.model.Repo
import com.example.githubuser.model.User
import com.example.githubuser.network.GithubUserNetworkDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GithubUserRepository @Inject constructor(
    @Dispatcher(IO) private val ioDispatcher: CoroutineDispatcher,
    private val datasource: GithubUserNetworkDataSource,
): UserRepository {
    override fun getUser(id: String): Flow<User> = flow {
        emit(
            datasource.getUser(id).toUser()
        )
    }.flowOn(ioDispatcher)

    override fun getRepos(id: String): Flow<List<Repo>> = flow {
        emit(
            datasource.getRepos(id).map { it.toRepo() }
        )
    }.flowOn(ioDispatcher)
}