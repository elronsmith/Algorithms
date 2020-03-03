import org.junit.Test
import sort.selectionSort
import kotlin.system.measureTimeMillis

class SelectionSortTest {
    @Test
    fun testEasy() {
        Repository.loadDbEasy()

        val sortingTime: Long = measureTimeMillis {
            Repository.DB_LIST.selectionSort()
        }

        println("Selection sort time: ${formatTime(sortingTime)}")
        val isSorted = Repository.DB_LIST.isSortedAscending()
        assert(isSorted)
    }

    @Test
    fun testMeduim() {
        Repository.loadDbMeduim()

        val sortingTime: Long = measureTimeMillis {
            Repository.DB_LIST.selectionSort()
        }

        println("Selection sort time: ${formatTime(sortingTime)}")
        val isSorted = Repository.DB_LIST.isSortedAscending()
        assert(isSorted)
    }

    @Test
    fun test() {
        Repository.loadDb()

        val sortingTime: Long = measureTimeMillis {
            Repository.DB_LIST.selectionSort()
        }

        println("Selection sort time: ${formatTime(sortingTime)}")
        val isSorted = Repository.DB_LIST.isSortedAscending()
        assert(isSorted)
    }
}