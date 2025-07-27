import org.junit.jupiter.api.Test
import java.util.Hashtable

class QuickSortTest {
    @Test
    fun test() {
        val arr = intArrayOf(3, 1, 5, 2, 4)
        quickSort(arr)
    }

    fun quickSort(arr: IntArray, low: Int = 0, high: Int = arr.size - 1) {
        if (low < high) {
            val pivotIndex = partition(arr, low, high)
            quickSort(arr, low, pivotIndex - 1)
            quickSort(arr, pivotIndex + 1, high)
        }
    }

    private fun partition(arr: IntArray, low: Int, high: Int): Int {
        println("[PARTITION]")
        // 마지막 값을 pivot으로 선택
        val pivot = arr[high]
        var i = low

        for (j in low until high) {
            if (arr[j] < pivot) {
                println("\t[SWAP] arr[$i] = ${arr[i]}, arr[$j] = ${arr[j]}")
                arr.swap(i, j)
                i++
            }
        }

        // pivot을 올바른 위치로 이동
        arr.swap(i, high)
        println()
        return i
    }

    // swap 함수 확장
    private fun IntArray.swap(i: Int, j: Int) {
        println("\t[BEFORE] ${this.joinToString(prefix = "[", postfix = "]")}")
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
        println("\t[AFTER] ${this.joinToString(prefix = "[", postfix = "]")}")
    }
}