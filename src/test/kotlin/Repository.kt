import data.User
import java.io.File

object Repository {
    private val DB_FILE   = File("src/test/resources/db.txt")
    private val FIND_FILE = File("src/test/resources/find.txt")

    val DB_LIST = ArrayList<User>(1_240_000)
    var FIND_LIST = ArrayList<String>(0)
        get() = field

    fun load() {
        loadDb()
        loadFind()
    }

    fun loadDb() {
        DB_LIST.clear()
        val dbString = DB_FILE.readText()
        val list = dbString.split("\r\n")
        for (line in list) {
            val spaceIndex = line.indexOf(" ")
            if (spaceIndex > 0) {
                val number = line.substring(0, spaceIndex)
                val name = line.substring(spaceIndex + 1)
                DB_LIST.add(User(number.toInt(), name))
            }
        }
    }

    fun loadDbEasy() {
        DB_LIST.clear()
        DB_LIST.add(User(3, "C"))
        DB_LIST.add(User(2, "B"))
        DB_LIST.add(User(1, "A"))
        DB_LIST.add(User(6, "F"))
        DB_LIST.add(User(5, "E"))
        DB_LIST.add(User(4, "D"))
    }

    fun loadDbMeduim() {
        DB_LIST.clear()
        val dbString = DB_FILE.readText()
        val list = dbString.split("\r\n")
        val max = 1000
        var count = 0
        for (line in list) {
            val spaceIndex = line.indexOf(" ")
            if (spaceIndex > 0) {
                val number = line.substring(0, spaceIndex)
                val name = line.substring(spaceIndex + 1)
                DB_LIST.add(User(number.toInt(), name))
                count++
                if (count >= max)
                    return
            }
        }
    }

    fun loadFind() {
        val findString = FIND_FILE.readText()
        FIND_LIST = findString.split("\r\n") as ArrayList<String>
    }
}

/**
 * @return true если отсортирован по возрастания
 */
fun ArrayList<User>.isSortedAscending(): Boolean {
    for (i in 0 until lastIndex)
        if (this[i] > this[i+1])
            return false

    return true
}

fun ArrayList<User>.printInOneLine() {
    for (user in this)
        print("${user.name} ")
    println()
}
