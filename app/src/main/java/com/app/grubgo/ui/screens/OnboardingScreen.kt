package com.app.grubgo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.grubgo.R
import com.app.grubgo.ui.components.FirstOnboardingPage
import com.app.grubgo.ui.components.SecondOnboardingPage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingScreen(
    currentPage: Int,
    onNextPage: () -> Unit,
    onSkip: () -> Unit,
    onFinish: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = "Logo",
                        modifier = Modifier.height(40.dp)
                    )
                },
                actions = {
                    TextButton(onClick = onSkip) {
                        Text("Passer")
                    }
                }
            )
        }
    ) { paddingValues ->
        when (currentPage) {
            0 -> FirstOnboardingPage(
                modifier = Modifier.padding(paddingValues),
                onConnectWithGoogle = { /* Connect with Google logic */ },
                onLogin = { /* Navigate to login screen */ },
                onCreateAccount = onNextPage
            )
            1 -> SecondOnboardingPage(
                modifier = Modifier.padding(paddingValues),
                onFinish = onFinish
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen(
        currentPage = 0,
        onNextPage = {},
        onSkip = {},
        onFinish = {}
    )
}

