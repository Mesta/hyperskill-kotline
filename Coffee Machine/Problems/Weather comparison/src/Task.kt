class City(val name: String) {
    var degrees: Int = 0
        set(value) {
            field = if (value in -92..57) value else when (name) {
                "Dubai" -> 30
                "Hanoi" -> 20
                "Moscow" -> 5
                else -> value
            }
        }

    fun isMinOf(other1: City, other2: City): Boolean {
        return this.degrees < other1.degrees && this.degrees < other2.degrees
    }
}

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    // implement comparing here
    print(when {
        firstCity.isMinOf(secondCity, thirdCity) -> firstCity.name
        secondCity.isMinOf(firstCity, thirdCity) -> secondCity.name
        thirdCity.isMinOf(firstCity, secondCity) -> thirdCity.name
        else -> "neither"
    })
}