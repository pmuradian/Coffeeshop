package org.example.coffebrewer.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coffebrewer.composeapp.generated.resources.Res
import coffebrewer.composeapp.generated.resources.coffee_icon_svgrepo_com
import org.example.coffebrewer.usecase.Coffee
import org.jetbrains.compose.resources.painterResource

@Composable
fun CoffeeSelectionScreen(
    coffeeMenu: List<Coffee> = listOf(),
    onCoffeeSelected: (Coffee) -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (coffeeMenu.isEmpty()) {
            Text("Sorry, this machine does not serve coffee at the moment")
            Text("Try another machine")
            Image(
                modifier = Modifier.size(100.dp, 100.dp),
                painter = painterResource(Res.drawable.coffee_icon_svgrepo_com),
                contentDescription = null
            )
        } else {
            Text(
                text = "Please select Your coffee",
                fontSize = 24.sp
            )
            Image(
                modifier = Modifier.size(100.dp, 100.dp),
                painter = painterResource(Res.drawable.coffee_icon_svgrepo_com),
                contentDescription = null
            )
            coffeeMenu.forEach {
                Button(
                    content = {
                        Text(it.name)
                    },
                    onClick = {
                        onCoffeeSelected(it)
                    }
                )
            }
        }
    }
}
