package chapter13

import org.junit.jupiter.api.Test

internal class QuickSortTest {
    @Test
    fun test() {
        val array = intArrayOf(0, 5, 2, 1, 6, 3)
        quickSort(array, 0, array.size - 1)
        println(array.joinToString())
    }

    fun quickSort(arr: IntArray, left: Int, right: Int) {
        if (left >= right) return  // 종료 조건

        val pivotIndex = partition(arr, left, right)
        quickSort(arr, left, pivotIndex - 1)
        quickSort(arr, pivotIndex + 1, right)
    }

    fun partition(arr: IntArray, left: Int, right: Int): Int {
        val pivot = arr[right]
        var i = left - 1

        for (j in left until right) {
            if (arr[j] <= pivot) {
                i++
                swap(arr, i, j)
            }
        }
        swap(arr, i + 1, right)
        return i + 1
    }

    fun swap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}