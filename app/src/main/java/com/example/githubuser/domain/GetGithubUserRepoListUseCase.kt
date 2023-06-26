package com.example.githubuser.domain

import com.example.githubuser.data.repository.UserRepository
import com.example.githubuser.model.Repo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGithubUserRepoListUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(id: String): Flow<List<Repo>> = userRepository.getRepos(id)
}