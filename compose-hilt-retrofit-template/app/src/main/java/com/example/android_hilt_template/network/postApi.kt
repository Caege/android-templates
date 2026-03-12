package com.example.android_hilt_template.network

import retrofit2.http.GET

/*
The API we are trying to contact is : https://jsonplaceholder.typicode.com/posts

**/





interface PostApiService {

    @GET("posts")
    suspend fun getPosts(): String
}

