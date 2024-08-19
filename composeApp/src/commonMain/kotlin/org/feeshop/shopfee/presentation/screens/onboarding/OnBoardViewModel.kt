package org.feeshop.shopfee.presentation.screens.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import org.feeshop.shopfee.data.repo.OnDataStoreRepository

class OnBoardViewModel constructor(
    private val repository: OnDataStoreRepository
) : ViewModel() {
    fun saveOnBoardingState(completed: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveOnBoardingState(completed = completed)
        }
    }

    fun isOnBoardingCompleted(): Flow<Boolean> {
        return repository.readOnBoardingState()
    }
}