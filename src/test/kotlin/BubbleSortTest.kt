import org.junit.Test
import sort.bubbleSort
import kotlin.system.measureTimeMillis

class BubbleSortTest {
    /**
     * Очень долго сортирует
     */
    @Test
    fun test() {
        Repository.loadDb()

        val sortingTime: Long = measureTimeMillis {
            Repository.DB_LIST.bubbleSort()
        }

        println("Bubble sort time: ${formatTime(sortingTime)}")
        val isSorted = Repository.DB_LIST.isSortedAscending()
        assert(isSorted)
    }

    @Test
    fun testEasy() {
        Repository.loadDbEasy()

        val sortingTime: Long = measureTimeMillis {
            Repository.DB_LIST.bubbleSort()
        }

        println("Bubble sort time: ${formatTime(sortingTime)}")
        val isSorted = Repository.DB_LIST.isSortedAscending()
        assert(isSorted)
    }
}