package com.melaniedura.post.domain.usecase.base

import com.melaniedura.post.domain.model.ErrorModel


interface UseCaseResponse<Type> {

    fun onSuccess(result: Type)

    fun onError(errorModel: ErrorModel?)
}