package com.example.githubuser.common.network

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val niaDispatcher: GithubUserDispatchers)

enum class GithubUserDispatchers {
    Default,
    IO,
}
