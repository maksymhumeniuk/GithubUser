package com.example.githubuser.data.mappers

import com.example.githubuser.model.Repo
import com.example.githubuser.model.User
import com.example.githubuser.network.model.NetworkGithubRepo
import com.example.githubuser.network.model.NetworkGithubUser

internal fun NetworkGithubUser.toUser(): User = User(name, avatarUrl)

internal fun NetworkGithubRepo.toRepo(): Repo = Repo(
    name,
    description,
    updateAt,
    stargazersCount,
    forks
)