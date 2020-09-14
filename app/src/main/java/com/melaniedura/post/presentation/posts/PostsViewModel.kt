package com.melaniedura.post.presentation.posts

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.melaniedura.post.domain.model.ErrorModel
import com.melaniedura.post.domain.model.Post
import com.melaniedura.post.domain.usecase.GetPostsUseCase
import com.melaniedura.post.domain.usecase.base.UseCaseResponse
import com.melaniedura.post.presentation.base.BaseViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

class PostsViewModel @ViewModelInject
constructor(private val getPostsUseCase: GetPostsUseCase,
            @Assisted private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    val postsData = MutableLiveData<List<Post>>()
    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    @ExperimentalCoroutinesApi
    fun getPosts() {
        showProgressbar.value = true
        getPostsUseCase.invoke(null, object : UseCaseResponse<List<Post>> {
            override fun onSuccess(result: List<Post>) {
                Log.i(TAG, "result: $result")
                postsData.value = result
                showProgressbar.value = false
            }

            override fun onError(errorModel: ErrorModel?) {
                messageData.value = errorModel?.message
                showProgressbar.value = false
            }
        })
    }

    companion object {
        private val TAG = PostsViewModel::class.java.name
    }
}