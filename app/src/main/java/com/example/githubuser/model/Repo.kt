package com.example.githubuser.model

data class Repo(
    val name: String,
    val description: String,
    val updateAt: String,
    val stargazersCount: Int,
    val forks: Int
)
