package org.example.coffebrewer.usecase

import org.example.coffebrewer.ui.AddonsSelectionState
import org.example.coffebrewer.ui.BrewingState
import org.example.coffebrewer.ui.CoffeeSelectionState
import org.example.coffebrewer.ui.CoffeeShopState
import org.example.coffebrewer.ui.FinalState
import org.example.coffebrewer.ui.InitialState
import org.example.coffebrewer.ui.MachineSelectionState

class CoffeeShopViewModel() {
    private var shopState: CoffeeShopState = InitialState
    private var selectedBrewer: CoffeeBrewer? = null
    private var selectedCoffee: Coffee? = null
    private var selectedExtras: List<CoffeeExtras> = listOf()
    
    fun setSelectedCoffeeMachine(machine: CoffeeMachine) {
        selectedBrewer = MachineFactory.createMachine(machine)
    }

    fun setSelectedCoffee(coffee: Coffee) {
        selectedCoffee = coffee
    }

    fun getMenu() = selectedBrewer?.getMenu() ?: listOf()
    
    fun setExtras(extras: List<CoffeeExtras>) {
        selectedExtras = extras
    }
    
    fun nextState() {
        shopState = when (shopState) {
            is InitialState -> MachineSelectionState
            is MachineSelectionState -> CoffeeSelectionState(
                machine = selectedBrewer!!
            )
            is CoffeeSelectionState -> AddonsSelectionState(
                machine = selectedBrewer!!,
                coffee = selectedCoffee!!
            )
            is AddonsSelectionState -> BrewingState(
                machine = selectedBrewer!!,
                coffee = selectedCoffee!!,
                extras = selectedExtras
            )
            is BrewingState -> TODO()
            is FinalState -> TODO()
        }
    }
    
    fun previousState() {
        shopState =  when (shopState) {
            is InitialState -> MachineSelectionState
            is MachineSelectionState -> InitialState
            is CoffeeSelectionState -> {
                selectedBrewer = null
                MachineSelectionState
            }
            is AddonsSelectionState -> {
                selectedCoffee = null
                CoffeeSelectionState(
                    machine = selectedBrewer!!
                )
            }
            is BrewingState -> {
                selectedExtras = listOf()
                AddonsSelectionState(
                    machine = selectedBrewer!!,
                    coffee = selectedCoffee!!
                )
            }
            is FinalState -> BrewingState(
                machine = selectedBrewer!!,
                coffee = selectedCoffee!!,
                extras = selectedExtras
            )
        }
    }
}

object MachineFactory {
    
    fun createMachine(machine: CoffeeMachine) = when (machine) {
            CoffeeMachine.DeLonghi -> DeLonghi()
            CoffeeMachine.HandPress -> HandPress()
            CoffeeMachine.FrenchPress -> TODO()
            CoffeeMachine.Nescafe -> Nescafe()
            CoffeeMachine.Quchi -> QuchiCoffee()
    }
}
