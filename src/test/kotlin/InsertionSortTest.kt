import org.junit.Test
import sort.insertionSort
import kotlin.system.measureTimeMillis

class InsertionSortTest {
    @Test
    fun testEasy() {
        Repository.loadDbEasy()

        val sortingTime: Long = measureTimeMillis {
            Repository.DB_LIST.insertionSort()
        }

        println("Insertion sort time: ${formatTime(sortingTime)}")
        val isSorted = Repository.DB_LIST.isSortedAscending()
        assert(isSorted)
    }

    @Test
    fun testMeduim() {
        Repository.loadDbMeduim()

        val sortingTime: Long = measureTimeMillis {
            Repository.DB_LIST.insertionSort()
        }

        println("Insertion sort time: ${formatTime(sortingTime)}")
        val isSorted = Repository.DB_LIST.isSortedAscending()
        assert(isSorted)
    }

    @Test
    fun test() {
        Repository.loadDb()

        val sortingTime: Long = measureTimeMillis {
            Repository.DB_LIST.insertionSort()
        }

        println("Insertion sort time: ${formatTime(sortingTime)}")
        val isSorted = Repository.DB_LIST.isSortedAscending()
        assert(isSorted)
    }
}