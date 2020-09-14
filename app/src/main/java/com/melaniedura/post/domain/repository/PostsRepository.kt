package com.melaniedura.post.domain.repository

import com.melaniedura.post.domain.model.Post

interface PostsRepository {

    suspend fun getPosts(): List<Post>
}