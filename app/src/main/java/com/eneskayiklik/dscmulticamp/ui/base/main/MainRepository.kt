package com.eneskayiklik.dscmulticamp.ui.base.main

import com.eneskayiklik.dscmulticamp.model.communitie.Community
import com.eneskayiklik.dscmulticamp.network.MockApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(
    private val mockApi: MockApi
) {
    suspend fun getCommunityData(): Community =
        mockApi.getCommunities()
}