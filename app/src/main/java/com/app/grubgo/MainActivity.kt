package com.app.grubgo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.grubgo.data.PreferencesManager
import com.app.grubgo.navigation.AppNavigation
import com.app.grubgo.navigation.Routes
import com.app.grubgo.ui.theme.GrubGoTheme
import com.app.grubgo.ui.viewmodel.OnboardingViewModel
import com.app.grubgo.ui.viewmodel.OnboardingViewModelFactory

class MainActivity : ComponentActivity() {
    private lateinit var preferencesManager: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        preferencesManager = PreferencesManager(applicationContext)

        setContent {
            GrubGoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val onboardingViewModel: OnboardingViewModel = viewModel(
                        factory = OnboardingViewModelFactory(preferencesManager)
                    )

                    val startDestination = if (preferencesManager.isOnboardingCompleted) {
                        Routes.HOME
                    } else {
                        Routes.ONBOARDING
                    }

                    AppNavigation(
                        startDestination = startDestination,
                        onboardingViewModel = onboardingViewModel
                    )
                }
            }
        }
    }
}