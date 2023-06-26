package com.example.githubuser.data.di

import com.example.githubuser.data.repository.GithubUserRepository
import com.example.githubuser.data.repository.UserRepository
import com.example.githubuser.network.GithubUserNetworkDataSource
import com.example.githubuser.network.retrofit.RetrofitGithubUser
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsUserRepository(
        githubUserRepository: GithubUserRepository,
    ): UserRepository

    @Binds
    fun bindsGithubUserNetworkDataSource(
        retrofitGithubUser: RetrofitGithubUser,
    ): GithubUserNetworkDataSource
}
