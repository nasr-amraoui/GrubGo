package com.app.grubgo.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.app.grubgo.data.PreferencesManager

class OnboardingViewModel(application: Application) : AndroidViewModel(application) {
    private val preferencesManager = PreferencesManager(application.applicationContext)

    fun onOnboardingCompleted() {
        preferencesManager.setOnboardingCompleted(true)
    }

    fun isOnboardingCompleted(): Boolean {
        return preferencesManager.isOnboardingCompleted()
    }
}