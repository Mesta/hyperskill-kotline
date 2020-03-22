fun main() {
    val timerValue = readLine()!!.toInt()
    val timer = ByteTimer(timerValue)
    println(timer.time)
}

class ByteTimer(time: Int) {
    var time = time
        get() {
            return when {
                field < -128 -> -128
                field > 127 -> 127
                else -> field
            }
        }
}