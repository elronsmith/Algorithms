package search

import data.User

fun ArrayList<User>.linearSearch(name: String): User? {
    for (item in this)
        if (name.equals(item.name))
            return item

    return null
}
