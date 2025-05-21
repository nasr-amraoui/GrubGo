package com.app.grubgo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.grubgo.ui.screens.HomeScreen
import com.app.grubgo.ui.screens.OnboardingScreen
import com.app.grubgo.ui.viewmodel.OnboardingViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val onboardingViewModel: OnboardingViewModel = viewModel()
    // Check if onboarding is completed
    val isOnboardingCompleted = remember { onboardingViewModel.isOnboardingCompleted() }
    // Set start destination based on onboarding status
    val startDestination = if (isOnboardingCompleted) "home" else "onboarding"

    NavHost(navController = navController, startDestination = startDestination) {
        composable("onboarding") {
            OnboardingScreen(
                onOnboardingFinished = {
                    onboardingViewModel.onOnboardingCompleted()
                    navController.navigate("home") {
                        popUpTo("onboarding") { inclusive = true }
                    }
                }
            )
        }
        composable("home") {
            HomeScreen()
        }
    }
}