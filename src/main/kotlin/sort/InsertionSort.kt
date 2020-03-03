package sort

import data.User

/**
 * Алгоритм:
 * 1. Предположим, что первый элемент принадлежит отсортированной части массива,
 *    а все остальные элементы находятся в несортированной части
 * 2. Выберите первый элемент из несортированной части и вставьте этот элемент
 *    в отсортированный список в подходящей позиции
 * 3. Повторите шаги 1-2, пока все элементы не будут отсортированы
 * Пример: 21 23 19 30 11 28
 *         19 21 23 30 11 28
 *         11 19 21 23 30 28
 *         11 19 21 23 30 28
 *         11 19 21 23 28 30
 */
fun ArrayList<User>.insertionSort() {
    if (this[0] > this[1]) this[0].swap(this[1])

    for (i in 2..lastIndex) {
        val user = this[i]
        if (user > this[i-1]) continue
        var index = 0
        loop2@for (j in i-1 downTo 0) {
            if (user > this[j]) {
                index = j + 1
                break@loop2
            }
        }
        this.removeAt(i)
        this.add(index, user)
    }
}
