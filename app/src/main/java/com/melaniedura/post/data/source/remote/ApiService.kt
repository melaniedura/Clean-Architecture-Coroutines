package com.melaniedura.post.data.source.remote

import com.melaniedura.post.domain.model.Post
import retrofit2.http.GET

interface ApiService {

    @GET("/posts")
    suspend fun getPosts(): List<Post>
}