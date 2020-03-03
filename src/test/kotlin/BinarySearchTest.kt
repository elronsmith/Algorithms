import org.junit.Before
import org.junit.Test
import search.binarySearch
import sort.quickSort
import kotlin.system.measureTimeMillis

class BinarySearchTest {
    @Before
    fun before() = Repository.load()

    @Test
    fun test() {
        assert(Repository.DB_LIST.size > 0)
        val sortingTime: Long = measureTimeMillis {
            Repository.DB_LIST.quickSort()
        }
        println("Quick sort time: ${formatTime(sortingTime)}")
        assert(Repository.DB_LIST.isSortedAscending())

        var count = 0
        val time = measureTimeMillis {
            for (name in Repository.FIND_LIST)
                if (Repository.DB_LIST.binarySearch(name) != null)
                    count++
        }

        printFound(count, Repository.FIND_LIST.size, time)
        assert(count == Repository.FIND_LIST.size)
    }
}