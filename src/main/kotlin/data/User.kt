package data

class User(var number: Int, var name: String): Comparable<User> {
    override fun compareTo(other: User): Int = this.name.compareTo(other.name)

    fun swap(other: User) {
        val numberTemp = this.number
        val nameTemp = this.name
        this.number = other.number
        this.name = other.name
        other.number = numberTemp
        other.name = nameTemp
    }
}
