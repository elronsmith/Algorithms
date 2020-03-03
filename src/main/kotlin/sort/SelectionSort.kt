package sort

import data.User

/**
 * Алгоритм:
 * 1. Находим наименьший элемент во всем массиве и заменяет его элементом на первой позиции
 * 2. Затем он находит второй наименьший элемент и заменяет его элементом на второй позиции
 * 3. Это продолжается до тех пор, пока весь массив не будет отсортирован
 * Если мы хотим отсортировать массив в порядке убывания,
 * мы должны искать самый большой элемент вместо самого маленького
 * Пример: 21 23 19 30 11 28
 *         11 23 19 30 21 28
 *         11 19 23 30 21 28
 *         11 19 21 30 23 28
 *         11 19 21 23 30 28
 *         11 19 21 23 28 30
 */
fun ArrayList<User>.selectionSort() {
    var index = 0

    while (index <= size) {
        val minIndex = getMinIndex(index)
        if (index != minIndex)
            this[minIndex].swap(this[index])

        index++
    }
}

private fun ArrayList<User>.getMinIndex(startIndex: Int): Int {
    var minIndex = startIndex

    for (i in minIndex + 1..lastIndex)
        if (this[i] < this[minIndex])
            minIndex = i

    return minIndex
}