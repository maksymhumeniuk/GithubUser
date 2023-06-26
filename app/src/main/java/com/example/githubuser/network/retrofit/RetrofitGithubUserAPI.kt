package com.example.githubuser.network.retrofit

import com.example.githubuser.network.GithubUserNetworkDataSource
import com.example.githubuser.network.model.NetworkGithubRepo
import com.example.githubuser.network.model.NetworkGithubUser
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject
import javax.inject.Singleton

private interface RetrofitGithubUserAPI {
    @GET("users/{userId}")
    suspend fun getUserById(
        @Path("userId") id: String,
    ): NetworkGithubUser

    @GET("users/{userId}/repos")
    suspend fun getRepos(
        @Path("userId") id: String
    ): List<NetworkGithubRepo>
}

private const val GITHUB_BASE_URL = "https://api.github.com/"

@Singleton
class RetrofitGithubUser @Inject constructor(
    networkJson: Json,
    okhttpCallFactory: Call.Factory,
) : GithubUserNetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(GITHUB_BASE_URL)
        .callFactory(okhttpCallFactory)
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType())
        )
        .build()
        .create(RetrofitGithubUserAPI::class.java)

    override suspend fun getUser(userId: String): NetworkGithubUser =
        networkApi.getUserById(id = userId)

    override suspend fun getRepos(userId: String): List<NetworkGithubRepo> =
        networkApi.getRepos(id = userId)
}
