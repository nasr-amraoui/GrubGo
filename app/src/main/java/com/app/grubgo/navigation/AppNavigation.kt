package com.app.grubgo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.grubgo.ui.screens.FoodDeliveryApp
import com.app.grubgo.ui.screens.OnboardingScreen
import com.app.grubgo.ui.viewmodel.OnboardingViewModel

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    startDestination: String,
    onboardingViewModel: OnboardingViewModel
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Routes.ONBOARDING) {
            val currentPage = onboardingViewModel.currentPage.collectAsState().value

            OnboardingScreen(
                currentPage = currentPage,
                onNextPage = { onboardingViewModel.onNextPage() },
                onSkip = {
                    onboardingViewModel.onSkip()
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.ONBOARDING) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.HOME) {
            FoodDeliveryApp()
        }
    }
}
