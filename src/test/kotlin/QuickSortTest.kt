import org.junit.Test
import sort.quickSort
import kotlin.system.measureTimeMillis

class QuickSortTest {
    @Test
    fun test() {
        Repository.loadDb()

        val sortingTime: Long = measureTimeMillis {
            Repository.DB_LIST.quickSort()
        }

        println("Quick sort time: ${formatTime(sortingTime)}")
        val isSorted = Repository.DB_LIST.isSortedAscending()
        assert(isSorted)
    }

    @Test
    fun testEasy() {
        Repository.loadDbEasy()

        val sortingTime: Long = measureTimeMillis {
            Repository.DB_LIST.quickSort()
        }

        println("Quick sort time: ${formatTime(sortingTime)}")
        val isSorted = Repository.DB_LIST.isSortedAscending()
        assert(isSorted)
    }
}