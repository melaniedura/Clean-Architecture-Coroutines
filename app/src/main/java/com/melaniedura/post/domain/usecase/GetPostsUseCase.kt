package com.melaniedura.post.domain.usecase

import com.melaniedura.post.domain.exception.ApiErrorHandle
import com.melaniedura.post.domain.model.Post
import com.melaniedura.post.domain.repository.PostsRepository
import com.melaniedura.post.domain.usecase.base.UseCase
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val postsRepository: PostsRepository,
    apiErrorHandle: ApiErrorHandle
) : UseCase<List<Post>, Any?>(apiErrorHandle) {

    override suspend fun run(params: Any?): List<Post> {
        return postsRepository.getPosts()
    }

}