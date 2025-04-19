package org.example.coffebrewer.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coffebrewer.composeapp.generated.resources.Res
import coffebrewer.composeapp.generated.resources.back
import org.jetbrains.compose.resources.painterResource

@Composable
fun NavigationBar(
    currentScreen: Screens,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(currentScreen.title) },
        modifier = modifier,
        backgroundColor = Color.White,
        navigationIcon = {
            if (canNavigateBack) {
                Image(
                    modifier = Modifier.padding(15.dp).clip(CircleShape).clickable { navigateUp() },
                    painter = painterResource(Res.drawable.back),
                    contentDescription = "Back navigation button",
                )
            }
        }
    )
}