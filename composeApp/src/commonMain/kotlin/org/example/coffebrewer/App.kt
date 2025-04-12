package org.example.coffebrewer

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import coffebrewer.composeapp.generated.resources.Res
import coffebrewer.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        BrewingMachineSelectionScreen()
    }
}

@Composable
fun BrewingMachineSelectionScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
    Text("Please select the Brewing Machine")

    Button(
        content = {
            Text("DeLonghi, the coffee you're used to")
        },
        onClick = {}
    )
    Button(
        content = {
            Text("Hand Press, coffee lover's dream")
        },
        onClick = {}
    )
    Button(
        content = {
            Text("Nescafe, just a daily driver")
        },
        onClick = {}
    )
    Button(
        content = {
            Text("Quchi Coffee Machine, the one you find at Gas stations")
        },
        onClick = {}
    )
    }
}

@Composable
fun CoffeeSelectionScreen(
    viewModel: BrewingViewModel = BrewingViewModel(DeLonghi())
) {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Select a coffee")
        Button(
            content = {
                Text("ESPRESSO")
            },
            onClick = {}
        )
        Button(
            content = {
                Text("AMERICANO")
            },
            onClick = {}
        )
        Button(
            content = {
                Text("CAPPUCCINO")
            },
            onClick = {}
        )
        Button(
            content = {
                Text("FLAT WHITE")
            },
            onClick = {}
        )
    }
}

interface CoffeeMachine {
    fun brew(coffee: Coffee)
    fun getMenu(): List<Coffee>
}

class DeLonghi: CoffeeMachine {

    override fun brew(coffee: Coffee) {

    }

    override fun getMenu(): List<Coffee> {
        return listOf(Coffee.ESPRESSO, Coffee.AMERICANO, Coffee.FLAT_WHITE, Coffee.CAPPUCCINO)
    }
}

class QuchiCoffee: CoffeeMachine {

    override fun brew(coffee: Coffee) {

    }

    override fun getMenu(): List<Coffee> {
        return listOf(Coffee.ESPRESSO, Coffee.AMERICANO, Coffee.FLAT_WHITE, Coffee.CAPPUCCINO, Coffee.BLACK, Coffee.INSTANT)
    }
}

class HandPress: CoffeeMachine {

    override fun brew(coffee: Coffee) {

    }

    override fun getMenu(): List<Coffee> {
        return listOf(Coffee.ESPRESSO)
    }
}

class Nescafe: CoffeeMachine {

    override fun brew(coffee: Coffee) {

    }

    override fun getMenu(): List<Coffee> {
        return listOf(Coffee.ESPRESSO, Coffee.AMERICANO, Coffee.BLACK, Coffee.INSTANT)
    }
}

enum class Coffee {
    ESPRESSO,
    AMERICANO,
    CAPPUCCINO,
    FLAT_WHITE,
    BLACK,
    INSTANT
}

class BrewingViewModel(
    private val brewingMachine: CoffeeMachine
) {

    private var selectedCoffee: Coffee? = null

    init {

    }

    fun brew() {
        selectedCoffee?.let {
            brewingMachine.brew(it)
        }
    }

    fun setSelectedCoffee(coffee: Coffee) {
        selectedCoffee = coffee
    }

}

