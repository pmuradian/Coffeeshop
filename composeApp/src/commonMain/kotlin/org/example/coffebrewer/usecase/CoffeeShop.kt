package org.example.coffebrewer.usecase

interface CoffeeBrewer {
    fun brew(coffee: Coffee)
    fun getMenu(): List<Coffee>
}

class DeLonghi: CoffeeBrewer {

    override fun brew(coffee: Coffee) {

    }

    override fun getMenu(): List<Coffee> {
        return listOf(Coffee.ESPRESSO, Coffee.AMERICANO, Coffee.FLAT_WHITE, Coffee.CAPPUCCINO)
    }
}

class QuchiCoffee: CoffeeBrewer {

    override fun brew(coffee: Coffee) {

    }

    override fun getMenu(): List<Coffee> {
        return listOf(Coffee.ESPRESSO, Coffee.AMERICANO, Coffee.FLAT_WHITE, Coffee.CAPPUCCINO, Coffee.BLACK, Coffee.INSTANT)
    }
}

class HandPress: CoffeeBrewer {

    override fun brew(coffee: Coffee) {

    }

    override fun getMenu(): List<Coffee> {
        return listOf(Coffee.ESPRESSO)
    }
}

class Nescafe: CoffeeBrewer {

    override fun brew(coffee: Coffee) {

    }

    override fun getMenu(): List<Coffee> {
        return listOf(Coffee.ESPRESSO, Coffee.AMERICANO, Coffee.BLACK, Coffee.INSTANT)
    }
}