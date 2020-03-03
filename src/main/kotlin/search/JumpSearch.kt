package search

import data.User

/**
 * Требования:
 * - список должен быть отсортирован
 */
fun ArrayList<User>.jumpSearch(name: String): Int? {
    val blockSize = Math.sqrt(this.size.toDouble()).toInt()
    val blocksCount = if (this.size % blockSize == 0) this.size / blockSize else (this.size / blockSize) + 1

    for (i in 1..blocksCount) {
        val begin = blockSize * (i - 1)
        var end = (blockSize * i) - 1
        if (end >= size)
            end = size - 1

        val item = this[end]
        if (name.compareTo(item.name) <= 0) {
            val index = jumpSearch(name, begin, end)
            if (index != null)
                return index
        }
    }

    return null
}

private fun ArrayList<User>.jumpSearch(name: String, begin: Int, end: Int): Int? {
    for (i in end downTo begin)
        if (this[i].name.equals(name))
            return i

    return null
}
