class Greeting {
    fun greet(): String {
        return "Hello, ${System.getProperty("os.name")}"
    }
}