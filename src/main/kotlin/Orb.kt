data class Orb(
    override val locus: Room,  // Instead of a Class, use a Room identifier
    override val name: String = locus.name,
    val onNavigate: (Room) -> Unit
) : Item() {

    private fun useOrb(orb: Orb, onNavigate: (Room) -> Unit) {
        onNavigate(orb.locus) // Navigate to the screen associated with the Orb
    }

    override fun useItem() {
        useOrb(orb = this, onNavigate)
    }
}