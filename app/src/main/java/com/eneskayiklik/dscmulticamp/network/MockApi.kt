package com.eneskayiklik.dscmulticamp.network

import com.eneskayiklik.dscmulticamp.model.communitiy.Community
import retrofit2.http.GET

interface MockApi {

    @GET("multicamp/communities")
    suspend fun getCommunities(): Community

    companion object {
        const val BASE_URL = "https://5f6642a143662800168e7538.mockapi.io/"
    }
}