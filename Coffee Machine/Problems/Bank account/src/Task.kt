class BankAccount(public val deposited: Long, public val withdrawn: Long) {
    val balance: Long

    init {
        this.balance = deposited - withdrawn
    }
}