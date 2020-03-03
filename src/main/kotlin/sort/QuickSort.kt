package sort

import data.User

/**
 * Алгоритм:
 * 1. Выберите какой-нибудь элемент из массива. Мы будем называть этот элемент ОСНОВА
 * 2. Переупорядочьте массив так, чтобы все значения, меньшие, чем ОСНОВА,
 *    были расположены перед ним, а все большие значения следовали после;
 *    равные значения могут идти в любую сторону
 * 3. Рекурсивно сортируйте подмассивы меньших и больших элементов
 */
fun ArrayList<User>.quickSort(left: Int = 0, right: Int = this.size - 1) {
    if (left < right) {
        val pi = quickSortPartition(left, right)

        quickSort(left, pi - 1)
        quickSort(pi + 1, right)
    }
}

private fun ArrayList<User>.quickSortPartition(left: Int, right: Int): Int {
    val pivot = this[right]
    var i = left - 1

    for (j in left until right) {
        if (this[j] < pivot) {
            i++
            this[i].swap(this[j])
        }
    }

    this[i + 1].swap(this[right])
    return i + 1
}
