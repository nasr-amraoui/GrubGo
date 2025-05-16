package com.app.grubgo.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.grubgo.data.PreferencesManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OnboardingViewModel(private val preferencesManager: PreferencesManager) : ViewModel() {

    private val _currentPage = MutableStateFlow(0)
    val currentPage: StateFlow<Int> = _currentPage.asStateFlow()

    fun onNextPage() {
        if (_currentPage.value < 1) {
            _currentPage.value += 1
        }
    }

    fun onSkip() {
        completeOnboarding()
    }

    fun completeOnboarding() {
        viewModelScope.launch {
            preferencesManager.isOnboardingCompleted = true
        }
    }
}