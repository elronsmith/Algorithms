package search

import data.User

/**
 * Требования:
 * - список должен быть отсортирован
 */
fun ArrayList<User>.binarySearch(name: String, _left: Int = 0, _right: Int = size - 1): Int? {
    if (_left > _right) return null

    var left = _left
    var right = _right
    var mid = (left + right) / 2

    while (true) {
        val result = name.compareTo(this[mid].name)
        when {
            result == 0 -> return mid
            result < 0 -> right = mid
            result > 0 -> left = mid
        }

        if (left == right)
            return null
        else if (right - left == 1) {
            if (this[left].name.equals(name))
                return left
            else if (this[right].name.equals(name))
                return right
            return null
        }
        mid = (left + right) / 2
    }

    return null
}

fun ArrayList<User>.binarySearchR(name: String, left: Int = 0, right: Int = size - 1): Int? {
    if (right >= left) {
        val mid = left + (right - left / 2)

        val m = this[mid]

        if (name.equals(m.name))
            return mid

        if (m.name > name)
            return binarySearchR(name, left, mid - 1)

        return binarySearchR(name, mid + 1, right)
    }

    return null
}
