package com.app.grubgo.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.app.grubgo.ui.components.FirstOnboardingPage
import com.app.grubgo.ui.components.SecondOnboardingPage

@Composable
fun OnboardingScreen(
    onOnboardingFinished: () -> Unit
) {
    var currentPage by remember { mutableIntStateOf(0) }

    Box(modifier = Modifier.fillMaxSize()) {
        when (currentPage) {
            0 -> FirstOnboardingPage(
                onNext = { currentPage = 1 }
            )
            1 -> SecondOnboardingPage(
                onFinish = onOnboardingFinished
            )
        }
    }
}

