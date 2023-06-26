package com.example.githubuser.domain


import com.example.githubuser.data.repository.UserRepository
import com.example.githubuser.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGithubUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(id: String): Flow<User> = userRepository.getUser(id)
}