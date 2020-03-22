fun main() {
    val input = readLine()!!
    val toDisplay: String

    toDisplay = when {
        input.isEmpty() -> {
            input
        }
        input.first() == 'i' -> {
            val dropped = input.drop(1)
            (dropped.toInt() + 1).toString()
        }
        input.first() == 's' -> {
            val dropped = input.drop(1)
            dropped.reversed()
        }
        else -> {
            input
        }
    }

    println(toDisplay)
}