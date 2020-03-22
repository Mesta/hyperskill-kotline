package machine

import kotlin.system.exitProcess

data class CoffeeMachineState(
        val quantityOfWater: Int,
        val quantityOfMilk: Int,
        val quantityOfCoffeeBeans: Int,
        val quantityOfCups: Int,
        val quantityOfMoney: Int
)

data class RecipePrerequisite(
        val water: Int,
        val milk: Int,
        val coffeeBeans: Int,
        val cups: Int
)

fun main() {
    startCoffeeMachine(CoffeeMachineState(400, 540, 120, 9, 550))
}

fun printReport(coffeeMachineState: CoffeeMachineState) {
    println("The coffee machine has:")
    println("${coffeeMachineState.quantityOfWater} of water")
    println("${coffeeMachineState.quantityOfMilk} of milk")
    println("${coffeeMachineState.quantityOfCoffeeBeans} of coffee beans")
    println("${coffeeMachineState.quantityOfCups} of disposable cups")
    println("$${coffeeMachineState.quantityOfMoney} of money")
}

fun startCoffeeMachine(coffeeMachineState: CoffeeMachineState): CoffeeMachineState {
    println("Write action (buy, fill, take, remaining, exit):")
    val action: String = readLine().toString()

    var newCoffeeMachineState: CoffeeMachineState = coffeeMachineState.copy()
    when (action) {
        "buy" -> newCoffeeMachineState = buy(coffeeMachineState)
        "fill" -> newCoffeeMachineState = fill(coffeeMachineState)
        "take" -> newCoffeeMachineState = take(coffeeMachineState)
        "remaining" -> printReport(coffeeMachineState)
        "exit" -> exitProcess(0)
    }

    return startCoffeeMachine(newCoffeeMachineState)
}

fun take(coffeeMachineState: CoffeeMachineState): CoffeeMachineState {
    println("I gave you $${coffeeMachineState.quantityOfMoney}")
    return CoffeeMachineState(
            coffeeMachineState.quantityOfWater,
            coffeeMachineState.quantityOfMilk,
            coffeeMachineState.quantityOfCoffeeBeans,
            coffeeMachineState.quantityOfCups,
            0
    )
}

fun buy(coffeeMachineState: CoffeeMachineState): CoffeeMachineState {
    var newCoffeeMachineState: CoffeeMachineState = coffeeMachineState.copy();

    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
    val action: String = readLine().toString()
    when (action) {
        "1" -> newCoffeeMachineState = buyEspresso(coffeeMachineState)
        "2" -> newCoffeeMachineState = buyLatte(coffeeMachineState)
        "3" -> newCoffeeMachineState = buyCappuccino(coffeeMachineState)
    }

    return newCoffeeMachineState
}

fun buyEspresso(coffeeMachineState: CoffeeMachineState): CoffeeMachineState {
    if (checkPrerequisites(coffeeMachineState, RecipePrerequisite(250, 0, 16, 1))) {
        return CoffeeMachineState(
                coffeeMachineState.quantityOfWater - 250,
                coffeeMachineState.quantityOfMilk,
                coffeeMachineState.quantityOfCoffeeBeans - 16,
                coffeeMachineState.quantityOfCups - 1,
                coffeeMachineState.quantityOfMoney + 4
        )
    } else {
        return coffeeMachineState
    }
}

fun buyLatte(coffeeMachineState: CoffeeMachineState): CoffeeMachineState {
    if (checkPrerequisites(coffeeMachineState, RecipePrerequisite(350, 75, 20, 1))) {
        return CoffeeMachineState(
                coffeeMachineState.quantityOfWater - 350,
                coffeeMachineState.quantityOfMilk - 75,
                coffeeMachineState.quantityOfCoffeeBeans - 20,
                coffeeMachineState.quantityOfCups - 1,
                coffeeMachineState.quantityOfMoney + 7
        )
    } else {
        return coffeeMachineState
    }
}

fun buyCappuccino(coffeeMachineState: CoffeeMachineState): CoffeeMachineState {
    if (checkPrerequisites(coffeeMachineState, RecipePrerequisite(200, 100, 12, 1))) {
        return CoffeeMachineState(
                coffeeMachineState.quantityOfWater - 200,
                coffeeMachineState.quantityOfMilk - 100,
                coffeeMachineState.quantityOfCoffeeBeans - 12,
                coffeeMachineState.quantityOfCups - 1,
                coffeeMachineState.quantityOfMoney + 6
        )
    } else {
        return coffeeMachineState
    }

}

fun fill(coffeeMachineState: CoffeeMachineState): CoffeeMachineState {
    println("Write how many ml of water do you want to add")
    val addedQuantityOfWater: Int = readLine().toString().toInt()

    println("Write how many ml of milk do you want to add")
    val addedQuantityOfMilk: Int = readLine().toString().toInt()

    println("Write how many gramsof coffee beans do you want to add")
    val addedQuantityOfCoffeeBeans: Int = readLine().toString().toInt()

    println("Write how many disposable cups of coffee do you want to add")
    val addedQuantityOfCups: Int = readLine().toString().toInt()

    return CoffeeMachineState(
            coffeeMachineState.quantityOfWater + addedQuantityOfWater,
            coffeeMachineState.quantityOfMilk + addedQuantityOfMilk,
            coffeeMachineState.quantityOfCoffeeBeans + addedQuantityOfCoffeeBeans,
            coffeeMachineState.quantityOfCups + addedQuantityOfCups,
            coffeeMachineState.quantityOfMoney
    )
}

fun checkPrerequisites(coffeeMachineState: CoffeeMachineState, recipePrerequisite: RecipePrerequisite): Boolean {
    var enoughIngredients = true
    if (coffeeMachineState.quantityOfWater < recipePrerequisite.water) {
        println("Sorry, not enough water!")
        enoughIngredients = false
    }

    if (coffeeMachineState.quantityOfMilk < recipePrerequisite.milk) {
        println("Sorry, not enough milk!")
        enoughIngredients = false
    }

    if (coffeeMachineState.quantityOfCoffeeBeans < recipePrerequisite.coffeeBeans) {
        println("Sorry, not enough coffee beans!")
        enoughIngredients = false
    }

    if (coffeeMachineState.quantityOfCups < recipePrerequisite.cups) {
        println("Sorry, not enough cup of coffee!")
        enoughIngredients = false
    }

    if (enoughIngredients) {
        println("I have enough resources, making you a coffee!")
    }

    return enoughIngredients
}
