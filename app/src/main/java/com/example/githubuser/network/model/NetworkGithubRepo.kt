package com.example.githubuser.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Network representation of GithubUser
 */
@Serializable
data class NetworkGithubRepo(
    val name: String = "",
    val description: String = "",
    @SerialName("updated_at")
    val updateAt: String = "",
    @SerialName("stargazers_count")
    val stargazersCount: Int = 0,
    val forks: Int = 0
)
