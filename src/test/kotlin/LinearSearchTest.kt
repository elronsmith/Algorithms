import org.junit.Before
import org.junit.Test
import search.linearSearch
import kotlin.system.measureTimeMillis

class LinearSearchTest {
    @Before fun before() = Repository.load()

    @Test fun test() {
        var count = 0
        val time = measureTimeMillis {
            for (name in Repository.FIND_LIST)
                if (Repository.DB_LIST.linearSearch(name) != null)
                    count++
        }

        printFound(count, Repository.FIND_LIST.size, time)
        assert(count == Repository.FIND_LIST.size)
    }
}