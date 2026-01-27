package com.example.placementholder

import PlaceHolderRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PlaceHolderViewModel : ViewModel() {

    private val _post = MutableLiveData<Post?>()
    val post: LiveData<Post?> get() = _post

    fun fetchPost() {
        viewModelScope.launch {
            val repository = PlaceHolderRepository()
            _post.value = repository.placeholderNetworkCall()
        }
    }
}
