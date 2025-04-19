package org.example.coffebrewer.ui

import org.example.coffebrewer.usecase.Coffee
import org.example.coffebrewer.usecase.CoffeeBrewer
import org.example.coffebrewer.usecase.CoffeeExtras
import org.example.coffebrewer.usecase.CoffeeMachine

sealed class CoffeeShopState

data object InitialState : CoffeeShopState()

data object MachineSelectionState : CoffeeShopState()

class CoffeeSelectionState(
    val machine: CoffeeBrewer
): CoffeeShopState()

class AddonsSelectionState(
    val machine: CoffeeBrewer,
    val coffee: Coffee
): CoffeeShopState()

class BrewingState(
    val machine: CoffeeBrewer,
    val coffee: Coffee,
    val extras: List<CoffeeExtras>
): CoffeeShopState()

data object FinalState : CoffeeShopState()
