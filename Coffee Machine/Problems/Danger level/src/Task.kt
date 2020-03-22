enum class DangerLevel(val dlevel: Int) {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    fun getLevel(): Int {
        return dlevel
    }
}