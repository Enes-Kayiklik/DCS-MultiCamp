package com.eneskayiklik.dscmulticamp.ui.base.main

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eneskayiklik.dscmulticamp.model.communitie.Community
import com.eneskayiklik.dscmulticamp.network.MockApi
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val communityRepository: MainRepository
): ViewModel() {
    private var _communityData = MutableLiveData<Community>()
    val communityData: LiveData<Community>
        get() = _communityData

    init {
        getCommunities()
    }

    private fun getCommunities() = viewModelScope.launch {
        try {
            _communityData.value = communityRepository.getCommunityData()
        } catch (e: Exception) {
            makeLog(e.message)
        }
    }

    private fun makeLog(message: String?) {
        message?.let {
            Log.e("Dog View Model", message)
        }
    }
}