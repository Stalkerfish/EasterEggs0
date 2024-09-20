abstract class Item {
    open val locus: Enum<*>? = null
    open val name: String? = locus?.name

    abstract fun useItem()
}