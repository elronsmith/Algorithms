package sort

import data.User

/**
 * Алгоритм:
 * - Он многократно проходит по массиву для сортировки, сравнивает каждую пару
 *   смежных элементов и меняет их местами, если они находятся в неправильном порядке
 * Пример: 21 23 19 30 11 28
 *         21 19 23 30 11 28
 *         21 19 23 11 30 28
 *         21 19 23 11 28 30
 *         19 21 23 11 28 30
 *         19 21 11 23 28 30
 *         19 11 21 23 28 30
 *         11 19 21 23 28 30
 * @return true если поностью выполнился, false если время истекло
 */
fun ArrayList<User>.bubbleSort(maxTime: Long = Long.MAX_VALUE): Boolean {
    val startTime = System.currentTimeMillis()
    var currentTime: Long = 0
    for (end in lastIndex - 1 downTo 1) {
        for (i in 0..end) {
            val p1 = this[i]
            val p2 = this[i + 1]
            if (p1 > p2)
                p1.swap(p2)
        }
        currentTime = System.currentTimeMillis()
        if (currentTime - startTime > maxTime)
            return false
    }

    return true
}
