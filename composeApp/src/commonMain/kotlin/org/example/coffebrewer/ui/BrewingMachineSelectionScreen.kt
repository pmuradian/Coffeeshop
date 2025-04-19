package org.example.coffebrewer.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
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
import coffebrewer.composeapp.generated.resources.coffee_machine
import org.example.coffebrewer.usecase.CoffeeMachine
import org.jetbrains.compose.resources.painterResource

@Composable
fun BrewingMachineSelectionScreen(
    onMachineSelected: (CoffeeMachine) -> Unit = {}
) {
    Column(
        modifier = Modifier.padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Please select the Brewing Machine",
            fontSize = 24.sp
        )
        Image(
            modifier = Modifier.padding(20.dp).size(100.dp, 100.dp),
            painter = painterResource(Res.drawable.coffee_machine),
            contentDescription = null
        )

        Button(
            content = {
                Text("DeLonghi, the coffee you're used to")
            },
            onClick = {
                onMachineSelected(CoffeeMachine.DeLonghi)
            }
        )
        Button(
            content = {
                Text("Hand Press, coffee lover's dream")
            },
            onClick = {
                onMachineSelected(CoffeeMachine.HandPress)
            }
        )
        Button(
            content = {
                Text("Nescafe, just a daily driver")
            },
            onClick = {
                onMachineSelected(CoffeeMachine.Nescafe)
            }
        )
        Button(
            content = {
                Text("Quchi Coffee Machine, the one you find at Gas stations")
            },
            onClick = {
                onMachineSelected(CoffeeMachine.Quchi)
            }
        )
    }
}