package br.senai.sp.jandira.retrofitreqres

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Services {

    @GET("/api/users/{id}")
    suspend fun getUserByID(@Path("id") id : Long): Response<BaseResponse<UserResponse>>

}