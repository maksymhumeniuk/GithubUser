package com.example.githubuser.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Network representation of GithubUser
 */
@Serializable
data class NetworkGithubUser(
    val name: String = "",
    @SerialName("avatar_url")
    val avatarUrl: String = ""
)
