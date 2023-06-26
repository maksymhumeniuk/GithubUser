package com.example.githubuser.network

import com.example.githubuser.network.model.NetworkGithubRepo
import com.example.githubuser.network.model.NetworkGithubUser


/**
 * Interface representing network calls to Github
 */
interface GithubUserNetworkDataSource {

    suspend fun getUser(userId: String): NetworkGithubUser

    suspend fun getRepos(userId: String): List<NetworkGithubRepo>
}
