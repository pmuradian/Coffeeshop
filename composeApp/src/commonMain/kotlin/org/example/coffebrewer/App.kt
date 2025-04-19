package org.example.coffebrewer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.example.coffebrewer.ui.BrewingMachineSelectionScreen
import org.example.coffebrewer.ui.CoffeeSelectionScreen
import org.example.coffebrewer.ui.ExtrasSelectionScreen
import org.example.coffebrewer.ui.ExtrasViewModel
import org.example.coffebrewer.usecase.CoffeeShopViewModel
import org.example.coffebrewer.ui.NavigationBar
import org.example.coffebrewer.ui.Screens
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    navController: NavHostController = rememberNavController(),
    viewModel: CoffeeShopViewModel = CoffeeShopViewModel()
) {
    MaterialTheme {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentScreen = Screens.valueOf(
            backStackEntry?.destination?.route ?: Screens.MachineSelection.name
        )

        Scaffold(
            topBar = {
                NavigationBar(
                    modifier = Modifier.background(Color.White),
                    currentScreen = currentScreen,
                    canNavigateBack = navController.previousBackStackEntry != null,
                    navigateUp = {
                        navController.navigateUp()
                        viewModel.previousState()
                    }
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Screens.MachineSelection.name,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding)
            ) {
                composable(route = Screens.MachineSelection.name) {
                    BrewingMachineSelectionScreen(
                        onMachineSelected = { machine ->
                            viewModel.setSelectedCoffeeMachine(machine)
                            viewModel.nextState()
                            navController.navigate(Screens.CoffeeSelection.name)
                        }
                    )
                }
                composable(route = Screens.CoffeeSelection.name) {
                    CoffeeSelectionScreen(
                        coffeeMenu = viewModel.getMenu(),
                        onCoffeeSelected = { coffee ->
                            viewModel.setSelectedCoffee(coffee)
                            viewModel.nextState()
                            navController.navigate(Screens.Addons.name)
                        }
                    )
                }
                composable(route = Screens.Addons.name) {
                    ExtrasSelectionScreen(
                        onExtrasSelected = {
                            viewModel.nextState()
                        },
                        extrasViewModel = ExtrasViewModel()
                    )
                }
            }
        }

    }
}

