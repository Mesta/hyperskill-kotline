class Application(val name: String) {

    fun run(args: Array<String>) {
        println(this.name)
        args.map(fun(arg: String) {
            println(arg)
        })
    }
}