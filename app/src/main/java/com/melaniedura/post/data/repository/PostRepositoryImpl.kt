package com.melaniedura.post.data.repository

import com.melaniedura.post.data.source.remote.ApiService
import com.melaniedura.post.domain.model.Post
import com.melaniedura.post.domain.repository.PostsRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val apiService: ApiService): PostsRepository {
    override suspend fun getPosts(): List<Post> {
        return apiService.getPosts()
    }
}